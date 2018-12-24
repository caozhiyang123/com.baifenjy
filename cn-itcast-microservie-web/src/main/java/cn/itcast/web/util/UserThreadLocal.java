package cn.itcast.web.util;

import cn.itcast.web.vo.User;

/**
 * 存放User对象的线程域
 * @author zhy
 *
 */
public class UserThreadLocal {
    private static final ThreadLocal<User> TL = new ThreadLocal<>();
    
    /**
     * 存储用户
     * @param user
     */
    public static void set(User user){
        TL.set(user);
    }
    
    /**
     * 获取用户
     * @return
     */
    public static User get(){
        return TL.get();
    }
    
    /**
     * 删除用户
     */
    public static void remove(){
        TL.remove();
    }
}
