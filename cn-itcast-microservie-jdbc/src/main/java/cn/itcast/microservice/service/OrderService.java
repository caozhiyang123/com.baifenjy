package cn.itcast.microservice.service;

import org.springframework.data.domain.Page;

import cn.itcast.microservice.entity.Order;

public interface OrderService
{

    Page<Order> pageQuery(int pageNum , int pageSize,Order order);

    Order queryByOrderId(String orderId);

    void save(String orderId, String studentName, int studentAge, int studentSex, String studentGrade,
            String studentSubject, String address, String otherImportants, String cost, String parentsName,
            String phoneNum, String qqNum, String weChatNum, String messageResource);
    
}
