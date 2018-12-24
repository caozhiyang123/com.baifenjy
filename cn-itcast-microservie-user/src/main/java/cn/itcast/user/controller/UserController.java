package cn.itcast.user.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import cn.itcast.user.entity.User;
import cn.itcast.user.service.UserService;
import cn.itcast.user.util.ThreadLocalSimple;


@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    
    /**
     * find the specifical one by id  ,get request
     *
     * http://localhost:6873/simple/2
     *
     * @return
     */
    @GetMapping("/{id}")
    public User findUserById(@PathVariable Long id) {
        return this.userService.findUserById(id);
    }

    /**
     * query all  ,get request
     *
     * http://localhost:6873/simple/list
     *
     * @return
     */
    @GetMapping("/list")
    public List<User> findUserList() {
        return this.userService.findUserList();
    }
    
    /**
     * check data
     *
     * http://localhost:6873/check?username=user11&password=czy123
     *
     * @return
     */
    /**
     * login ,get request
     *
     * http://localhost:6873/simple/login?username=user11&password=czy123
     *
     * @return
     */
    @PostMapping("/login")
    public String findUserByNameAndPass(@RequestParam(value = "username",required = true) String username){
        User user = this.userService.findUserByName(username);
        return JSON.toJSONString(user);
    }

    /**
     * register ,get request
     *
     * http://localhost:6873/simple/register?username=user11&password=czy123
     *
     * @return
     */
    @PostMapping("/register")
    public void addUser(@RequestParam(value = "username", required=true) String username,@RequestParam(value = "password", required=true) String password
           ,@RequestParam(value = "phone", required=true) String phone,@RequestParam(value = "email", required=true) String email){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPhone(phone);
        user.setEmail(email);
        String date = ThreadLocalSimple.df.get().format(new Date());
        user.setCreated(date);
        user.setUpdated(date);
        this.userService.save(user);
    }
    
}