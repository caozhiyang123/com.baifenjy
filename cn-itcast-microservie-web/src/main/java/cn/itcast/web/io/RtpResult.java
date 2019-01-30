package cn.itcast.web.io;


public class RtpResult implements Result
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
