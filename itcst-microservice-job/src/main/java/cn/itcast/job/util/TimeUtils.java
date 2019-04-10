package cn.itcast.job.util;

import java.text.SimpleDateFormat;

public class TimeUtils
{
    private static ThreadLocal<SimpleDateFormat> df = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue()
        {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };
    
    public static SimpleDateFormat getSimpleDateFormat(){
        return df.get();
    }
}
