package cn.itcast.sso.io;

/**
 * 通用的页面结果对象
 */
public class Result {

    private Integer status;// 业务状态码，200代表成功

    private String msg;// 返回页面的消息

    private Object data;// 可能要携带的数据
    
    public Result() {
        super();
    }

    // 构造函数
    public Result(Integer status) {
        super();
        this.status = status;
    }

    public Result(Integer status, String msg) {
        this(status);
        this.msg = msg;
    }

    public Result(Integer status, String msg, Object data) {
        this(status, msg);
        this.data = data;
    }

    // 快捷获取200状态
    public static Result ok() {
        return new Result(200);
    }

    // 快捷获取200状态
    public static Result ok(Object data) {
        return new Result(200, null, data);
    }

    // 快捷获取PageResult对象
    public static Result build(Integer status, String msg) {
        return new Result(status, msg);
    }

    // 快捷获取PageResult对象
    public static Result build(Integer status, String msg, Object data) {
        return new Result(status, msg, data);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
