package cn.itcast.microservice.item.service;


import cn.itcast.microservice.item.dao.DaoFactory;
import cn.itcast.microservice.item.domain.Item;
import org.springframework.stereotype.Service;


@Service
public class ItemService {

    public Item queryItemById(Long id) {
        return  DaoFactory.getItemDao().getItemById(id);
    }

}
