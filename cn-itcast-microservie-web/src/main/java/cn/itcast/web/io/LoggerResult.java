package cn.itcast.web.io;

import java.util.Map;
import java.util.TreeMap;

public class LoggerResult implements Result
{
    private static final long serialVersionUID = 1L;

    private Map<Integer,String> log = new TreeMap<Integer,String>();
    
    private Map<Integer,String> item = new TreeMap<Integer,String>();

    public Map<Integer, String> getLog()
    {
        return log;
    }

    public void setLog(Map<Integer, String> log)
    {
        this.log = log;
    }

    public Map<Integer, String> getItem()
    {
        return item;
    }

    public void setItem(Map<Integer, String> item)
    {
        this.item = item;
    }
    
    
    
}
