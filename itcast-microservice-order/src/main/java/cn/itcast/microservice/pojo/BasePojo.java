package cn.itcast.microservice.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
public abstract class BasePojo implements Serializable{

    @Column(name="created",columnDefinition="varchar(50)")
    public String created;

    @Column(name="updated",columnDefinition="varchar(50)")
    public String updated;

    public String getCreated()
    {
        return created;
    }

    public void setCreated(String created)
    {
        this.created = created;
    }

    public String getUpdated()
    {
        return updated;
    }

    public void setUpdated(String updated)
    {
        this.updated = updated;
    }
    
    
    

}
