package cn.itcast.microservice.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by czy on 2018-03-31.
 */

@RefreshScope
@RestController
public class ConfigController {
    @Value("${jdbc.url}")
    private String jdbcUrl;

    @RequestMapping("/config")
    public String config(){
        return jdbcUrl;
    }
}
