package cn.itcast.microservice.service;

import org.springframework.data.domain.Page;

import cn.itcast.microservice.entity.Teacher;

public interface TeacherService
{

    Page<Teacher> pageQuery(int pageNum, int pageSize, Teacher teacher);

    Teacher queryByName(String name);

    Teacher queryByPhoneNum(String phoneNum);

    void save(String name, int age, int sex, String email, String phoneNum, String qqNum, String weChatNum, String address, String idCard, String college, String profession, String otherImports, String certification, String canTeacherGrade, String canTeacherSubject, String canTeacherArea, String teachExperience);

}
