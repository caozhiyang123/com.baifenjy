package cn.itcast.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysql.jdbc.StringUtils;

import cn.itcast.web.service.RtpService;
import cn.itcast.web.vo.SlotRtpResult;
import cn.itcast.web.vo.VBRtpResult;

@Controller
@RequestMapping("rtp")
public class RtpController
{
    @Autowired
    private RtpService rtpService;
    
    @RequestMapping(value="query/vb",method=RequestMethod.GET)
    public ResponseEntity<VBRtpResult> queryVbRtpByGameId(@RequestParam(value="timeFrom",required=true)String timeFrom,
            @RequestParam(value="timeTo",required=true)String timeTo,
            @RequestParam(value="gameId",required=true)int gameId){
        
        if(StringUtils.isNullOrEmpty(timeFrom) || StringUtils.isNullOrEmpty(timeTo) || gameId<= 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        System.out.println(gameId+","+timeFrom+","+timeTo);
        VBRtpResult rtpResult = rtpService.queryVbRtpByGameId(gameId,timeFrom,timeTo);
        if(rtpResult!=null){
            return ResponseEntity.ok(rtpResult);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    
    @RequestMapping(value="query/slot",method=RequestMethod.GET)
    public ResponseEntity<SlotRtpResult> querySlotRtpByGameId(@RequestParam(value="timeFrom",required=true)String timeFrom,
            @RequestParam(value="timeTo",required=true)String timeTo,
            @RequestParam(value="gameId",required=true)int gameId){
        
                return null;
        
    }

}
