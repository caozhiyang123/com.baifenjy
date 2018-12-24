package cn.itcast.sso.manager;

import java.io.IOException;
import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mysql.jdbc.StringUtils;

import cn.itcast.sso.pojo.User;
import cn.itcast.sso.utils.JsonUtils;
import cn.itcast.sso.utils.RedisService;
import cn.itcast.sso.utils.ThreadLocalSimple;
import cn.itcast.sso.service.UserService;

@Service
public class manager {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;

    public Boolean checkData(String param, Integer type) {
        User record = new User();
        // 设置条件
        switch (type) {
        case 1:
            record.setUsername(param);
            break;
        case 2:
            record.setPhone(param);
            break;
        case 3:
            record.setEmail(param);
            break;
        default:
            return null;
        }
        return this.userService.selectCount(record) == 0;
    }

    public boolean register(User user) {
        //初始化一些参数
        user.setId(null);
        String date = ThreadLocalSimple.df.get().format(new Date());
        user.setCreated(date);
        user.setUpdated(date);
        // 密码需要加密
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        return this.userService.save(user) == null ? true:false;
    }

    public String doLogin(String username, String password) throws JsonProcessingException {
        // 校验登录信息
        // 根据用户名查询
        User user = this.userService.findUserByName(username);
        // 判断是否存在
        if (user == null) {
            // 证明用户名错误的，返回
            return null;
        }
        // 校验密码
        if (!(user.getPassword()).equals(DigestUtils.md5Hex(password))) {
            // 密码不匹配，登录失败
            return null;
        }
        // 都匹配，登录成功，生成token
        String token = DigestUtils.md5Hex(DigestUtils.md5Hex(username) + System.currentTimeMillis());

        // 写入redis
        this.redisService.setex("TOKEN_" + token.toUpperCase(), JsonUtils.toString(user), 1800);//30min

        return token;
    }

    public User queryUserByToken(String token) {
        String key = "TOKEN_" + token.toUpperCase();
        // 查询redis
        String json = this.redisService.get(key);
        if(StringUtils.isNullOrEmpty(json)){
            return null;
        }
        try {
            // 刷新redis的生存时间
            this.redisService.expire(key, 1800);
            return JsonUtils.toBean(json, User.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
