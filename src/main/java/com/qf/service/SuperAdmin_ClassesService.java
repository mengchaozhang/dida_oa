package com.qf.service;

import com.qf.pojo.Classes;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface SuperAdmin_ClassesService {
    public List<Classes> BJCK(Classes classes);
    public void BJTJ(Classes classes);
    public void BJXG(Classes classes);
    public void BJSC(Classes classes);

}
