package com.qf.service.impl;

import com.qf.mapper.ClassesMapper;
import com.qf.pojo.Classes;
import com.qf.service.SuperAdmin_ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SuperAdmin_ClassesService_impl implements SuperAdmin_ClassesService {
    @Autowired
    private ClassesMapper classesMapper;

    public ClassesMapper getClassesMapper() {
        return classesMapper;
    }

    public void setClassesMapper(ClassesMapper classesMapper) {
        this.classesMapper = classesMapper;
    }

    @Override
    public List<Classes> BJCK(Classes classes) {
        List<Classes> list= classesMapper. getClassesCK(classes);
        return list;
    }

    @Override
    public void BJTJ(Classes classes) {
        classesMapper.addCLassesTJ(classes);
    }

    @Override
    public void BJXG(Classes classes) {
        classesMapper.updateClassesXG(classes);
    }

    @Override
    public void BJSC(Classes classes) {
        classesMapper.deleteClassesSC(classes);
    }
}
