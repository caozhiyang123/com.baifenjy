package cn.itcast.web.service;

import cn.itcast.web.io.LoggerResult;

public interface LoggerService
{
    LoggerResult queryOldLogFile(boolean isTest,String time, String logType);

    LoggerResult queryCurrentLogFile(boolean isTest, String logType);

}
