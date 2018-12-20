package cn.itcast.microservice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import cn.itcast.microservice.entity.Order;
import cn.itcast.microservice.service.OrderService;

@RestController
public class OrderController
{
    @Autowired
    private OrderService orderService;
    
    /**
     * page query,get request
     *
     * http://localhost:6875/page?pageNum=1&rows=20
     *
     * @return
     */
    @GetMapping("/page")
    public Map<Long,Order> pageQuery(@RequestParam(value="pageNum",required=true)int pageNum,@RequestParam(value="pageSize",required=true)int pageSize){
        Page<Order> pageQuery = this.orderService.pageQuery( pageNum, pageSize,new Order());
        Map<Long, Order> orders = new HashMap<Long,Order>();
        for (Order order : pageQuery)
        {
            orders.put(order.getId(), order);
        }
        return orders;
    }
    
    /**
     * query the specifical order by order id,get request
     *
     * http://localhost:6875/order?orderId=1
     *
     * @return
     */
    @GetMapping("/order")
    public String queryByOrderId(@RequestParam(value = "orderId",required = true)String orderId){
        Order order = this.orderService.queryByOrderId(orderId);
        return JSON.toJSONString(order);
    }
    
}
