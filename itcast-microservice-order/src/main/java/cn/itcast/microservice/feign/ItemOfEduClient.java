package cn.itcast.microservice.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * remote request by service id
 * @author 12502
 * 申明这是一个Feign客户端，并且指明服务id
 */
@FeignClient(value = "itcast-microservice-jdbc")
public interface ItemOfEduClient
{   
    @GetMapping(value = "/order/query")
    public String queryItemById(@RequestParam(value = "orderId",required = true)String orderId);

    @GetMapping("/order/page")
    public String pageQueryOfOrder(@RequestParam(value="pageNum",required=true)int pageNum,@RequestParam(value="pageSize",required=true)int pageSize);

    @GetMapping("/order/save")
    public void saveOrder(@RequestParam(value = "orderId",required=true)String orderId,@RequestParam(value = "StudentName",defaultValue="")String StudentName
            ,@RequestParam(value = "StudentAge",defaultValue="0")int StudentAge,@RequestParam(value = "StudentSex",defaultValue="1")int StudentSex
            ,@RequestParam(value = "StudentGrade",defaultValue="")String StudentGrade,@RequestParam(value = "StudentSubject",defaultValue="")String StudentSubject
            ,@RequestParam(value = "address",defaultValue="")String address,@RequestParam(value = "otherImportants",defaultValue="")String otherImportants
            ,@RequestParam(value = "cost",defaultValue="")String cost,@RequestParam(value = "parentsName",defaultValue="")String parentsName
            ,@RequestParam(value = "phoneNum",defaultValue="")String phoneNum,@RequestParam(value = "qqNum",defaultValue="")String qqNum,@RequestParam(value = "weChatNum",defaultValue="")String weChatNum
            ,@RequestParam(value = "messageResource",defaultValue="")String messageResource);
}
