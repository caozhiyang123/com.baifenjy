package cn.itcast.microservice.feign.pojo;

import cn.itcast.microservice.pojo.BasePojo;

public class Item extends BasePojo{
    private static final long serialVersionUID = 1L;
    
    private Long id;
    
    private String title;
    
    private String desc;
    
    private String others;
    
    private String price;
    
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public String getDesc()
    {
        return desc;
    }
    public void setDesc(String desc)
    {
        this.desc = desc;
    }
    public String getOthers()
    {
        return others;
    }
    public void setOthers(String others)
    {
        this.others = others;
    }
    public String getPrice()
    {
        return price;
    }
    public void setPrice(String price)
    {
        this.price = price;
    }
    public Item(String title, String desc, String others, String price)
    {
        super();
        this.title = title;
        this.desc = desc;
        this.others = others;
        this.price = price;
    }
    
    
}
