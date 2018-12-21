package cn.itcast.microservice.feign;

import cn.itcast.microservice.order.domain.Item;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by czy on 2018-03-31.
 * 申明这是一个Feign客户端，并且指明服务id
 */
@FeignClient(value = "itcast-microservice-item")
public interface ItemFeignClient {

    @RequestMapping(value = "/item/{id}",method = RequestMethod.GET)
    public Item queryItemById(@PathVariable("id") long id);

}
