package cn.itcast.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.itcast.microservice.entity.User;
import cn.itcast.microservice.service.UserService;

@RestController
public class ProviderUserMysqlController {
    
    @Autowired
    private UserService userService;
    
    
    /**
     * find the specifical one by id  ,get request
     *
     * http://localhost:6873/simple/2
     *
     * @return
     */
    @GetMapping("/simple/{id}")
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
    @GetMapping("/simple/list")
    public List<User> findUserList() {
        return this.userService.findUserList();
    }
    
    /**
     * login ,get request
     *
     * http://localhost:6873/simple/login?username=user11&password=czy123
     *
     * @return
     */
    @GetMapping("/simple/login")
    public User findUserByNameAndPass(@RequestParam(value = "username",required = true) String username,@RequestParam(value = "password",required = true) String password){
        return this.userService.findUserByNameAndPass(username, password);
    }

    /**
     * register ,get request
     *
     * http://localhost:6873/simple/register?username=user11&password=czy123&age=11&balance=11
     *
     * @return
     */
    @PostMapping("/simple/register")
    public void addUser(@RequestParam(value = "username", required=true) String username,@RequestParam(value = "password", required=true) String password, @RequestParam(value = "age", required=true) Integer age, @RequestParam(value = "balance", required=true) Long balance){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setAge(age);
        user.setBalance(balance);
        this.userService.save(user);
    }
    
}