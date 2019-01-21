package cn.itcast.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.itcast.web.vo.RtpResult;

@Controller
@RequestMapping("data")
public class RtpController
{
    @RequestMapping(value="rtp",method=RequestMethod.GET)
    public ResponseEntity<RtpResult> getRtpData(@RequestParam(value="fromTime",required=true,defaultValue="2018-01-21 13:58:00")String fromTime,
            @RequestParam(value="toTime",required=true,defaultValue="2019-01-21 13:58:00")String toTime){
        
        RtpResult rtpResult = new RtpResult();
        return ResponseEntity.ok(rtpResult);
    }
}
