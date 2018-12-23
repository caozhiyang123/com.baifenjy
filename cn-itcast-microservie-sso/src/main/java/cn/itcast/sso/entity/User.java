package cn.itcast.sso.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user",uniqueConstraints={@UniqueConstraint(name="name_pass",columnNames={"username","password"})}) //映射的表名称
public class User implements Serializable{
    
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @Column(unique=true,name="username",columnDefinition="varchar(200) not null")
  private String username;

  @Column(unique=false,name="password",columnDefinition="varchar(200) not null")
  private String password;

  @Column(unique=false,name="age",columnDefinition="tinyint(3)")
  private Integer age;

  @Column(unique=false,name="balance",columnDefinition="bigint(22)")
  private long balance;

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

public Integer getAge() {
    return this.age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

public long getBalance()
{
    return balance;
}

public void setBalance(long balance)
{
    this.balance = balance;
}

}