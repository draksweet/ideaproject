package com.nj.userrole.service.impl;

import com.nj.pojo.UserRoleInfo;
import com.nj.userrole.mapper.UserRoleMapper;
import com.nj.userrole.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    public void insertUserRole(UserRoleInfo userRoleInfo) {
//        System.out.println("impl-==="+userRoleInfo);
        userRoleMapper.insertUserRole(userRoleInfo);
    }

    @Override
    public void deleteUserRoleById(UserRoleInfo userRoleInfo) {
        userRoleMapper.deleteUserRoleById(userRoleInfo);
    }

    @Override
    public Integer selectUserRoleBy(UserRoleInfo userRoleInfo) {
        Integer integer = userRoleMapper.selectUserRoleBy(userRoleInfo);
        return integer;
    }
}
