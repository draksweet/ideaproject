package com.nj.userrole.controller;

import com.nj.pojo.UserRoleInfo;
import com.nj.userrole.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserRoleController {

    @Autowired
    UserRoleService userRoleService;

    /**
     * 增加角色分配
     * @param userRoleInfo
     * @return
     */
    @RequestMapping("insertUserRole")
    @ResponseBody
    public boolean insertUserRole(@RequestBody UserRoleInfo userRoleInfo){
        System.out.println(userRoleInfo);
//        if (userRoleInfo.getUrUserId() != null && userRoleInfo.getUrRoleId() != null) {
            userRoleService.insertUserRole(userRoleInfo);
            return true;
//        }
//        return false;
    }

    /**
     * 删除角色分配
     * @param userRoleInfo
     * @return
     */
    @RequestMapping("deleteUserRoleById")
    @ResponseBody
    public boolean deleteUserRoleById(@RequestBody UserRoleInfo userRoleInfo){
//        if (userRoleInfo.getUserRoleId() != null && userRoleInfo.getUrRoleId() != null) {
            Integer integer = userRoleService.selectUserRoleBy(userRoleInfo);
            if (1 >= integer){
                UserRoleInfo userRoleInfo1 = new UserRoleInfo();
                userRoleInfo1.setUrUserId(userRoleInfo.getUrUserId());
                userRoleInfo1.setUrRoleId(4);
                userRoleService.insertUserRole(userRoleInfo1);
                userRoleService.deleteUserRoleById(userRoleInfo);
                    return true;
            }else{
                userRoleService.deleteUserRoleById(userRoleInfo);
                return true;
            }
//        }
//        return false;
    }
}
