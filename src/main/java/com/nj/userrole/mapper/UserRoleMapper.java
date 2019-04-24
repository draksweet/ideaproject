package com.nj.userrole.mapper;

import com.nj.pojo.UserRoleInfo;

public interface UserRoleMapper {
    public void insertUserRole(UserRoleInfo userRoleInfo);
    public void deleteUserRoleById(UserRoleInfo userRoleInfo);
    public Integer selectUserRoleBy(UserRoleInfo userRoleInfo);
}
