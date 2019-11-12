package com.qf.mapper;

import com.qf.pojo.Student;

import java.util.List;

public interface StudentMapper {

    public List<Student> getStudentListBycid(int cid);

    public Student getStudentByUid(int uid);
}
