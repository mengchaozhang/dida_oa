package com.qf.pojo;

import com.qf.mapper.ClassesMapper;
import com.qf.mapper.CourseMapper;
import com.qf.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class ClassesTest {
    @Autowired
    private ClassesMapper classesMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private EmployeeMapper employeeMapper;

    public ClassesMapper getClassesMapper() {
        return classesMapper;
    }

    public void setClassesMapper(ClassesMapper classesMapper) {
        this.classesMapper = classesMapper;
    }

    public CourseMapper getCourseMapper() {
        return courseMapper;
    }

    public void setCourseMapper(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    public EmployeeMapper getEmployeeMapper() {
        return employeeMapper;
    }

    public void setEmployeeMapper(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Test
    public void ce1(){
        Employee teacher =new Employee();
        teacher.setEid(1);
        Employee headmaster =new Employee();
        Course course =new Course();
        headmaster.setEid(2);
        course.setCourseId(1);

        Classes c = new Classes();
        Classes c1 = new Classes();
        Classes c2 = new Classes();
        c2.setCid(2);
        c.setCname("yubo");
        c.setStage("18");
        c.setCourse(course);
        c.setHeadmaster(headmaster);
        c.setTeacher(teacher);
        System.out.println(c.toString());
        System.out.println(c2);
        classesMapper.deleteClassesSC(c2);
        //classesMapper.updateClassesXG(c);
      //  classesMapper.addCLassesTJ(c);
       // List<Classes>list = classesMapper.getClassesCK(c1);
        //System.out.println(list.size());
    }


}