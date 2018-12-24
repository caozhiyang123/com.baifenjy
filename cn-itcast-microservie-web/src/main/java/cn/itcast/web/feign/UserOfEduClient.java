package cn.itcast.web.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * remote request by service id
 * @author 12502
 * 申明这是一个Feign客户端，并且指明服务id
 */
@FeignClient(value = "itcast-microservice-sso")
public interface UserOfEduClient
{   
    @GetMapping(value = "/user/{token}")
    public String queryUserByToken(@PathVariable("token") String token);

   }
