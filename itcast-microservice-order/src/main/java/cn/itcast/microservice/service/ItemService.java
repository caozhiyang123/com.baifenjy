package cn.itcast.microservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import cn.itcast.microservice.feign.ItemOfEduClient;
import cn.itcast.microservice.feign.pojo.Item;
import cn.itcast.microservice.vo.Reply;

@Service
public class ItemService
{
    @Autowired 
    private ItemOfEduClient itemOfEduClient;
    
    @HystrixCommand(fallbackMethod = "checkMethod")
    public Item queryItemById(long id) throws Exception {
        String str = itemOfEduClient.queryItemById(id);
        System.out.println(str);
        Item item = new ObjectMapper().readValue(str,Item.class);
        return item;
    }
    
    public Item checkMethod(long id){
        return new Item(null,Reply.NO_ITEM,null,null);
    }
}
