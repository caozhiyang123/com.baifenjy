package cn.itcast.microservice.test;

import cn.itcast.microservice.order.OrderApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by czy on 2018-03-31.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ItemServiceTest.class)
@Import(OrderApplication.class)
public class ItemServiceTest {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Test
    public void test(){
        String servicedId = "itcast-microservice-item";
        for (int i = 0; i < 10; i++) {
           ServiceInstance serviceInstance =  loadBalancerClient.choose(servicedId);
           System.out.println("第"+i+"次访问微服务item-service"+serviceInstance.getHost()+":"+serviceInstance.getPort());

        }
    }
}
