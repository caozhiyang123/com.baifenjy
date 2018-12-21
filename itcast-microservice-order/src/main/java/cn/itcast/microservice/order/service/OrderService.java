package cn.itcast.microservice.order.service;

import cn.itcast.microservice.order.domain.Item;
import cn.itcast.microservice.order.domain.OrderVO;
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

    @Autowired
    private ItemService itemService;
    /**
      * 根据订单id查询订单数据
      *  
      *
      * @param orderId
      * @return
      */
    public  OrderVO queryOrderById(String orderId) {
        //query order by orderId
        OrderVO orderVO = null;
        if (null == orderVO) {
            return null;
        }
        List<OrderDetail> orderDetails = orderVO.getOrderDetails();
        for (OrderDetail orderDetail : orderDetails) {
            Item item = this.itemService.queryItemById(orderDetail.getItem().getId());
            if (null == item) {
                continue;
            }
            orderDetail.setItem(item);
        }

        return orderVO;
    }
    public String queryOrderOfEduById(String orderId)
    {
        return this.itemService.queryOrderItemById(orderId);
    }
    public String pageQueryOfEduOrder(int pageNum, int pageSize)
    {
        return this.itemService.pageQueryOfEduOrder(pageNum,pageSize);
    }
    public void saveOrderOfEdu(String orderId, String studentName, int studentAge, int studentSex, String studentGrade,
            String studentSubject, String address, String otherImportants, String cost, String parentsName,
            String phoneNum, String qqNum, String weChatNum, String messageResource)
    {
        this.itemService.saveOrderOfEdu(orderId,studentName,studentAge,studentSex,studentGrade,studentSubject,address,otherImportants
                ,cost,parentsName,phoneNum,qqNum,weChatNum,messageResource);
        
    }

}