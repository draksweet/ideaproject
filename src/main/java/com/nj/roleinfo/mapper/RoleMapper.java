package com.nj.roleinfo.mapper;

import com.nj.pojo.RoleInfo;

import java.util.List;

public interface RoleMapper {
    public void insertRoleSelective(RoleInfo roleInfo);
    public void deleteRoleById(RoleInfo roleInfo);
    public void updateRoleByIdSelective(RoleInfo roleInfo);
    public List<RoleInfo> selectRoleAll();
    public List<RoleInfo> selectRoleSelective(RoleInfo roleInfo);
    public List<RoleInfo> selectRoleByFuzzy(RoleInfo roleInfo);
    public List<RoleInfo> selectUDRole(RoleInfo roleInfo);
    public List<RoleInfo> selectDRole(RoleInfo roleInfo);
}
