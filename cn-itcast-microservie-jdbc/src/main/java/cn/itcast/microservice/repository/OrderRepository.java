package cn.itcast.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cn.itcast.microservice.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long>, JpaSpecificationExecutor<Order>
{

    @Query(value="select * from order_edu where order_id = ?1",nativeQuery=true)
    Order findByOrderId(String orderId);

}
