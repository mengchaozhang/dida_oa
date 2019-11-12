package com.qf.mapper;

import com.qf.pojo.Classes;

import java.util.List;

public interface ClassesMapper {
    public Classes getClassesByCname(String cname);
    public List<Classes> getClassesCK(Classes classes);
    public void addCLassesTJ(Classes classes);
    public void updateClassesXG(Classes classes);
    public void deleteClassesSC(Classes classes);;
}
