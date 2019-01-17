package cn.itcast.microservice.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order extends BasePojo{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique=true,name="title",columnDefinition="varchar(50) not null")
    private String title;
    
    @Column(unique=true,name="order_item",columnDefinition="varchar(50)")
    private String orderItem;
    
    @Column(unique=true,name="order_additional",columnDefinition="varchar(50)")
    private String orderAdditional;
    
    @Column(unique=true,name="teacher_item",columnDefinition="varchar(50)")
    private String teacherItem;
    
    @Column(unique=true,name="teacher_additional",columnDefinition="varchar(50)")
    private String teacherAdditional;
    
    @Column(unique=true,name="status",columnDefinition="byte(2)")
    private Byte status;//0:undo,1:doing,2:success,3:fail
    
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
    public String getOrderItem()
    {
        return orderItem;
    }
    public void setOrderItem(String orderItem)
    {
        this.orderItem = orderItem;
    }
    public String getOrderAdditional()
    {
        return orderAdditional;
    }
    public void setOrderAdditional(String orderAdditional)
    {
        this.orderAdditional = orderAdditional;
    }
    public String getTeacherItem()
    {
        return teacherItem;
    }
    public void setTeacherItem(String teacherItem)
    {
        this.teacherItem = teacherItem;
    }
    public String getTeacherAdditional()
    {
        return teacherAdditional;
    }
    public void setTeacherAdditional(String teacherAdditional)
    {
        this.teacherAdditional = teacherAdditional;
    }
    public Byte getStatus()
    {
        return status;
    }
    public void setStatus(Byte status)
    {
        this.status = status;
    }
    
}
