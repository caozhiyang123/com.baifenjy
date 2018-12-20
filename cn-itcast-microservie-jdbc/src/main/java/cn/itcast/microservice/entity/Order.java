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
@Table(name = "order") //映射的表名称
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    
    @Column(unique=true,name="name",columnDefinition="varchar(100) not null")
    private String orderId;
    
    @Column(unique=false,name="student_name",columnDefinition="varchar(10)")
    private String StudentName;
    
    @Column(unique=false,name="student-age",columnDefinition="tinyint(3)")
    private int StudentAge;
    
    @Column(unique=false,name="student_sex",columnDefinition="tinyint(2)")
    private int StudentSex;
    
    @Column(unique=false,name="student_grade",columnDefinition="varchar(10)")
    private String StudentGrade;
    
    @Column(unique=false,name="student——subject",columnDefinition="varchar(20)")
    private String StudentSubject;
    
    @Column(unique=false,name="address",columnDefinition="varchar(30)")
    private String address;
    
    @Column(unique=false,name="other_importants",columnDefinition="varchar(40)")
    private String otherImportants;
    
    @Column(unique=false,name="cost",columnDefinition="varchar(10)")
    private String cost;
    
    @Column(unique=false,name="parents_name",columnDefinition="varchar(10)")
    private String parentsName;
    
    @Column(unique=false,name="phone_num",columnDefinition="bigint(11)")
    private long phoneNum;

    @Column(unique=false,name="phone",columnDefinition="bigint(11)")
    private long phone;
    
    @Column(unique=false,name="qqNum",columnDefinition="bigint(20)")
    private long qqNum;
    
    @Column(unique=false,name="weChat_num",columnDefinition="varchar(100)")
    private String weChatNum;
    
    @Column(unique=false,name="message_resource",columnDefinition="varchar(200)")
    private String messageResource;

    @Column(unique=false,name="create_at",columnDefinition="varchar(50) not null")
    private String createAt;
    
    public Order()
    {
        super();
    }
    public Order(long id, String orderId,String studentName, int studentAge, int studentSex, String studentGrade,
            String studentSubject, String address, String otherImportants, String cost, String parentsName,
            long phoneNum,long phone, long qqNum, String weChatNum, String messageResource,String createAt) {
        this.id = id;
        this.orderId = orderId;
        StudentName = studentName;
        StudentAge = studentAge;
        StudentSex = studentSex;
        StudentGrade = studentGrade;
        StudentSubject = studentSubject;
        this.address = address;
        this.otherImportants = otherImportants;
        this.cost = cost;
        this.parentsName = parentsName;
        this.phoneNum = phoneNum;
        this.phone = phone;
        this.qqNum = qqNum;
        this.weChatNum = weChatNum;
        this.messageResource = messageResource;
        this.createAt = createAt;
    }
    
    @JSONField(serialize = false)
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
        return StudentName;
    }
    public void setStudentName(String studentName) {
        StudentName = studentName;
    }
    public int getStudentAge() {
        return StudentAge;
    }
    public void setStudentAge(int studentAge) {
        StudentAge = studentAge;
    }
    public int getStudentSex() {
        return StudentSex;
    }
    public void setStudentSex(int studentSex) {
        StudentSex = studentSex;
    }
    public String getStudentGrade() {
        return StudentGrade;
    }
    public void setStudentGrade(String studentGrade) {
        StudentGrade = studentGrade;
    }
    public String getStudentSubject() {
        return StudentSubject;
    }
    public void setStudentSubject(String studentSubject) {
        StudentSubject = studentSubject;
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
    public long getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(long phoneNum) {
        this.phoneNum = phoneNum;
    }
    
    @NumberDesensitization
    public long getPhone()
    {
        return phone;
    }
    public void setPhone(long phone)
    {
        this.phone = phone;
    }
    public long getQqNum() {
        return qqNum;
    }
    public void setQqNum(long qqNum) {
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
    
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    public String getCreateAt()
    {
        return createAt;
    }
    public void setCreateAt(String createAt)
    {
        this.createAt = createAt;
    }
    
    

}
