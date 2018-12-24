package cn.itcast.sso.service;

import java.util.List;

import cn.itcast.sso.pojo.User;


public interface UserService
{
    User  findUserById(Long id);
    List<User> findUserList();
    User findUserByName(String username);
    User save(User user);
    List<User> findAll();
    void delete(long id);
    int selectCount(User record);
}
