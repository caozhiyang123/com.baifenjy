package cn.itcast.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysql.jdbc.StringUtils;

import cn.itcast.web.io.LoggerResult;
import cn.itcast.web.service.LoggerService;

@RequestMapping("log")
@Controller
public class LoggerController
{
    @Autowired
    private LoggerService loggerService;
    
    private final Boolean isTest = true;
    
    @RequestMapping(value="query",method=RequestMethod.GET)
    public ResponseEntity<LoggerResult> queryVbRtpByGameId(@RequestParam(value="time",required=true)String time,
            @RequestParam(value="logType")String logType){
        if(StringUtils.isNullOrEmpty(time) || StringUtils.isNullOrEmpty(logType) ){
            return  (ResponseEntity<LoggerResult>) ResponseEntity.badRequest();
        }
        
        LoggerResult loggerResult = loggerService.queryCurrentLogFile(isTest,logType);
        if(loggerResult.getLog().isEmpty()){
            ResponseEntity.notFound();
        }
        
        return ResponseEntity.ok(loggerResult);
    }
}
