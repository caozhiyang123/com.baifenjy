package cn.itcast.web.pojo;

import java.io.Serializable;

public class Order extends BasePojo implements Serializable{
    private static final long serialVersionUID = 1L;
    private long id;
    private String name;
    private String message;
    private String callMessage;
    private String time;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getCallMessage() {
        return callMessage;
    }
    public void setCallMessage(String callMessage) {
        this.callMessage = callMessage;
    }
    @Override
    public String toString() {
        return "Order [time=" + time + ", name=" + name + ", message=" + message + ", callMessage="
                + callMessage + "]";
    }
    
}
