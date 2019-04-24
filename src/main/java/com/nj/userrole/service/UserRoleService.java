package com.nj.userrole.service;

import com.nj.pojo.UserRoleInfo;

public interface UserRoleService {
    public void insertUserRole(UserRoleInfo userRoleInfo);
    public void deleteUserRoleById(UserRoleInfo userRoleInfo);
    public Integer selectUserRoleBy(UserRoleInfo userRoleInfo);

}
