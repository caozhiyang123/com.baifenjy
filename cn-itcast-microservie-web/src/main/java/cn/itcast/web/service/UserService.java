package cn.itcast.web.service;

import org.springframework.stereotype.Service;

import cn.itcast.web.feign.UserOfEduClient;
import cn.itcast.web.util.JsonUtils;
import cn.itcast.web.vo.User;

@Service
public class UserService {

    private UserOfEduClient userOfEduClient;
    public User queryUserByToken(String token){
        try
        {
            return JsonUtils.toBean(userOfEduClient.queryUserByToken(token), User.class);
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        } 
    }
}
