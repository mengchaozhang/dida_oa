package com.qf.util;

import com.qf.mapper.ClassesMapper;
import com.qf.pojo.Classes;
import org.springframework.beans.factory.annotation.Autowired;

public class test {
    @Autowired
    private static ClassesMapper classesMapper;


    public static void main(String[] args) {
        Classes classes = new Classes();
        classes.setCid(2);
        classesMapper.deleteClassesSC(classes);

    }
}
