package cn.itcast.microservice.order.controll;

import cn.itcast.microservice.order.domain.OrderVO;
import cn.itcast.microservice.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by czy on 2018-03-22.
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping(value = "orderVO/{orderId}")
    public OrderVO queryOrderVOById(@PathVariable("orderId") String orderId) {
        return this.orderService.queryOrderById(orderId);
    }
    
    @GetMapping("/orderOfEdu")
    public String queryOrderById(@RequestParam(value="orderId",required=true)String orderId){
        return this.orderService.queryOrderOfEduById(orderId);
    }
    
    @GetMapping("/orderOfEdu/page")
    public String pageQueryOfEduOrder(@RequestParam(value="pageNum",required=true)int pageNum,@RequestParam(value="pageSize",required=true)int pageSize){
        return this.orderService.pageQueryOfEduOrder(pageNum,pageSize);
    }
    
    @GetMapping("orderOfEdu/save")
    public void saveOrderOfEdu(@RequestParam(value = "orderId",required=true)String orderId,@RequestParam(value = "StudentName",defaultValue="")String StudentName
            ,@RequestParam(value = "StudentAge",defaultValue="0")int StudentAge,@RequestParam(value = "StudentSex",defaultValue="1")int StudentSex
            ,@RequestParam(value = "StudentGrade",defaultValue="")String StudentGrade,@RequestParam(value = "StudentSubject",defaultValue="")String StudentSubject
            ,@RequestParam(value = "address",defaultValue="")String address,@RequestParam(value = "otherImportants",defaultValue="")String otherImportants
            ,@RequestParam(value = "cost",defaultValue="")String cost,@RequestParam(value = "parentsName",defaultValue="")String parentsName
            ,@RequestParam(value = "phoneNum",defaultValue="")String phoneNum,@RequestParam(value = "qqNum",defaultValue="")String qqNum,@RequestParam(value = "weChatNum",defaultValue="")String weChatNum
            ,@RequestParam(value = "messageResource",defaultValue="")String messageResource){
        this.orderService.saveOrderOfEdu(orderId,StudentName,StudentAge,StudentSex,StudentGrade,StudentSubject,address,otherImportants
                ,cost,parentsName,phoneNum,qqNum,weChatNum,messageResource);
    }
}
