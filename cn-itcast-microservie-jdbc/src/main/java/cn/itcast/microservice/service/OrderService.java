package cn.itcast.microservice.service;

import org.springframework.data.domain.Page;

import cn.itcast.microservice.entity.Order;

public interface OrderService
{

    Page<Order> pageQuery(int pageNum , int pageSize,Order order);

    Order queryByOrderId(String orderId);
    
}
