package cn.itcast.microservice.order.service;

import cn.itcast.microservice.order.domain.Item;
import cn.itcast.microservice.order.domain.Order;
import cn.itcast.microservice.order.domain.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * Created by czy on 2018-03-22.
 */
@Service
public class OrderService {

    private static  Map<String, Order> MAP = new HashMap<String, Order>();

    static {
// 构造测试数据
        Order order = new Order();
        order.setOrderId("59193738268961442");
        order.setCreateDate(new Date());
        order.setUpdateDate(order.getCreateDate());
        order.setUserId(1L);
        List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();

        Item item = new Item();// 此处并没有商品的数据，需要调用商品微服务获取
        item.setId(2L);
        orderDetails.add(new OrderDetail(order.getOrderId(), item));

        item = new Item(); // 构造第二个商品数据
        item.setId(3L);
        orderDetails.add(new OrderDetail(order.getOrderId(), item));

        order.setOrderDetails(orderDetails);

        MAP.put(order.getOrderId(), order);
    }

    @Autowired
    private ItemService itemService;
    /**
      * 根据订单id查询订单数据
      *  
      *
      * @param orderId
      * @return
      */
    public  Order queryOrderById(String orderId) {
        Order order = MAP.get(orderId);
        if (null == order) {
            return null;
        }
        List<OrderDetail> orderDetails = order.getOrderDetails();
        for (OrderDetail orderDetail : orderDetails) {
// 通过商品微服务查询商品数据
//            System.out.println(orderDetail.getItem().getId());
            Item item = this.itemService.queryItemById(orderDetail.getItem().getId());
//            System.out.println(item);
            if (null == item) {
                continue;
            }
            orderDetail.setItem(item);
        }

        return order;
    }

}