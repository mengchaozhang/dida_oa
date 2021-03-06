package com.qf.service;

import com.qf.pojo.User;

public interface GetRoleService {

    public String getPasswordByUsername(String username);

    public User getUserByUsername(String username);

    String getEnameByUid(int uid);

    String getSnameByUid(int uid);
}
