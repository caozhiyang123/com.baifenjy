package cn.itcast.microservice.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.microservice.entity.Teacher;
import cn.itcast.microservice.repository.TeacherRepository;
import cn.itcast.microservice.utils.ThreadLocalSimple;

@Transactional(readOnly=true)
@Service
public class TeacherServiceImpl implements TeacherService
{
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Page<Teacher> pageQuery(int pageNum, int pageSize, Teacher teacher)
    {
            Order timeOrder = new Order(Direction.ASC, "createAt");
            Sort sort = new Sort(timeOrder);
            Pageable pageRequest  = new PageRequest(pageNum, pageSize, sort);
            
            Page<Teacher> page = this.teacherRepository.findAll(pageRequest);
            /*System.out.println("总记录数:" + page.getTotalElements());
            System.out.println("总页数:" + page.getTotalPages());
            System.out.println("当前页（request):" + page.getNumber());
            System.out.println("当前页总记录数（request):" + page.getSize());
            System.out.println("当前页记录总数：" + page.getNumberOfElements());*/
            /*List<Teacher> tes = page.getContent();
            for (Teacher t : tes) {
                System.out.println(t);
            }*/
            return page;
    }

    @Override
    public Teacher queryByName(String name)
    {
        return this.teacherRepository.findByName(name);
    }

    @Override
    public Teacher queryByPhoneNum(String phoneNum)
    {
        return this.teacherRepository.findByPhone(phoneNum);
    }

    @Transactional(readOnly=false)
    @Override
    public void save(String name, int age, int sex, String email, String phoneNum, String qqNum, String weChatNum,
            String address, String idCard, String college, String profession, String otherImports, String certification,
            String canTeacherGrade, String canTeacherSubject, String canTeacherArea, String teachExperience)
    {
        Teacher teacher = new Teacher(name,age,sex,email,phoneNum,qqNum,weChatNum,address,idCard,college
                ,profession,otherImports,certification,canTeacherGrade,canTeacherSubject,canTeacherArea
                ,teachExperience,ThreadLocalSimple.df.get().format(new Date()));
        this.teacherRepository.save(teacher);
    }    
    
    
}
