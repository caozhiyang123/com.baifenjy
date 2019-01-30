package cn.itcast.web.vo;

import java.util.Map;
import java.util.TreeMap;

public class SlotRtpResult extends RtpResult
{
    private static final long serialVersionUID = 1L;
    
    private Map<String,Double> rtp = new TreeMap<String,Double>();
    
    private double totalRTP;
    private long total_user_count;
    private long total_Jackpot_count;
    private long totalSpins;
    
    public Map<String, Double> getRtp()
    {
        return rtp;
    }
    public void setRtp(Map<String, Double> rtp)
    {
        this.rtp = rtp;
    }
    public double getTotalRTP()
    {
        return totalRTP;
    }
    public void setTotalRTP(double totalRTP)
    {
        this.totalRTP = totalRTP;
    }
    public long getTotal_user_count()
    {
        return total_user_count;
    }
    public void setTotal_user_count(long total_user_count)
    {
        this.total_user_count = total_user_count;
    }
    public long getTotal_Jackpot_count()
    {
        return total_Jackpot_count;
    }
    public void setTotal_Jackpot_count(long total_Jackpot_count)
    {
        this.total_Jackpot_count = total_Jackpot_count;
    }
    public long getTotalSpins()
    {
        return totalSpins;
    }
    public void setTotalSpins(long totalSpins)
    {
        this.totalSpins = totalSpins;
    }
    
    
}
