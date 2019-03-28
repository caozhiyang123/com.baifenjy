package cn.itcast.microservice.item.controll;


import cn.itcast.microservice.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

@RestController
@RequestMapping("item")
public class ItemController {
    
    @Autowired
    private ItemService itemService;
    
    /**
         * 对外提供接口服务，查询item信息
         *
         * @param id
         * @return
         */
    @GetMapping(value = "/queryById")
    public String queryItemById(@RequestParam("orderId") Long id) {
        return JSON.toJSONString(this.itemService.queryItemById(id));
    }

}
