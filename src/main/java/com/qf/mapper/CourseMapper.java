package com.qf.mapper;

import com.qf.pojo.Course;

import java.util.List;

public interface CourseMapper {
    public List<Course>getCourseCK(Course course);
    public void addCourseTJ(Course course);
    public void updateCourseXG(Course course);
    public void deleteCourseSC(Course course);
}
