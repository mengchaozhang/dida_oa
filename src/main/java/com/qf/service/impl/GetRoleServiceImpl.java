package com.qf.service.impl;

import com.qf.mapper.RoleMapper;
import com.qf.pojo.User;
import com.qf.service.GetRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetRoleServiceImpl implements GetRoleService {

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public String getPasswordByUsername(String username) {
        return roleMapper.getPasswordByUsername(username);
    }

    @Override
    public User getUserByUsername(String username) {
        return roleMapper.getUserByUsername(username);
    }
}
