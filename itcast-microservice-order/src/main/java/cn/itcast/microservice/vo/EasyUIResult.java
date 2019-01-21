package cn.itcast.microservice.vo;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("all")
public class EasyUIResult implements Serializable{
    
    //序列化为json数据时以t作为k
//    @JsonProperty("t")
	private Long total;
    
    //序列化为json数据时以r作为k
//    @JsonProperty("r")
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
