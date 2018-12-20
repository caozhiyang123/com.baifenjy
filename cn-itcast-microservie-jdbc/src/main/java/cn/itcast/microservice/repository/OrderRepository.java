package cn.itcast.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import cn.itcast.microservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Long>, JpaSpecificationExecutor<Order>
{

}
