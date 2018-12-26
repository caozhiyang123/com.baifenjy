package cn.itcast.sso.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import cn.itcast.sso.dao.UserDao;
import cn.itcast.sso.pojo.User;
import cn.itcast.sso.repository.UserRepository;


@Service
@Transactional(readOnly=true)
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserDao userDao;
    
    @Override
    public List<User> findUserList() {
       return this.userDao.findUserList();
    }
    
    @Override
    public User findUserByName(String username){
        return this.userDao.findUserByUsername(username);
    }
    
    @Override
    @Transactional(readOnly=false)
    public int save(User user) {
        return this.userDao.save(user);
    }
    

    @Override
    public int selectCount(User user)
    {
        if(!StringUtils.isBlank(user.getUsername())){
            return this.userDao.findUserByUsername(user.getUsername()) == null ? 0:1;
        }else if(!StringUtils.isBlank(user.getEmail())){
            return this.userDao.findUserByEmail(user.getEmail()) == null ? 0:1;
        }else if(!StringUtils.isBlank(user.getPhone())){
            return this.userDao.findUserByPhone(user.getPhone()) == null ? 0:1;
        }
        return 0;
    }
}
