package cn.itcast.microservice.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class BasePojo implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Column(unique=true,name="created",columnDefinition="varchar(50) not null")
    private String created;

    @Column(unique=true,name="created",columnDefinition="varchar(50) not null")
    private String updated;

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
