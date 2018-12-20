package cn.itcast.microservice.item.dao;

public class DaoFactory
{
    public static ItemDao getItemDao(){return new ItemDao();}
}
