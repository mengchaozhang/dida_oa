package com.qf.service;

import com.qf.pojo.Classes;
import com.qf.pojo.User;

import java.util.List;

public interface PageInfoManagerService {
    List<Classes> getClassesListByUid(User user);

    List<Classes> getClassesList();
}
