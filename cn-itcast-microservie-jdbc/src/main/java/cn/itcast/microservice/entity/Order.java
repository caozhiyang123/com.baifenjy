package cn.itcast.microservice.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;

import cn.itcast.microservice.config.NumberDesensitization;

@Entity
@Table(name = "order_edu") //映射的表名称
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    
    @Column(unique=true,name="order_id",columnDefinition="varchar(5) not null")
    private String orderId;
    
    @Column(unique=false,name="student_name",columnDefinition="varchar(10)")
    private String studentName;
    
    @Column(unique=false,name="student_age",columnDefinition="tinyint(3)")
    private int studentAge;
    
    @Column(unique=false,name="student_sex",columnDefinition="tinyint(2)")
    private int studentSex;
    
    @Column(unique=false,name="student_grade",columnDefinition="varchar(10)")
    private String studentGrade;
    
    @Column(unique=false,name="student_subject",columnDefinition="varchar(20)")
    private String studentSubject;
    
    @Column(unique=false,name="address",columnDefinition="varchar(30)")
    private String address;
    
    @Column(unique=false,name="other_importants",columnDefinition="varchar(40)")
    private String otherImportants;
    
    @Column(unique=false,name="cost",columnDefinition="varchar(10)")
    private String cost;
    
    @Column(unique=false,name="parents_name",columnDefinition="varchar(10)")
    private String parentsName;
    
    @Column(unique=false,name="phone_num",columnDefinition="varchar(11)")
    private String phoneNum;
    
    @Column(unique=false,name="qq_num",columnDefinition="varchar(20)")
    private String qqNum;
    
    @Column(unique=false,name="we_chat_num",columnDefinition="varchar(100)")
    private String weChatNum;
    
    @Column(unique=false,name="message_resource",columnDefinition="varchar(200)")
    private String messageResource;

    @Column(unique=false,name="create_at",columnDefinition="varchar(50) not null")
    private String createAt;
    
    public Order()
    {
        super();
    }
    public Order(String orderId,String studentName, int studentAge, int studentSex, String studentGrade,
            String studentSubject, String address, String otherImportants, String cost, String parentsName,
            String phoneNum, String qqNum, String weChatNum, String messageResource,String createAt) {
        this.orderId = orderId;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentSex = studentSex;
        this.studentGrade = studentGrade;
        this.studentSubject = studentSubject;
        this.address = address;
        this.otherImportants = otherImportants;
        this.cost = cost;
        this.parentsName = parentsName;
        this.phoneNum = phoneNum;
        this.qqNum = qqNum;
        this.weChatNum = weChatNum;
        this.messageResource = messageResource;
        this.createAt = createAt;
    }
    
    @JSONField(serialize = true)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public int getStudentAge() {
        return studentAge;
    }
    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }
    public int getStudentSex() {
        return studentSex;
    }
    public void setStudentSex(int studentSex) {
        this.studentSex = studentSex;
    }
    public String getStudentGrade() {
        return studentGrade;
    }
    public void setStudentGrade(String studentGrade) {
        this.studentGrade = studentGrade;
    }
    public String getStudentSubject() {
        return studentSubject;
    }
    public void setStudentSubject(String studentSubject) {
        this.studentSubject = studentSubject;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getOtherImportants() {
        return otherImportants;
    }
    public void setOtherImportants(String otherImportants) {
        this.otherImportants = otherImportants;
    }
    public String getCost() {
        return cost;
    }
    public void setCost(String cost) {
        this.cost = cost;
    }
    public String getParentsName() {
        return parentsName;
    }
    public void setParentsName(String parentsName) {
        this.parentsName = parentsName;
    }
    
    @NumberDesensitization
    public String getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    
    public String getQqNum() {
        return qqNum;
    }
    public void setQqNum(String qqNum) {
        this.qqNum = qqNum;
    }
    public String getWeChatNum() {
        return weChatNum;
    }
    public void setWeChatNum(String weChatNum) {
        this.weChatNum = weChatNum;
    }
    public String getMessageResource() {
        return messageResource;
    }
    public void setMessageResource(String messageResource) {
        this.messageResource = messageResource;
    }
    
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    public String getCreateAt()
    {
        return createAt;
    }
    public void setCreateAt(String createAt)
    {
        this.createAt = createAt;
    }
    
    

}
