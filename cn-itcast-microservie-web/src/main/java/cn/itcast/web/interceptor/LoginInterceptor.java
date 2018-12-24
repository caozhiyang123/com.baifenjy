package cn.itcast.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.itcast.web.service.UserService;
import cn.itcast.web.util.CookieUtils;
import cn.itcast.web.util.UserThreadLocal;
import cn.itcast.web.vo.User;

/**
 * 登录拦截器
 * 
 * @author zhy
 *
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserService userService;
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String loginUrl = "http://sso.baifen.com/user/login.html";
        // 获取cookie
        String token = CookieUtils.getCookieValue(request, "TT_TOKEN");
        if (StringUtils.isBlank(token)) {
            // token为空，证明未登录，跳转到登录页面
            response.sendRedirect(loginUrl);
            return false;
        }
        // token存在，需要去sso系统进行校验
        User user = this.userService.queryUserByToken(token);
        if (user == null) {
            // user为null，证明登录已超时
            response.sendRedirect(loginUrl);
            return false;
        }
        // 证明已经登录
        UserThreadLocal.set(user);
        return true;
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) throws Exception {
        UserThreadLocal.remove();
    }
}
