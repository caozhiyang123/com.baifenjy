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
    
    @Column(name="order_item",columnDefinition="varchar(50)")
    private String orderItem;
    
    @Column(name="order_additional",columnDefinition="varchar(50)")
    private String orderAdditional;
    
    @Column(name="teacher_item",columnDefinition="varchar(50)")
    private String teacherItem;
    
    @Column(name="teacher_additional",columnDefinition="varchar(50)")
    private String teacherAdditional;
    
    @Column(name="status",columnDefinition="tinyint(2)")
    private Byte status;//0:undo,1:doing,2:success,3:fail
    
    @Column(name="created",columnDefinition="varchar(50) not null")
    private String created;

    @Column(name="updated",columnDefinition="varchar(50) not null")
    private String updated;
    
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
    
    public String getCreated()
    {
        return created;
    }

    public void setCreated(String created)
    {
        super.setCreated(created);
        this.created = created;
    }

    public String getUpdated()
    {
        return updated;
    }

    public void setUpdated(String updated)
    {
        super.setUpdated(updated);
        this.updated = updated;
    }
    
}
