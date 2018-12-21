package cn.itcast.microservice.service;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import cn.itcast.microservice.entity.Order;
import cn.itcast.microservice.repository.OrderRepository;
import cn.itcast.microservice.utils.ThreadLocalSimple;

@Transactional(readOnly=true)
@Service
public class OrderServiceImpl implements OrderService
{
    @Autowired
    private OrderRepository orderRepository;
    
    @Override
    public Page<Order> pageQuery(int pageNum , int pageSize,Order order){
        
        Pageable pageable=new PageRequest(pageNum, pageSize);  //分页信息   
        
        //复杂条件分页查询
        /*Specification<Order> spec = new Specification<Order>() {
            //查询条件构造       
            @Override
            public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder cb)
            {
                Path<String> name = root.get("name");      

                Path<Integer> id = root.get("id");          

                Predicate p1 = cb.like(name, "%"+order.getId()+"%");     

                Predicate p2 = cb.lt(id, order.getId());     

                Predicate p = cb.and(p1, p2);         
                return p; 
            }};
            return orderRepository.findAll(spec, pageable);*/
         
         //简单条件分页查询
         return this.orderRepository.findAll(pageable);
        
    }

    @Override
    public Order queryByOrderId(@PathVariable String orderId){
       return  this.orderRepository.findByOrderId(orderId);
    }

    @Transactional(readOnly=false)
    @Override
    public void save(String orderId, String studentName, int studentAge, int studentSex, String studentGrade,
            String studentSubject, String address, String otherImportants, String cost, String parentsName,
            String phoneNum, String qqNum, String weChatNum, String messageResource)
    {
        Order order = new Order(orderId,studentName,studentAge,studentSex,studentGrade,studentSubject,address,otherImportants
                ,cost,parentsName,phoneNum,qqNum,weChatNum,messageResource,ThreadLocalSimple.df.get().format(new Date()));
        this.orderRepository.save(order);
    }
    
}
