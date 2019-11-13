package com.qf.service.impl;

import com.qf.mapper.CourseMapper;
import com.qf.pojo.Course;
import com.qf.service.SuperAdmin_CourseService;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SuperAdmin_CourseService_impl implements SuperAdmin_CourseService {
@Autowired
private CourseMapper courseMapper;

    public CourseMapper getCourseMapper() {
        return courseMapper;
    }

    public void setCourseMapper(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    @Override
    public List<Course> KCCK(Course course) {
        List<Course> list = courseMapper.getCourseCK(course);
        return list;
    }

    @Override
    public void KCTJ(Course course) {
        courseMapper.addCourseTJ(course);
    }

    @Override
    public void KCXG(Course course) {
        courseMapper.updateCourseXG(course);
    }

    @Override
    public void KCSC(Course course) {
        courseMapper.deleteCourseSC(course);
    }
}
