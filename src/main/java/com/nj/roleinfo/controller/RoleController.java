package com.nj.roleinfo.controller;

import com.nj.pojo.RoleInfo;
import com.nj.roleinfo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RoleController {
    @Autowired
    RoleService roleService;

    /**
     * 添加角色
     * @param roleInfo
     * @return
     */
    @RequestMapping("insertRoleSelective")
    @ResponseBody
    public boolean insertRoleSelective(@RequestBody RoleInfo roleInfo){
        if(roleInfo!=null) {
            roleService.insertRoleSelective(roleInfo);
//            System.out.println(roleInfo);
            boolean b = roleService.checkRole(roleInfo);
            if (b == true){   //添加后判断数据库中是否存在该值
                return true;
            }
        }
        return false;
    }

    /**
     * 删除角色
     * @param roleInfo
     * @return
     */
    @RequestMapping("deleteRoleById")
    @ResponseBody
    public boolean deleteRoleById(@RequestBody RoleInfo roleInfo){
//        if(roleInfo!=null) {      //判断需要删除的值是否为空
////            System.out.println(roleInfo);
        boolean checkRole = roleService.checkRole(roleInfo);
        if (checkRole) {      //判断数据库中是否有需要删除的值
            roleService.deleteRoleById(roleInfo);
//                boolean b = roleService.checkRole(roleInfo);
//                System.out.println(b);
//                if (!b){   //判断删除后数据库中是否还存在该值
            return true;
//                }
        }
//        }
        return false;
    }

    /**
     * 修改角色
     * @param roleInfo
     * @return
     */
    @RequestMapping("updateRoleByIdSelective")
    @ResponseBody
    public boolean updateRoleByIdSelective(@RequestBody RoleInfo roleInfo){
//        if(roleInfo!=null) {      //判断需要删除的值是否为空
//            System.out.println(roleInfo);
        roleService.updateRoleByIdSelective(roleInfo);
//            boolean b = roleService.checkRole(roleInfo);
//            if (b == true){   //修改后判断数据库中是否存在该值
//                return true;
//            }
//        }
        return true;
    }

    /**
     * 查找所有角色
     * @return
     */
    @RequestMapping("selectRoleAll")
    @ResponseBody
    public List<RoleInfo> selectRoleAll(){
        List<RoleInfo> roleInfos = roleService.selectRoleAll();
        return roleInfos;
    }

    /**
     * 选择性查找角色
     * @return
     */
    @RequestMapping("selectRoleSelective")
    @ResponseBody
    public List<RoleInfo> selectRoleSelective(@RequestBody RoleInfo roleInfo){
        List<RoleInfo> roleInfos = roleService.selectRoleSelective(roleInfo);
        return roleInfos;
    }

    /**
     * 根据roleName模糊查询
     * @param roleInfo
     * @return
     */
    @RequestMapping("selectRoleByFuzzy")
    @ResponseBody
    public List<RoleInfo> selectRoleByFuzzy(@RequestBody RoleInfo roleInfo){
        List<RoleInfo> roleInfos = roleService.selectRoleByFuzzy(roleInfo);
//        System.out.println(roleInfos);
        return roleInfos;
    }

    /**
     * 未分配角色
     * @param roleInfo
     * @return
     */
    @RequestMapping("selectUDRole")
    @ResponseBody
    public List<RoleInfo> selectUDRole(@RequestBody RoleInfo roleInfo){
        List<RoleInfo>roleInfos = roleService.selectUDRole(roleInfo);
        return roleInfos;
    }
    /**
     * 已分配角色
     * @param roleInfo
     * @return
     */
    @RequestMapping("selectDRole")
    @ResponseBody
    public List<RoleInfo> selectDRole(@RequestBody RoleInfo roleInfo){
        List<RoleInfo>roleInfos = roleService.selectDRole(roleInfo);
        return roleInfos;
    }
}
