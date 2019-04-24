package com.nj.userinfo.service.impl;

import com.nj.pojo.UserInfo;
import com.nj.userinfo.mapper.UserMapper;
import com.nj.userinfo.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public void insertUserSelective(UserInfo userInfo) {
        userMapper.insertUserSelective(userInfo);
    }

    @Override
    public void deleteUserById(UserInfo userInfo) {
        userMapper.deleteUserById(userInfo);
    }

    @Override
    public void updateUserByIdSelective(UserInfo userInfo) {
        userMapper.updateUserByIdSelective(userInfo);
    }

    @Override
    public List<UserInfo> selectUserAll() {
        List<UserInfo> userInfos = userMapper.selectUserAll();
        return userInfos;
    }

    @Override
    public List<UserInfo> selectUserSelective(UserInfo userInfo) {
        List<UserInfo> userInfos = userMapper.selectUserSelective(userInfo);
        return userInfos;
    }

//    判断库中是否有数据
    public boolean checkUser(UserInfo userInfo){
        List<UserInfo> userInfos = userMapper.selectUserSelective(userInfo);
        if (userInfos != null){
            return true;
        }
        return  false;
    }

    @Override
    public List<UserInfo> selectUserByFuzzy(UserInfo userInfo) {
        List<UserInfo> userInfos = userMapper.selectUserByFuzzy(userInfo);
        return userInfos;
    }
}
