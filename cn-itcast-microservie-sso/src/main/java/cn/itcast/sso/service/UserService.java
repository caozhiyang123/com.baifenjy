package cn.itcast.sso.service;

import java.util.List;

import cn.itcast.sso.pojo.User;


public interface UserService
{
    List<User> findUserList();
    User findUserByName(String username);
    int save(User user);
    int selectCount(User record);
}
