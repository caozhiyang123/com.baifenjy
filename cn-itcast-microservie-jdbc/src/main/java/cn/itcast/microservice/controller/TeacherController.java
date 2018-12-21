package cn.itcast.microservice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import cn.itcast.microservice.entity.Teacher;
import cn.itcast.microservice.service.TeacherService;



@RequestMapping(value="/teacher",method=RequestMethod.GET)
@RestController
public class TeacherController
{
    @Autowired
    private TeacherService teacherService;
    
    
    /**
     * page query,get request
     *
     * http://localhost:6874/teacher/page?pageNum=1&pageSize=20
     *
     * @return
     */
    @GetMapping("/page")
    public String pageQuery(@RequestParam(value="pageNum",required=true)int pageNum,@RequestParam(value="pageSize",required=true)int pageSize){
        Page<Teacher> pageQuery = this.teacherService.pageQuery( pageNum, pageSize,new Teacher());
        /*System.out.println("总记录数:" + page.getTotalElements());
        System.out.println("总页数:" + page.getTotalPages());
        System.out.println("当前页（request):" + page.getNumber());
        System.out.println("当前页总记录数（request):" + page.getSize());
        System.out.println("当前页记录总数：" + page.getNumberOfElements());*/
        /*List<Teacher> tes = page.getContent();
        for (Teacher t : tes) {
            System.out.println(t);
        }*/
        return JSON.toJSONString(pageQuery.getContent());
    }
    
    /**
     * page query,get request
     *
     * http://localhost:6874/teacher/queryByName?name=michale
     *
     * @return
     */
    @GetMapping("/queryByName")
    public String queryByName(@RequestParam(value="name",required=true)String name){
        Teacher teacher = this.teacherService.queryByName(name);
        return JSON.toJSONString(teacher);
    }
    
    /**
     * page query,get request
     *
     * http://localhost:6874/teacher/queryByPhone?phoneNum=185****6602
     *
     * @return
     */
    @GetMapping("/queryByPhone")
    public String queryByPhone(@RequestParam(value="phoneNum",required=true)String phoneNum){
        Teacher teacher = this.teacherService.queryByPhoneNum(phoneNum);
        return JSON.toJSONString(teacher);
    }
    
    /**
     * page query,get request
     *
     * http://localhost:6874/teacher/save?
     *
     * @return
     */
    @GetMapping("/save")
    public void save(@RequestParam(value="name",required=true)String name,@RequestParam(value="age",required=false,defaultValue="0")int age
            ,@RequestParam(value="sex",required=false,defaultValue="1")int sex,@RequestParam(value="email",required=false,defaultValue="")String email
            ,@RequestParam(value="phoneNum",required=false,defaultValue="")String phoneNum,@RequestParam(value="qqNum",required=false,defaultValue="")String qqNum
            ,@RequestParam(value="weChatNum",required=false,defaultValue="")String weChatNum,@RequestParam(value="address",required=false,defaultValue="")String address
            ,@RequestParam(value="idCard",required=false,defaultValue="")String idCard,@RequestParam(value="college",required=false,defaultValue="")String college
            ,@RequestParam(value="profession",required=false,defaultValue="")String profession,@RequestParam(value="otherImports",required=false,defaultValue="")String otherImports
            ,@RequestParam(value="certification",required=false,defaultValue="")String certification,@RequestParam(value="canTeacherGrade",required=false,defaultValue="")String canTeacherGrade
            ,@RequestParam(value="canTeacherSubject",required=false,defaultValue="")String canTeacherSubject,@RequestParam(value="canTeacherArea",required=false,defaultValue="")String canTeacherArea
            ,@RequestParam(value="teachExperience",required=false,defaultValue="")String teachExperience){
       this.teacherService.save(name,age,sex,email,phoneNum,qqNum,weChatNum,address
                ,idCard,college,profession,otherImports,certification,canTeacherGrade,canTeacherSubject,canTeacherArea,teachExperience);
    }
}
