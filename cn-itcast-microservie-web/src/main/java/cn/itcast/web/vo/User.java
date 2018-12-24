package cn.itcast.web.vo;

import java.util.Date;

public class User {
    private Long id;

    private String username;// 用户名

    private String password;// 密码

    private String phone;// 电话

    private String email;// 邮箱

    private String created;// 创建时间

    private String updated;// 更新时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
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
