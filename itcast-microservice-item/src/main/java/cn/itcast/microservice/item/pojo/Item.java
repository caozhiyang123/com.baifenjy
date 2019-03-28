package cn.itcast.microservice.item.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_item")
public class Item extends BasePojo{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique=true,name="title",columnDefinition="varchar(50) not null")
    private String title;
    
    @Column(name="item_desc",columnDefinition="varchar(50)")
    private String item_desc;
    
    @Column(name="others",columnDefinition="varchar(50)")
    private String others;
    
    @Column(name="price",columnDefinition="varchar(50)")
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
    
}
