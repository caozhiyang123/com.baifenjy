package cn.itcast.sso.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import cn.itcast.sso.pojo.User;
import cn.itcast.sso.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public User save(User user) {
        return this.userRepository.save(user);
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
    public User findUserByName(String username){
        /*User user = new User();
        user.setUsername(username);
        Example<User> example = Example.of(user);
        return this.userRepository.findOne(example);*/
        return this.userRepository.findUserByUsername(username);
    }

    @Override
    public int selectCount(User user)
    {
        if(!StringUtils.isBlank(user.getUsername())){
            return this.userRepository.findUserByUsername(user.getUsername()) == null ? 0:1;
        }else if(!StringUtils.isBlank(user.getEmail())){
            return this.userRepository.findUserByEmail(user.getEmail()) == null ? 0:1;
        }else if(!StringUtils.isBlank(user.getPhone())){
            return this.userRepository.findUserByPhone(user.getPhone()) == null ? 0:1;
        }
        return 0;
    }
}
