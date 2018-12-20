package cn.itcast.microservice.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.serializer.ContextValueFilter;

public class ZreContextValueFilter implements ContextValueFilter {
	
	private final static Logger logger = LoggerFactory.getLogger(ZreContextValueFilter.class);
 
	@Override
	public Object process(BeanContext context, Object object, String name, Object value) {
		if (value == null || !(value instanceof String)) {
			return value;
		}
		NumberDesensitization annation = context.getAnnation(NumberDesensitization.class);
		if (annation == null) {
			return value;
		}
		String propertyValue = (String) value;
		if (StringUtils.isEmpty(propertyValue)) {
			return "";
		}
		logger.debug("脱敏手机号成功："+propertyValue);
		propertyValue = String.format("%s****%s",propertyValue.substring(0, 3), propertyValue.substring(7));
		return propertyValue;
	}
}