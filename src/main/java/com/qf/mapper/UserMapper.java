package com.qf.mapper;

import com.qf.pojo.User;

import java.util.List;

public interface UserMapper {
    public List<User> getUserCK(User user);
    public void addUserTJ(User user);
    public void updateUserXG(User user);
    public void deleteUserSC(User user);
    public List<User> getUserMHCK(String string);

    public int updateUser(User user);
}
