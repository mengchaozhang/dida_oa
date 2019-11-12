package com.qf.mapper;

import com.qf.pojo.Role;

import java.util.List;

public interface RoleMapper {
    public List<Role> getRoleCK(Role role);
    public void addRoleTJ(Role role);
    public void updateRoleXG(Role role);
    public void deleteRoleSC(Role role);;

}
