package cn.itcast.web.service;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.web.io.LoggerResult;


@Service
@Transactional(readOnly=true)
public class LoggerServiceImpl implements LoggerService
{
    
    private static final String fileRoot = "/usr/local/sfs/SmartFoxServer_2X/SFS2X/logs";
    //the latest file
    private static final String mainFile = "/smartfox.log";
    //old file pre
    private static final String singleFilePre = "/smartfox.log.";

    //local test
    private static final String localTestFileRoot = "D:/tools3/softInstalling/SmartFoxServer_2X/log/logs";
    //local file
    private static final String debugFile = "/debug.log";
    private static final String errorFile = "/error.log";
    

    @Override
    public LoggerResult queryCurrentLogFile(boolean isTest, String logType)
    {
        LoggerResult loggerResult = new LoggerResult();
        File file = null;
        try
        {
            if(isTest){
                file = new File(localTestFileRoot+debugFile);
            }else{
                file = new File(fileRoot+debugFile+mainFile);
            }
            readToResult(logType, loggerResult, file);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
            
        getItemContent(logType,loggerResult,file);
        
        return loggerResult;
    }


    public void readToResult(String logType, LoggerResult loggerResult, File file)
            throws FileNotFoundException, IOException
    {
        BufferedReader bfd = new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream(file))));
        StringBuilder sb = new StringBuilder();
        String line = "";
        int lineNum = 1;
        while ((line=bfd.readLine()) != null)
        {
            if(isExistSpecificalLogType(line,logType)){
                sb.append(line);
                loggerResult.getLog().put(lineNum, line);
            }
            lineNum++;
        }
    }


    private void getItemContent(String logType, LoggerResult loggerResult, File file)
    {
        try
        {
            if(!loggerResult.getLog().isEmpty()){return;}
            for(Integer lineNum: loggerResult.getLog().keySet()){
                readToResult(lineNum,logType,loggerResult,file);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    private void readToResult(Integer targetLineNum, String logType, LoggerResult loggerResult, File file)
    {
        try
        {
            BufferedReader bfd = new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream(file))));
            StringBuilder sb = new StringBuilder();
            String line = "";
            int lineNum = 1;
            while ((line=bfd.readLine()) != null)
            {
                lineNum++;
                if(lineNum == targetLineNum-20){
                    sb.append(line);
                    loggerResult.getLog().put(lineNum, line);
                }
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    
    }


    private boolean isExistSpecificalLogType(String line, String logType)
    {
        if(!StringUtils.isNotBlank(line) || !StringUtils.isNotBlank(logType)){
            return false;
        }
        return StringUtils.containsIgnoreCase(line, logType);
    }


    @Override
    public LoggerResult queryOldLogFile(boolean isTest, String time, String logType)
    {
        return null;
    }

}
