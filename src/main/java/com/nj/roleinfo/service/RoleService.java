package com.nj.roleinfo.service;

import com.nj.pojo.RoleInfo;

import java.util.List;

public interface RoleService {
    public void insertRoleSelective(RoleInfo roleInfo);
    public void deleteRoleById(RoleInfo roleInfo);
    public void updateRoleByIdSelective(RoleInfo roleInfo);
    public List<RoleInfo> selectRoleAll();
    public List<RoleInfo> selectRoleSelective(RoleInfo roleInfo);
    public boolean checkRole(RoleInfo roleInfo);
    public List<RoleInfo> selectRoleByFuzzy(RoleInfo roleInfo);
    public List<RoleInfo> selectUDRole(RoleInfo roleInfo);
    public List<RoleInfo> selectDRole(RoleInfo roleInfo);
}
