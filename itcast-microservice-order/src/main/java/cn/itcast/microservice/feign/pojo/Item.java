package cn.itcast.microservice.feign.pojo;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.itcast.microservice.pojo.BasePojo;

public class Item extends BasePojo{
    private static final long serialVersionUID = 1L;
    
    private Long id;
    
    private String title;
    
    private String item_desc;
    
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
    public String getItem_desc()
    {
        return item_desc;
    }
    public void setItem_desc(String item_desc)
    {
        this.item_desc = item_desc;
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
    public Item(String title, String item_desc, String others, String price)
    {
        super();
        this.title = title;
        this.item_desc = item_desc;
        this.others = others;
        this.price = price;
    }
    
    public Item(String title, String item_desc, String others, String price,String updated,String created)
    {
        super();
        this.title = title;
        this.item_desc = item_desc;
        this.others = others;
        this.price = price;
        this.updated = updated;
        this.created = created;
    }
    
    /**
     * jackson readValue rely on this construct
     */
    public Item()
    {
    }
    
    @Override
    public String toString()
    {
        return "Item [id=" + id + ", title=" + title + ", item_desc=" + item_desc + ", others=" + others + ", price="
                + price + ", created=" + created + ", updated=" + updated + "]";
    }
}
