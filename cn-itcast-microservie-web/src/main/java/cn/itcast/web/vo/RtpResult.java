package cn.itcast.web.vo;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class RtpResult implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    private long totalWon;
    private long totalSpent;
    public long getTotalWon()
    {
        return totalWon;
    }
    public void setTotalWon(long totalWon)
    {
        this.totalWon = totalWon;
    }
    public long getTotalSpent()
    {
        return totalSpent;
    }
    public void setTotalSpent(long totalSpent)
    {
        this.totalSpent = totalSpent;
    }
}
