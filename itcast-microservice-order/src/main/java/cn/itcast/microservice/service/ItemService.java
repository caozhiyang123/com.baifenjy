package cn.itcast.microservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import cn.itcast.microservice.feign.ItemOfEduClient;
import cn.itcast.microservice.feign.pojo.Item;

@Service
public class ItemService
{
    @Autowired
    private ItemOfEduClient itemOfEduClient;
    
    @HystrixCommand(fallbackMethod = "checkMethod")
    public Item queryItemById(long id) throws Exception {
        return  new ObjectMapper().readValue(itemOfEduClient.queryItemById(id),Item.class);
    }
    
    public Item checkMethod(Long id){
        return new Item(null,"error",null,null);
    }
}
