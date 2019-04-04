package cn.itcast.sso.manager;

import java.io.IOException;
import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mysql.jdbc.StringUtils;

import cn.itcast.sso.pojo.User;
import cn.itcast.sso.service.RedisService;
import cn.itcast.sso.service.UserService;
import cn.itcast.sso.utils.JsonUtils;
import cn.itcast.sso.utils.ThreadLocalSimple;

@Service
public class manager {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;
    
    private static final String TOKEN = "TOKEN_";

    public Boolean checkData(String param, Integer type) {
        User record = new User();
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
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        return this.userService.save(user) == 1 ? true:false;
    }

    public String doLogin(String username, String password) throws JsonProcessingException {
        User user = this.userService.findUserByName(username);
        if (user == null) {
            return null;
        }
        if (!(user.getPassword()).equals(DigestUtils.md5Hex(password))) {
            return null;
        }
        String token = DigestUtils.md5Hex(DigestUtils.md5Hex(username) + System.currentTimeMillis());

        this.redisService.setex(TOKEN + token.toUpperCase(), JsonUtils.toString(user), 1800);//30min

        return token;
    }

    public User queryUserByToken(String token) {
        String key = TOKEN + token.toUpperCase();
        String json = this.redisService.get(key);
        if(StringUtils.isNullOrEmpty(json)){
            return null;
        }
        try {
            this.redisService.expire(key, 1800);
            return JsonUtils.toBean(json, User.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
