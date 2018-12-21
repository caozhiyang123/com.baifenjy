package cn.itcast.microservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import cn.itcast.microservice.entity.Order;
import cn.itcast.microservice.service.OrderService;


@RequestMapping(value="/order",method=RequestMethod.GET)
@RestController
public class OrderController
{
    @Autowired
    private OrderService orderService;
    
    /**
     * page query,get request
     *
     * http://localhost:6874/order/page?pageNum=0&pageSize=20
     *
     * @return
     */
    @GetMapping("/page")
    public String pageQuery(@RequestParam(value="pageNum",required=true)int pageNum,@RequestParam(value="pageSize",required=true)int pageSize){
        Page<Order> pageQuery = this.orderService.pageQuery( pageNum, pageSize,new Order());
        Map<String, Order> orderMap = new HashMap<String,Order>();
        List<Order> orders = pageQuery.getContent();
        for (Order order : orders)
        {
            orderMap.put(order.getOrderId(), order);
        }
        return JSON.toJSONString(orderMap);
    }
    
    /**
     * query the specifical order by order id,get request
     *
     * http://localhost:6874/order/query?orderId=1
     *
     * @return
     */
    @GetMapping("/query")
    public String queryByOrderId(@RequestParam(value = "orderId",required = true)String orderId){
        Order order = this.orderService.queryByOrderId(orderId);
        return JSON.toJSONString(order);
    }
    
    /**
     * query the specifical order by order id,get request
     *
     * http://localhost:6874/order/save?orderId=?&StudentName=?&...
     *
     * @return
     */
    @GetMapping("/save")
    public void saveOrder(@RequestParam(value = "orderId",required=true)String orderId,@RequestParam(value = "StudentName",defaultValue="")String StudentName
             ,@RequestParam(value = "StudentAge",defaultValue="0")int StudentAge,@RequestParam(value = "StudentSex",defaultValue="1")int StudentSex
             ,@RequestParam(value = "StudentGrade",defaultValue="")String StudentGrade,@RequestParam(value = "StudentSubject",defaultValue="")String StudentSubject
             ,@RequestParam(value = "address",defaultValue="")String address,@RequestParam(value = "otherImportants",defaultValue="")String otherImportants
             ,@RequestParam(value = "cost",defaultValue="")String cost,@RequestParam(value = "parentsName",defaultValue="")String parentsName
             ,@RequestParam(value = "phoneNum",defaultValue="")String phoneNum,@RequestParam(value = "qqNum",defaultValue="")String qqNum,@RequestParam(value = "weChatNum",defaultValue="")String weChatNum
             ,@RequestParam(value = "messageResource",defaultValue="")String messageResource){
        this.orderService.save(orderId,StudentName,StudentAge,StudentSex,StudentGrade,StudentSubject,address,otherImportants
                ,cost,parentsName,phoneNum,qqNum,weChatNum,messageResource);
    }
}
