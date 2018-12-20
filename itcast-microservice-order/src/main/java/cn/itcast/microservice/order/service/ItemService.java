package cn.itcast.microservice.order.service;

import cn.itcast.microservice.feign.ItemFeignClient;
import cn.itcast.microservice.order.domain.Item;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ItemService {

@Autowired
private RestTemplate restTemplate;

@Autowired
private DiscoveryClient discoveryClient;

@Autowired
private ItemFeignClient itemFeignClient;

//@HystrixCommand(fallbackMethod = "checkMethod")
public Item queryItemById(Long id) {
//    String serviceId = "itcast-microservice-item";
   /* List<ServiceInstance> instances = this.discoveryClient.getInstances(serviceId);
    if (instances.isEmpty()) {
         return null;
    }
// 为了演示，在这里只获取一个实例
    ServiceInstance serviceInstance = instances.get(0);
    String url = serviceInstance.getHost() + ":" + serviceInstance.getPort();*/
    //有了ribbon就不需要上面根据host和port进行调用了
//        Item item = this.restTemplate.getForObject("http://" + serviceId + "/item/" + id, Item.class);
//        return item == null ? null : item;
          return  this.itemFeignClient.queryItemById(id);
}

public Item checkMethod(Long id){
    return new Item(null,"获取产品信息失败",null,null,null);
}

}