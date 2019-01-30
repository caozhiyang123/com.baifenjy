package cn.itcast.web.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.util.concurrent.AtomicDouble;

import cn.itcast.web.dao.RtpDao;
import cn.itcast.web.util.ThreadLocalSimple;
import cn.itcast.web.vo.RoundStatistics;
import cn.itcast.web.vo.RoundStatisticsSlot;
import cn.itcast.web.vo.SlotRtpResult;
import cn.itcast.web.vo.VBRtpResult;


@Service
@Transactional(readOnly=true)
public class RtpServiceImpl implements RtpService
{
    @Autowired
    private RtpDao rtpDao;
    
    private static List<Double> rtps = new ArrayList<>();
    private static List<Double> baseRTPs = new ArrayList<>();
    private static List<Double> ebRTPs = new ArrayList<>();
    
    @Override
    public VBRtpResult queryVbRtpByGameId(int gameId, String timeFrom, String timeTo)
    {
        VBRtpResult vbRtpResult = null;
        
        List<RoundStatistics> roundStatistics = rtpDao.queryVbRtpByGameId(gameId, timeFrom, timeTo);
        if(roundStatistics.size() == 0)
        {
            return vbRtpResult; 
        }else{
            vbRtpResult = new VBRtpResult();
        }
        for (RoundStatistics roundStatistic : roundStatistics)
        {
            vbRtpResult.setTotalWon(vbRtpResult.getTotalWon() + roundStatistic.getTotalWonOnRound());
            vbRtpResult.setTotalBaseWon(vbRtpResult.getTotalBaseWon() + roundStatistic.getWinBaseGame());
            vbRtpResult.setTotalEbWon(vbRtpResult.getTotalEbWon() + roundStatistic.getWinBaseGame());
            vbRtpResult.setTotalSpent(vbRtpResult.getTotalSpent() + roundStatistic.getTotalSpentOnRound());
            vbRtpResult.setTotalBseSpent(vbRtpResult.getTotalBseSpent() + roundStatistic.getSpentBaseGame());
            vbRtpResult.setTotalEbSpent(vbRtpResult.getTotalEbSpent() + roundStatistic.getSpentOnExtraBall());
        }
        if(vbRtpResult.getTotalSpent() > 0){
            BigDecimal totalRtpBg = new BigDecimal((double)vbRtpResult.getTotalWon()/(double)vbRtpResult.getTotalSpent());
            vbRtpResult.setTotalRTP(totalRtpBg.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        }else{
            vbRtpResult.setTotalRTP(0.00);
        }
        
        if(vbRtpResult.getTotalBseSpent() > 0){
            BigDecimal totalBaseRtpBg = new BigDecimal((double)vbRtpResult.getTotalBaseWon()/(double)vbRtpResult.getTotalBseSpent());
            vbRtpResult.setTotalBaseRTP(totalBaseRtpBg.setScale(3,BigDecimal.ROUND_HALF_UP).doubleValue());
        }else{
            vbRtpResult.setTotalBaseRTP(0.00);
        }
        
        if(vbRtpResult.getTotalEbSpent()>0){
            BigDecimal totalEbRtpBg = new BigDecimal((double)vbRtpResult.getTotalEbWon()/(double)vbRtpResult.getTotalEbSpent());
            vbRtpResult.setTotalEBRTP(totalEbRtpBg.setScale(3,BigDecimal.ROUND_HALF_UP).doubleValue());
        }else{
            vbRtpResult.setTotalEBRTP(0.00);
        }
        
        vbRtpResult.setTotalSpins(roundStatistics.size());
        
        vbRtpResult.setUser_count(rtpDao.queryUserCountByTime(gameId, timeFrom, timeTo));
        
        vbRtpResult.setJackpotCount(rtpDao.querJackpotCountByTime(gameId, timeFrom, timeTo));
        
        // - - - - - - - dynamic data - - - - - - -
        try
        {
            Calendar calendarFrom = Calendar.getInstance();
            calendarFrom.setTime(ThreadLocalSimple.df.get().parse(timeFrom));
            
            Calendar calendarAt12 = Calendar.getInstance();
            calendarAt12.set(calendarFrom.get(Calendar.YEAR), calendarFrom.get(Calendar.MONTH), calendarFrom.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
            
            Calendar calendarTo = Calendar.getInstance();
            calendarFrom.setTime(ThreadLocalSimple.df.get().parse(timeTo));
            
            rtpStatistics(gameId, timeFrom, timeTo, vbRtpResult, calendarAt12, calendarTo);
            
            return vbRtpResult;
            
        } catch (ParseException e)
        {
            e.printStackTrace();
        }
        return vbRtpResult;
    }

    public void rtpStatistics(int gameId, String timeFrom, String timeTo, VBRtpResult vbRtpResult,
            Calendar calendarAt12, Calendar calendarTo)
    {
        try
        {
            if(calendarAt12.before(calendarTo)){
                String time12 = ThreadLocalSimple.df.get().format(calendarAt12.getTime());
                List<RoundStatistics> roundStatisticsBetween = rtpDao.queryVbRtpByGameId(gameId, timeFrom, time12);
                CalculateRtp(timeFrom, vbRtpResult, time12, roundStatisticsBetween);
                
                Calendar calendar12New = Calendar.getInstance();
                calendar12New.setTime(ThreadLocalSimple.df.get().parse(time12));
                calendar12New.add(Calendar.DAY_OF_MONTH, 1);
                rtpStatistics(gameId,time12,timeTo,vbRtpResult,calendar12New,calendarTo);
            }else if(calendarAt12.after(calendarTo)){
                List<RoundStatistics> roundStatisticsBetween = rtpDao.queryVbRtpByGameId(gameId, timeFrom, timeTo);
                CalculateRtp(timeFrom, vbRtpResult, timeTo, roundStatisticsBetween);
                
                vbRtpResult.setDeltaRTP(getAverageDelta(rtps,vbRtpResult.getTotalRTP()));
                vbRtpResult.setDeltaEBRTP(getAverageDelta(baseRTPs,vbRtpResult.getTotalBaseRTP()));
                vbRtpResult.setDeltaBaseRTP(getAverageDelta(ebRTPs, vbRtpResult.getTotalEBRTP()));
            }
        } catch (ParseException e)
        {
            e.printStackTrace();
        }
    }
    
    private double getAverageDelta(List<Double> data, double dst)
    {
        if(data.isEmpty())
        {
            return 0;
        }
        double result = 0;
        for(double src: data)
        {
            result += Math.abs(src - dst);
        }

        return result/data.size();
    }


    public void CalculateRtp(String timeFrom, VBRtpResult vbRtpResult, String time12,
            List<RoundStatistics> roundStatisticsBetween)
    {
        long totalWon = 0;
        long totalWonBase = 0;
        long totalWonEb = 0;
        long totalSpent = 0;
        long totalSpentBase = 0;
        long totalSpentEb = 0;
        
        AtomicDouble totalEBSpentWithoutBet = new AtomicDouble(0);
        AtomicDouble totalEBCount = new AtomicDouble(0);
        
        if(roundStatisticsBetween.size() == 0){
            return;
        }
        
        for (RoundStatistics roundStatistic : roundStatisticsBetween)
        {
            totalWon += roundStatistic.getTotalWonOnRound();
            totalWonBase += roundStatistic.getWinBaseGame();
            totalWonEb += roundStatistic.getWinExtraBall();
            totalSpent += roundStatistic.getTotalSpentOnRound();
            totalSpentBase += roundStatistic.getSpentBaseGame();
            totalSpentEb += roundStatistic.getSpentOnExtraBall();
            
            totalEBSpentWithoutBet.addAndGet((double)totalSpentEb/(double)roundStatistic.getCurrentBet());
            totalEBCount.addAndGet(roundStatistic.getExtraBallsCount());
        }
        
        if(totalSpent>0){
            BigDecimal rtpBg = new BigDecimal((double)totalWon/(double)totalSpent);
            double rtp = rtpBg.setScale(3,BigDecimal.ROUND_HALF_UP).doubleValue();
            vbRtpResult.getRtp().put(timeFrom+"-"+time12,rtp);
            rtps.add(rtp);
        }else{
            vbRtpResult.getRtp().put(timeFrom+"-"+time12,0.00);
            rtps.add(0.00);
        }
        
        if(totalSpentBase>0){
            BigDecimal baseRtpBg = new BigDecimal((double)totalWonBase/(double)totalSpentBase);
            double baseRtp = baseRtpBg.setScale(3,BigDecimal.ROUND_HALF_UP).doubleValue();
            vbRtpResult.getBaseRtp().put(timeFrom+"-"+time12, baseRtp);
            baseRTPs.add(baseRtp);
        }else{
            vbRtpResult.getBaseRtp().put(timeFrom+"-"+time12, 0.00);
            baseRTPs.add(0.00);
        }
        
        if(totalSpentEb>0){
            BigDecimal ebRtpBg = new BigDecimal((double)totalWonEb/(double)totalSpentEb);
            double ebRtp = ebRtpBg.setScale(3,BigDecimal.ROUND_HALF_UP).doubleValue();
            vbRtpResult.getEbRtp().put(timeFrom+"-"+time12, ebRtp);
            ebRTPs.add(ebRtp);
        }else{
            vbRtpResult.getEbRtp().put(timeFrom+"-"+time12, 0.00);
            ebRTPs.add(0.00);
        }
        
        if(totalEBCount.get()>0){
            BigDecimal ebPriceBg = new BigDecimal((double)totalEBSpentWithoutBet.get()/(double)totalEBCount.get());
            vbRtpResult.getEbPrice().put(timeFrom+"-"+time12, ebPriceBg.setScale(3,BigDecimal.ROUND_HALF_UP).doubleValue());
        }else{
            vbRtpResult.getEbPrice().put(timeFrom+"-"+time12, 0.00);
        }
        
        
    }
    

    @Override
    public SlotRtpResult querySlotRtpByGameId(int gameId, String timeFrom, String timeTo)
    {
        SlotRtpResult slotRtpResult = null;
        List<RoundStatisticsSlot> roundStatisticsSlotList = rtpDao.querySlotRtpByGameId(gameId,timeFrom,timeTo);
        if(roundStatisticsSlotList.size() == 0){
            return slotRtpResult;
        }else{
            slotRtpResult = new SlotRtpResult();
        }
        for (RoundStatisticsSlot roundStatisticsSlot : roundStatisticsSlotList)
        {
            slotRtpResult.setTotalWon(slotRtpResult.getTotalWon()+roundStatisticsSlot.getTotalWonOnRound());
            slotRtpResult.setTotalSpent(slotRtpResult.getTotalSpent()+roundStatisticsSlot.getTotalSpentOnRound());
        }
        if(slotRtpResult.getTotalSpent()>0){
            BigDecimal totalRtpBg = new BigDecimal((double)slotRtpResult.getTotalWon()/(double)slotRtpResult.getTotalSpent());
            slotRtpResult.setTotalRTP(totalRtpBg.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        }else{
            slotRtpResult.setTotalRTP(0.00);
        }
        
        slotRtpResult.setTotalSpins(roundStatisticsSlotList.size());
        slotRtpResult.setTotal_user_count(rtpDao.queryUserCountByTimeOfSlot(gameId, timeFrom, timeTo));
        slotRtpResult.setTotal_Jackpot_count(rtpDao.querJackpotCountByTime(gameId, timeFrom, timeTo));
        
        // - - - - - - - dynamic data - - - - - - -
        try
        {
            Calendar calendarFrom = Calendar.getInstance();
            calendarFrom.setTime(ThreadLocalSimple.df.get().parse(timeFrom));
            
            Calendar calendarAt12 = Calendar.getInstance();
            calendarAt12.set(calendarFrom.get(Calendar.YEAR), calendarFrom.get(Calendar.MONTH), calendarFrom.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
            
            Calendar calendarTo = Calendar.getInstance();
            calendarFrom.setTime(ThreadLocalSimple.df.get().parse(timeTo));
            
            rtpStatistics(gameId, timeFrom, timeTo, slotRtpResult, calendarAt12, calendarTo);
            
            return slotRtpResult;
            
        } catch (ParseException e)
        {
            e.printStackTrace();
        }
        return slotRtpResult;
    }

    private void rtpStatistics(int gameId, String timeFrom, String timeTo, SlotRtpResult slotRtpResult,
            Calendar calendarAt12, Calendar calendarTo)
    {
        try
        {
            if(calendarAt12.before(calendarTo)){
                String time12 = ThreadLocalSimple.df.get().format(calendarAt12.getTime());
                List<RoundStatisticsSlot> roundStatisticsBetween = rtpDao.querySlotRtpByGameId(gameId, timeFrom, time12);
                CalculateRtp(timeFrom, slotRtpResult, time12, roundStatisticsBetween);
                
                Calendar calendar12New = Calendar.getInstance();
                calendar12New.setTime(ThreadLocalSimple.df.get().parse(time12));
                calendar12New.add(Calendar.DAY_OF_MONTH, 1);
                rtpStatistics(gameId,time12,timeTo,slotRtpResult,calendar12New,calendarTo);
            }else if(calendarAt12.after(calendarTo)){
                List<RoundStatisticsSlot> roundStatisticsBetween = rtpDao.querySlotRtpByGameId(gameId, timeFrom, timeTo);
                CalculateRtp(timeFrom, slotRtpResult, timeTo, roundStatisticsBetween);
            }
        } catch (ParseException e)
        {
            e.printStackTrace();
        }
    
    }

    private void CalculateRtp(String timeFrom, SlotRtpResult slotRtpResult, String time12,
            List<RoundStatisticsSlot> roundStatisticsBetween)
    {
        long totalWon = 0;
        long totalSpent = 0;
        
        if(roundStatisticsBetween.size() == 0){
            return;
        }
        for (RoundStatisticsSlot roundStatistic : roundStatisticsBetween)
        {
            totalWon += roundStatistic.getTotalWonOnRound();
            totalSpent += roundStatistic.getTotalSpentOnRound();
        }
        if(totalSpent>0){
            BigDecimal rtpBg = new BigDecimal((double)totalWon/(double)totalSpent);
            double rtp = rtpBg.setScale(3,BigDecimal.ROUND_HALF_UP).doubleValue();
            slotRtpResult.getRtp().put(timeFrom+"-"+time12,rtp);
            rtps.add(rtp);
        }else{
            slotRtpResult.getRtp().put(timeFrom+"-"+time12,0.00);
            rtps.add(0.00);
        }
    }

}
