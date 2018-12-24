package cn.itcast.sso.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;


@Entity
@Table(name = "user",uniqueConstraints={@UniqueConstraint(name="name_pass",columnNames={"username","password"})}) //映射的表名称
public class User implements Serializable{
    
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @Length(min = 6, max = 20, message = "用户名必须是6~20位之间")
  @Column(unique=true,name="username",columnDefinition="varchar(20) not null")
  private String username;

  @Length(min = 6, max = 20, message = "密码必须是6~20位之间")
  @Column(unique=false,name="password",columnDefinition="varchar(20) not null")
  private String password;

  @Pattern(regexp = "^1[3587]\\d{9}$", message = "手机格式不正确")
  @Column(unique=false,name="phone",columnDefinition="varchar(11) not null")
  private String phone;// 电话

  @Email(message = "邮箱格式不正确")
  @Column(unique=false,name="email",columnDefinition="varchar(50) not null")
  private String email;// 邮箱

  @Column(unique=false,name="created",columnDefinition="varchar(25) not null")
  private String created;// 创建时间

  @Column(unique=false,name="updated",columnDefinition="varchar(25) not null")
  private String updated;// 更新时间

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


   public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getPhone()
    {
        return phone;
    }
    
    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }

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
