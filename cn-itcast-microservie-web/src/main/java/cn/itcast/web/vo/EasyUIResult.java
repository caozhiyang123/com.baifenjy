package cn.itcast.web.vo;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("all")
public class EasyUIResult {
	private Long total;
	private List<?> rows;
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
	
	public static  EasyUIResult  formatToList(String jsonData,Class clazz){
	    EasyUIResult easyUIResult = null;
	    try {
                ObjectMapper mapper = new ObjectMapper();
                easyUIResult = (EasyUIResult)mapper.readValue(jsonData, clazz);
                return easyUIResult;
            } catch (Exception e) {
                e.printStackTrace();
            } 
	    return easyUIResult;
	    
	}
	
}
