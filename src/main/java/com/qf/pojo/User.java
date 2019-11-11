package com.qf.pojo;

public class User {
    private int uid;
    private String username;
    private String password;
    private String rolename;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public User(int uid, String username, String password, String rolename) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.rolename = rolename;
    }

    public User(String username, String password, String rolename) {
        this.username = username;
        this.password = password;
        this.rolename = rolename;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", rolename='" + rolename + '\'' +
                '}';
    }
}