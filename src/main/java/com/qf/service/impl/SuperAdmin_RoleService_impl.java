package com.qf.service.impl;

import com.qf.mapper.RoleMapper;
import com.qf.pojo.Role;
import com.qf.service.SuperAdmin_RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SuperAdmin_RoleService_impl implements SuperAdmin_RoleService {
@Autowired
private RoleMapper roleMapper;

    public RoleMapper getRoleMapper() {
        return roleMapper;
    }

    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public List<Role> RCK(Role role) {
       List<Role>list = roleMapper.getRoleCK(role);

        return list;
    }

    @Override
    public void RTJ(Role role) {
roleMapper.addRoleTJ(role);
    }

    @Override
    public void RXG(Role role) {
roleMapper.updateRoleXG(role);
    }

    @Override
    public void RSC(Role role) {
roleMapper.deleteRoleSC(role);
    }
}
