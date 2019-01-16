package cn.itcast.sso.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import cn.itcast.sso.io.Result;
import cn.itcast.sso.manager.manager;
import cn.itcast.sso.pojo.User;
import cn.itcast.sso.utils.CookieUtils;


//@RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用。本来应该到success.jsp页面的，则其显示success
@Controller
@RequestMapping("/user")
public class UserController {
    
    private static final String COOKIE_NAME = "TT_TOKEN";
    
    @Autowired
    private manager manager;
    
    /**
     * 跳转到注册页
     *
     * @return
     */
    @GetMapping("/register")
    public String toRegister() {
        return "register";
    }
    
    /**
     * 跳转到登录页
     * 
     * @return
     */
    @GetMapping(value = "/login")
    public String toLogin() {
        return "login";
    }
    
    /**
     * 校验数据是否可用
     * 
     * @param param
     * @param type
     * @return
     */
    @GetMapping(value = "/check/{param}/{type}")
    public ResponseEntity<Boolean> checkData(@PathVariable("param") String param,
            @PathVariable("type") Integer type) {
        try {
            Boolean boo = this.manager.checkData(param, type);
            if (boo == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
            return ResponseEntity.ok(boo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    /**
     * 注册功能
     * 
     * @param user
     * @return
     */
    @PostMapping(value = "doRegister")
    public Result register(@Valid User user, BindingResult result) {
        try {
            // 检查校验结果
            if (result.hasErrors()) {
                List<String> msgs = new ArrayList<>();
                for (ObjectError error : result.getAllErrors()) {
                    msgs.add(error.getDefaultMessage());
                }
                return Result.build(400, StringUtils.join(msgs, "|"));
            }

            boolean boo = this.manager.register(user);
            if (!boo) {
                return Result.build(400, "参数有误");
            }
            return Result.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(500, "注册失败，未知异常！");
        }
    }
    
    /**
     * 用户登录
     * 
     * @param username
     * @param password
     * @return
     */
    @PostMapping(value = "doLogin")
    public Result doLogin(@RequestParam(value="username",required=true) String username,
            @RequestParam(value="password",required=true) String password, HttpServletRequest request,
            HttpServletResponse response) {
        try {
            // 登录
            String token = this.manager.doLogin(username, password);
            if (token == null) {
                return Result.build(400, "用户名或者密码错误");
            }
            // 登录成功，把token写入cookie中
            CookieUtils.setCookie(request, response, COOKIE_NAME, token);
            // 返回结果
            return Result.ok(token);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(500, "登录失败，未知异常！"+e.toString());
        }
    }
    
    /**
     * 根据token查询用户
     * @param token
     * @return
     */
    @GetMapping(value = "{token}")
    public String queryUserByToken(@PathVariable("token") String token) {
        try {
            return JSON.toJSONString(this.manager.queryUserByToken(token));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
  
}