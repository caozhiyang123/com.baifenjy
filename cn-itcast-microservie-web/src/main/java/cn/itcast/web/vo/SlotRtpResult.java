package cn.itcast.web.vo;

import java.io.Serializable;

public class SlotRtpResult implements Serializable
{
    private static final long serialVersionUID = 1L;
    private long user_count;
    private double totalRTP;
    private long totalWon;
    public long getUser_count()
    {
        return user_count;
    }
    public void setUser_count(long user_count)
    {
        this.user_count = user_count;
    }
    public double getTotalRTP()
    {
        return totalRTP;
    }
    public void setTotalRTP(double totalRTP)
    {
        this.totalRTP = totalRTP;
    }
    public long getTotalWon()
    {
        return totalWon;
    }
    public void setTotalWon(long totalWon)
    {
        this.totalWon = totalWon;
    }
    
}
