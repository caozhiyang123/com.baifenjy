package cn.itcast.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.itcast.microservice.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher,Long>
{
    

}
