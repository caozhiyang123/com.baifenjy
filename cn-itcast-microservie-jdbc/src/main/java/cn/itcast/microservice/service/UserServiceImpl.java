package cn.itcast.microservice.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import cn.itcast.microservice.entity.User;
import cn.itcast.microservice.repository.UserRepository;

@Transactional(readOnly = true)
@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository userRepository;
    
    @Transactional(readOnly = false)
    @Override
    public void save(User user) {
        this.userRepository.save(user);
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(long id) {
        this.userRepository.delete(id);
    }

    @Transactional(readOnly = false)
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
