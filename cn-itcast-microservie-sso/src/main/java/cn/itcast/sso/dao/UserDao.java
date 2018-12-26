package cn.itcast.sso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.itcast.sso.pojo.User;


@Repository
public class UserDao
{
    Logger logger = LoggerFactory.getLogger(UserDao.class);
    
    private static final String TABLE = "user";
    private static final String ID = "id";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String PHONE = "phone";
    private static final String EMAIL = "email";
    private static final String CREATED = "created";
    private static final String UPDATED = "updated";
    
    @Autowired
    private DataSource dataSource;
    
    public User findUserByUsername(String username){
        User user = new User();
        user.setUsername(username);
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try
        {
            conn = dataSource.getConnection();
            String sql = String.format("select * from %s where %s = ?", TABLE,USERNAME);
            pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            rst = pst.executeQuery();
            if(rst == null){
                return null;
            }
            while(rst.next()){
                user.setId(rst.getLong(ID));
                user.setPassword(rst.getString(PASSWORD));
                user.setPhone(rst.getString(PHONE));
                user.setEmail(rst.getString(EMAIL));
                user.setCreated(rst.getString(CREATED));
                user.setUpdated(rst.getString(UPDATED));
            }
            return user;
        } catch (SQLException e)
        {
            e.printStackTrace();
            logger.error("findUserByUsername failed :", e);
            return user;
        }
    }
    
    public User findUserByEmail(String email){
        User user = new User();
        user.setEmail(email);
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try
        {
            conn = dataSource.getConnection();
            String sql = String.format("select * from %s where %s = ?", TABLE,EMAIL);
            pst = conn.prepareStatement(sql);
            pst.setString(1, email);
            rst = pst.executeQuery();
            if(rst == null){
                return null;
            }
            while(rst.next()){
                user.setId(rst.getLong(ID));
                user.setUsername(rst.getString(USERNAME));
                user.setPassword(rst.getString(PASSWORD));
                user.setPhone(rst.getString(PHONE));
                user.setCreated(rst.getString(CREATED));
                user.setUpdated(rst.getString(UPDATED));
            }
            return user;
        } catch (SQLException e)
        {
            e.printStackTrace();
            logger.error("findUserByEmail failed :", e);
            return user;
        }
    }

    public User findUserByPhone(String phone){
        User user = new User();
        user.setPhone(phone);
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try
        {
            conn = dataSource.getConnection();
            String sql = String.format("select * from %s where %s = ?", TABLE,PHONE);
            pst = conn.prepareStatement(sql);
            pst.setString(1, phone);
            rst = pst.executeQuery();
            if(rst == null){
                return null;
            }
            while(rst.next()){
                user.setId(rst.getLong(ID));
                user.setUsername(rst.getString(USERNAME));
                user.setPassword(rst.getString(PASSWORD));
                user.setEmail(rst.getString(EMAIL));
                user.setCreated(rst.getString(CREATED));
                user.setUpdated(rst.getString(UPDATED));
            }
            return user;
        } catch (SQLException e)
        {
            e.printStackTrace();
            logger.error("findUserByPhone failed :", e);
            return user;
        }
    }
    
    
    public List<User> findUserList(){
        List<User> users = new ArrayList<User>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try
        {
            conn = dataSource.getConnection();
            String sql = String.format("select * from %s", TABLE);
            pst = conn.prepareStatement(sql);
            rst = pst.executeQuery();
            if(rst == null){
                return null;
            }
            while(rst.next()){
                User user = new User();
                user.setId(rst.getLong(ID));
                user.setUsername(rst.getString(USERNAME));
                user.setPassword(rst.getString(PASSWORD));
                user.setEmail(rst.getString(EMAIL));
                user.setPhone(rst.getString(PHONE));
                user.setCreated(rst.getString(CREATED));
                user.setUpdated(rst.getString(UPDATED));
                users.add(user);
            }
            return users;
        } catch (SQLException e)
        {
            e.printStackTrace();
            logger.error("findUserList failed :", e);
            return users;
        }
    }
    
    public int save(User user){
        Connection conn = null;
        PreparedStatement pst = null;
        try
        {
            conn = dataSource.getConnection();
            String sql = String.format("insert into %s(%s,%s,%s,%s,%s,%s) values(?,?,?,?,?,?)", TABLE,USERNAME
                    ,PASSWORD,PHONE,EMAIL,CREATED,UPDATED);
            pst = conn.prepareStatement(sql);
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getPhone());
            pst.setString(4, user.getEmail());
            pst.setString(5, user.getCreated());
            pst.setString(6, user.getUpdated());
            return pst.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
            logger.error("save user failed :"+user.toString(), e.toString());
            return 0;
        }
    
    }
}
