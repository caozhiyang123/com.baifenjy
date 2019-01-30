package cn.itcast.web.vo;

import java.util.Map;
import java.util.TreeMap;

public class VBRtpResult extends RtpResult
{
    private static final long serialVersionUID = 1L;
    
    private Map<String,Double> rtp = new TreeMap<String,Double>();
    private Map<String,Double> baseRtp = new TreeMap<String,Double>();
    private Map<String,Double> ebRtp = new TreeMap<String,Double>();
    
    private Map<String,Double> ebPrice = new TreeMap<String,Double>();// 10 ebSpentWithoutBet / ebCount,(ebSpentWithoutBet = (double) price / this.playerState.getCurrentBet())
    
    private double totalRTP;
    private double totalBaseRTP;
    private double totalEBRTP;
    
    private double deltaRTP;
    private double deltaBaseRTP;
    private double deltaEBRTP;
    
    private long totalBaseWon;//2
    private long totalEbWon;//3
    private long totalSpins;//7
    private long user_count;//8
    private int jackpotCount;//9
    
    private long totalBseSpent;//6
    private long totalEbSpent;//5
    
    public Map<String, Double> getRtp()
    {
        return rtp;
    }
    public void setRtp(Map<String, Double> rtp)
    {
        this.rtp = rtp;
    }
    public Map<String, Double> getBaseRtp()
    {
        return baseRtp;
    }
    public void setBaseRtp(Map<String, Double> baseRtp)
    {
        this.baseRtp = baseRtp;
    }
    public Map<String, Double> getEbRtp()
    {
        return ebRtp;
    }
    public void setEbRtp(Map<String, Double> ebRtp)
    {
        this.ebRtp = ebRtp;
    }
    public double getTotalRTP()
    {
        return totalRTP;
    }
    public void setTotalRTP(double totalRTP)
    {
        this.totalRTP = totalRTP;
    }
    public double getTotalBaseRTP()
    {
        return totalBaseRTP;
    }
    public void setTotalBaseRTP(double totalBaseRTP)
    {
        this.totalBaseRTP = totalBaseRTP;
    }
    public double getTotalEBRTP()
    {
        return totalEBRTP;
    }
    public void setTotalEBRTP(double totalEBRTP)
    {
        this.totalEBRTP = totalEBRTP;
    }
    public int getJackpotCount()
    {
        return jackpotCount;
    }
    public void setJackpotCount(int jackpotCount)
    {
        this.jackpotCount = jackpotCount;
    }
    public double getDeltaRTP()
    {
        return deltaRTP;
    }
    public void setDeltaRTP(double deltaRTP)
    {
        this.deltaRTP = deltaRTP;
    }
    public double getDeltaBaseRTP()
    {
        return deltaBaseRTP;
    }
    public void setDeltaBaseRTP(double deltaBaseRTP)
    {
        this.deltaBaseRTP = deltaBaseRTP;
    }
    public double getDeltaEBRTP()
    {
        return deltaEBRTP;
    }
    public void setDeltaEBRTP(double deltaEBRTP)
    {
        this.deltaEBRTP = deltaEBRTP;
    }
    public Map<String,Double> getEbPrice()
    {
        return ebPrice;
    }
    public void setEbPrice(Map<String,Double> ebPrice)
    {
        this.ebPrice = ebPrice;
    }
    public long getUser_count()
    {
        return user_count;
    }
    public void setUser_count(long user_count)
    {
        this.user_count = user_count;
    }
    public long getTotalBaseWon()
    {
        return totalBaseWon;
    }
    public void setTotalBaseWon(long totalBaseWon)
    {
        this.totalBaseWon = totalBaseWon;
    }
    public long getTotalEbWon()
    {
        return totalEbWon;
    }
    public void setTotalEbWon(long totalEbWon)
    {
        this.totalEbWon = totalEbWon;
    }
    public long getTotalSpins()
    {
        return totalSpins;
    }
    public void setTotalSpins(long totalSpins)
    {
        this.totalSpins = totalSpins;
    }
    public long getTotalBseSpent()
    {
        return totalBseSpent;
    }
    public void setTotalBseSpent(long totalBseSpent)
    {
        this.totalBseSpent = totalBseSpent;
    }
    public long getTotalEbSpent()
    {
        return totalEbSpent;
    }
    public void setTotalEbSpent(long totalEbSpent)
    {
        this.totalEbSpent = totalEbSpent;
    }
    
}
