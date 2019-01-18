package cn.itcast.microservice.convert;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/*
 * 自定义响应体通知，实现jsonp功能（AOP面向切面编程思想，通知）
 */
@ControllerAdvice
public class JsonResponseBodyAdvice extends AbstractJsonpResponseBodyAdvice {

    public JsonResponseBodyAdvice() {
        super("callback","jsonp");
    }
    
}
