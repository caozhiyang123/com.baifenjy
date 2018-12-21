package cn.itcast.microservice.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.alibaba.fastjson.annotation.JSONField;

import cn.itcast.microservice.config.NumberDesensitization;

@Entity
@Table(name = "teacher_tb",uniqueConstraints={@UniqueConstraint(name="name_phoneNum",columnNames={"name","phone_num"})})
public class Teacher implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    
    @Column(unique=false,name="name",columnDefinition="varchar(25) not null")
    private String name;
    
    @Column(unique=false,name="age",columnDefinition="tinyint(3)")
    private int age;
    
    @Column(unique=false,name="sex",columnDefinition="tinyint(2)")
    private int sex;
    
    @Column(unique=false,name="email",columnDefinition="varchar(100)")
    private String email;
    
    @Column(unique=true,name="phone_num",columnDefinition="varchar(11)")
    private String phoneNum;
    
    @Column(unique=false,name="qq_num",columnDefinition="varchar(20)")
    private String qqNum;
    
    @Column(unique=false,name="weChat_num",columnDefinition="varchar(100)")
    private String weChatNum;
    
    @Column(unique=false,name="address",columnDefinition="varchar(200)")
    private String address;
    
    @Column(unique=false,name="idCard",columnDefinition="varchar(20)")
    private String idCard;
    
    @Column(unique=false,name="college",columnDefinition="varchar(100)")
    private String college;
    
    @Column(unique=false,name="profession",columnDefinition="varchar(100)")
    private String profession;
    
    @Column(unique=false,name="other_imports",columnDefinition="varchar(200)")
    private String otherImports;
    
    @Column(unique=false,name="certification",columnDefinition="varchar(200)")
    private String certification;
    
    @Column(unique=false,name="can_teacherGrade",columnDefinition="varchar(200)")
    private String canTeacherGrade;
    
    @Column(unique=false,name="can_teacherSubject",columnDefinition="varchar(200)")
    private String canTeacherSubject;
    
    @Column(unique=false,name="can_teacherArea",columnDefinition="varchar(200)")
    private String canTeacherArea;
    
    @Column(unique=false,name="teach_experience",columnDefinition="varchar(200)")
    private String teachExperience;
    
    @Column(unique=false,name="create_at",columnDefinition="varchar(50) not null")
    private String createAt;
    
    public Teacher() {
        super();
    }
    public Teacher( String name, int age, int sex, String email, String phoneNum, String qqNum,
            String weChatNum, String address, String idCard, String college, String profession,
            String otherImports, String certification, String canTeacherGrade, String canTeacherSubject,
            String canTeacherArea, String teachExperience,String createAt) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.email = email;
        this.phoneNum = phoneNum;
        this.qqNum = qqNum;
        this.weChatNum = weChatNum;
        this.address = address;
        this.idCard = idCard;
        this.college = college;
        this.profession = profession;
        this.otherImports = otherImports;
        this.certification = certification;
        this.canTeacherGrade = canTeacherGrade;
        this.canTeacherSubject = canTeacherSubject;
        this.canTeacherArea = canTeacherArea;
        this.teachExperience = teachExperience;
        this.createAt = createAt;
    }
    
    @JSONField(serialize = true)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getSex() {
        return sex;
    }
    public void setSex(int sex) {
        this.sex = sex;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getIdCard() {
        return idCard;
    }
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
    public String getCollege() {
        return college;
    }
    public void setCollege(String college) {
        this.college = college;
    }
    public String getProfession() {
        return profession;
    }
    public void setProfession(String profession) {
        this.profession = profession;
    }
    public String getOtherImports() {
        return otherImports;
    }
    public void setOtherImports(String otherImports) {
        this.otherImports = otherImports;
    }
    public String getCertification() {
        return certification;
    }
    public void setCertification(String certification) {
        this.certification = certification;
    }
    public String getCanTeacherGrade() {
        return canTeacherGrade;
    }
    public void setCanTeacherGrade(String canTeacherGrade) {
        this.canTeacherGrade = canTeacherGrade;
    }
    public String getCanTeacherSubject() {
        return canTeacherSubject;
    }
    public void setCanTeacherSubject(String canTeacherSubject) {
        this.canTeacherSubject = canTeacherSubject;
    }
    public String getCanTeacherArea() {
        return canTeacherArea;
    }
    public void setCanTeacherArea(String canTeacherArea) {
        this.canTeacherArea = canTeacherArea;
    }
    public String getTeachExperience() {
        return teachExperience;
    }
    public void setTeachExperience(String teachExperience) {
        this.teachExperience = teachExperience;
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
