package cn.itcast.user.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cn.itcast.user.entity.User;



/**
* 用户数据交互接口
* JpaRepository<用户实体类，用户实体类中的主键类型>
* 如果是自定义接口，一定要在接口上添加@Repository注解
*
*/

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
    @Query(value="select * from user where username = ?1 and password = ?2",nativeQuery=true)
    User findUserByUsernameAndPassword(String username ,String password);
    
    /**
     * 根据用户ID查询一条数据，jpa有一定的查询规则，以一些通用前缀开头，比如findBy、find、get等
     * 如果不想用这种默认规则，需要在接口上添加@Query主键，自定义实现数据查询，如下面一个接口
     * @param userid
     * @return
     */
    public User findByid(long id);
    
    /**
     * jpa支持对象查询，简称HQL，也支持原生sql查询
     * @return
     */
    @Query(value="select * from user",nativeQuery=true)
    public List<User> listUserEntity();
    
    User findByUsername(String userName);
    
    User findByAge(Integer age);

    User findByUsernameAndAge(String userName, Integer age);
    
    List<User> findByUsernameLike(String username);


}
