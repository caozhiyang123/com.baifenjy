package cn.itcast.microservice.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by czy on 2018-03-22.
 */
@Component
public class UserLoginZuulFilter extends ZuulFilter {


    @Override
    public boolean shouldFilter() {
        //该过滤器需要执行
        return true;
    }

    @Override
    public Object run() {
       RequestContext requestContext= RequestContext.getCurrentContext();
       HttpServletRequest request = requestContext.getRequest();
       String token = request.getParameter("token");
       if("1".equals(token)){
           return null;
       }
       requestContext.setSendZuulResponse(false);//过滤该请求，不对其进行路由
       requestContext.setResponseStatusCode(401);//设置响应状态码
       return null;
    }


    @Override
    public String filterType() {
//        设置过滤器类型为"pre"前置过滤器
        return "pre";
    }

    @Override
    public int filterOrder() {
//        设置执行顺序
        return 0;
    }
}
