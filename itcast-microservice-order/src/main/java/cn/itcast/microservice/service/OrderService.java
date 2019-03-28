package cn.itcast.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;

import cn.itcast.microservice.feign.pojo.Item;
import cn.itcast.microservice.pojo.Order;
import cn.itcast.microservice.vo.Reply;

@Service
public class OrderService extends BaseService<Order>
{
    @Autowired
    private ItemService itemService;
    
    @Override
    public PageInfo<Order> queryPageSorted(Order record,Integer page,Integer rows,String sort, String order) throws Exception{
        PageInfo<Order> pageInfo = super.queryPageSorted(record, page, rows, sort, order);
        List<Order> orders = pageInfo.getList();
        for (Order or : orders)
        {
            Item item = itemService.queryItemById(or.getItemId());
            if(item == null || (item!=null && Reply.NO_ITEM.equals(item.getItem_desc()))){
                or.setOrderItem(Reply.NO_ITEM);
            }else{
                or.setOrderItem(item.toString());
            }
        }
        return pageInfo;
    }
}
