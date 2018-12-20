package cn.itcast.sso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import cn.itcast.sso.entity.User;
import cn.itcast.sso.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public void save(User user) {
        this.userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        this.userRepository.delete(id);
    }

    @Override
    public List<User> findAll(){
        return (List<User>) this.userRepository.findAll();
    }
    
    @Override
    public User findUserById(@PathVariable Long id) {
        return this.userRepository.findByid(id);
    }
    
    @Override
    public List<User> findUserList() {
        return this.userRepository.listUserEntity();
    }
    
    @Override
    public User findUserByNameAndPass(String username,String password){
        /*User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        Example<User> example = Example.of(user);
        return this.userRepository.findOne(example);*/
        return this.userRepository.findUserByUsernameAndPassword(username, password);
    }
}
