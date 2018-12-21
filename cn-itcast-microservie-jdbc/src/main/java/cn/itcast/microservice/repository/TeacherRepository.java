package cn.itcast.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cn.itcast.microservice.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long>
{

    @Query(value="select * from teacher_tb where name = ?1",nativeQuery=true)
    Teacher findByName(String name);

    @Query(value="select * from teacher_tb where phone_num = ?1",nativeQuery=true)
    Teacher findByPhone(String phoneNum);
    

}
