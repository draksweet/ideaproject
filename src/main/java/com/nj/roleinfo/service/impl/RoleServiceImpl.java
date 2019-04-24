package com.nj.roleinfo.service.impl;

import com.nj.pojo.RoleInfo;
import com.nj.roleinfo.service.RoleService;
import com.nj.roleinfo.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public void insertRoleSelective(RoleInfo roleInfo) {
        roleMapper.insertRoleSelective(roleInfo);
    }

    @Override
    public void deleteRoleById(RoleInfo roleInfo) {
        roleMapper.deleteRoleById(roleInfo);
    }

    @Override
    public void updateRoleByIdSelective(RoleInfo roleInfo) {
        roleMapper.updateRoleByIdSelective(roleInfo);
    }

    @Override
    public List<RoleInfo> selectRoleAll() {
        List<RoleInfo> roleInfos = roleMapper.selectRoleAll();
        return roleInfos;
    }

    @Override
    public List<RoleInfo> selectRoleSelective(RoleInfo roleInfo) {
        List<RoleInfo> roleInfos = roleMapper.selectRoleSelective(roleInfo);
        return roleInfos;
    }

    //    判断库中是否有数据
    public boolean checkRole(RoleInfo roleInfo){
        List<RoleInfo> roleInfos = roleMapper.selectRoleSelective(roleInfo);
        if (roleInfos != null){
            return true;
        }
        return  false;
    }

    @Override
    public List<RoleInfo> selectRoleByFuzzy(RoleInfo roleInfo) {
        List<RoleInfo> roleInfos = roleMapper.selectRoleByFuzzy(roleInfo);
        return roleInfos;
    }

    @Override
    public List<RoleInfo> selectUDRole(RoleInfo roleInfo) {
        List<RoleInfo> roleInfos = roleMapper.selectUDRole(roleInfo);
        return roleInfos;
    }
    public List<RoleInfo> selectDRole(RoleInfo roleInfo) {
        List<RoleInfo> roleInfos = roleMapper.selectDRole(roleInfo);
        return roleInfos;
    }
}
