package cn.itcast.sso.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ThreadLocalSimple
{
    public static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };
}
