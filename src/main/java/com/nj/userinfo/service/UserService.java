package com.nj.userinfo.service;

import com.nj.pojo.UserInfo;

import java.util.List;

public interface UserService {
    public void insertUserSelective(UserInfo userInfo);
    public void deleteUserById(UserInfo userInfo);
    public void updateUserByIdSelective(UserInfo userInfo);
    public List<UserInfo> selectUserAll();
    public List<UserInfo> selectUserSelective(UserInfo userInfo);
    public boolean checkUser(UserInfo userInfo);
    public List<UserInfo> selectUserByFuzzy(UserInfo userInfo);


}
