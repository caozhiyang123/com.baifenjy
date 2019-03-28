package cn.itcast.microservice.controll;

import cn.itcast.microservice.pojo.Order;
import cn.itcast.microservice.service.OrderService;
import cn.itcast.microservice.vo.EasyUIResult;

import java.util.List;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;

//@Controller
@RequestMapping("order")
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    
    private ObjectMapper MAPPER = new ObjectMapper();
    
    // http://127.0.0.1:6870/order/pageQuery?page=1&rows=30&sort=updated&order=DESC&callback_=order
    
//    @ResponseBody
    @RequestMapping(value="/pageQuery",method=RequestMethod.GET)
    public ResponseEntity<EasyUIResult> pageQuerySorted(@RequestParam("page")Integer pageNum,@RequestParam("rows")Integer pageSize
            ,@RequestParam(value="sort",required=false,defaultValue="updated")String sort,
            @RequestParam(value="order",required=false,defaultValue="DESC")String order,@RequestParam(value="callback_",required=false,defaultValue="")String callback){
        try {
            if(pageNum<0 || pageSize<0){
                //参数列表错误400
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
            PageInfo<Order> pageInfo = orderService.queryPageSorted(null, pageNum, pageSize, sort,order);
            EasyUIResult result = null;
            if(pageInfo.getTotal()>0 && pageInfo.getList().size()>0){
                result = new EasyUIResult();
                result.setTotal(pageInfo.getTotal());
                result.setRows(pageInfo.getList());
            }
            if(result==null){
                //资源转移404
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);            
            }
            /*String json = MAPPER.writeValueAsString(result);
            //查询成功
            if(StringUtils.isNotBlank(json)){
                return ResponseEntity.status(HttpStatus.OK).body(callback+"("+json+")");                
            }*/
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            e.printStackTrace();
        }  
        //服务器异常
        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        
    }
    
    @RequestMapping(value="/insert",method=RequestMethod.POST)//
    public ResponseEntity<Void> save(Order order){
        try {
            if(order==null){
                //参数列表错误400
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            order.setId(null);
            Integer result = orderService.insert(order);
            if(result!=1){
                //保存失败
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
            //保存成功
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
      //服务器有异常500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    
    @RequestMapping(value="/edit",method=RequestMethod.PUT)
    public ResponseEntity<Void> edit(Order order){
        try {
            if(order==null){
                //参数列表错误400
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            Integer result = orderService.updateSelective(order);
            if(result!=1){
                //更新失败
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
            //更新成功
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //服务器有异常500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    
    @RequestMapping(value="/delete",method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@RequestParam("ids")List<Object> ids){
        try {
            if(ids.size()==0){
                //参数列表错误400
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            Integer result = orderService.deleteByExample("id", ids);
            if(result!=1){
                //删除失败
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
            //删除成功
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //服务器有异常500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
