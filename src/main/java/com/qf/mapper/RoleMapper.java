package com.qf.mapper;

import com.qf.pojo.Role;
import com.qf.pojo.User;

import java.util.List;

public interface RoleMapper {

    public String getPasswordByUsername(String username);

    public User getUserByUsername(String username);

    public String getRolenameByUsername(String username);



    public List<Role> getRoleCK(Role role);
    public void addRoleTJ(Role role);
    public void updateRoleXG(Role role);
    public void deleteRoleSC(Role role);

}
