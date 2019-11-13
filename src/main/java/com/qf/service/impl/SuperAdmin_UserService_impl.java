package com.qf.service.impl;

import com.qf.mapper.UserMapper;
import com.qf.pojo.User;
import com.qf.service.SuperAdmin_UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SuperAdmin_UserService_impl implements SuperAdmin_UserService {
 @Autowired
 private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> UCK(User user) {
        List<User>list = userMapper.getUserCK(user);
        return list;
    }

    @Override
    public void UTJ(User user) {
        userMapper.addUserTJ(user);
    }

    @Override
    public void UXG(User user) {
userMapper.updateUserXG(user);
    }

    @Override
    public void USC(User user) {
userMapper.deleteUserSC(user);
    }

    @Override
    public List<User> UMHCK(String string) {
       List<User> list = userMapper.getUserMHCK(string);
        return list;
    }
}
