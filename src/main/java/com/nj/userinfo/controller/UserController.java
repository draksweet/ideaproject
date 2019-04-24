package com.nj.userinfo.controller;

import com.nj.pojo.UserInfo;
import com.nj.userinfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 添加用户
     * @param userInfo
     * @return
     */
    @RequestMapping("insertUserSelective")
    @ResponseBody
    public boolean insertUserSelective(@RequestBody UserInfo userInfo){
        if(userInfo!=null) {
            userService.insertUserSelective(userInfo);
//            System.out.println(userInfo);
            boolean b = userService.checkUser(userInfo);
            if (b == true){   //添加后判断数据库中是否存在该值
                return true;
            }
        }
        return false;
    }

    /**
     * 删除用户
     * @param userInfo
     * @return
     */
    @RequestMapping("deleteUserById")
    @ResponseBody
    public boolean deleteUserById(@RequestBody UserInfo userInfo){
//        if(userInfo!=null) {      //判断需要删除的值是否为空
////            System.out.println(userInfo);
            boolean checkUser = userService.checkUser(userInfo);
            if (checkUser) {      //判断数据库中是否有需要删除的值
                userService.deleteUserById(userInfo);
//                boolean b = userService.checkUser(userInfo);
//                System.out.println(b);
//                if (!b){   //判断删除后数据库中是否还存在该值
                    return true;
//                }
            }
//        }
        return false;
    }

    /**
     * 修改用户
     * @param userInfo
     * @return
     */
    @RequestMapping("updateUserByIdSelective")
    @ResponseBody
    public boolean updateUserByIdSelective(@RequestBody UserInfo userInfo){
//        if(userInfo!=null) {      //判断需要删除的值是否为空
//            System.out.println(userInfo);
            userService.updateUserByIdSelective(userInfo);
//            boolean b = userService.checkUser(userInfo);
//            if (b == true){   //修改后判断数据库中是否存在该值
//                return true;
//            }
//        }
        return true;
    }

    /**
     * 查找所有用户
     * @return
     */
    @RequestMapping("selectUserAll")
    @ResponseBody
    public List<UserInfo> selectUserAll(){
        List<UserInfo> userInfos = userService.selectUserAll();
        return userInfos;
    }

    /**
     * 选择性查找用户
     * @return
     */
    @RequestMapping("selectUserSelective")
    @ResponseBody
    public List<UserInfo> selectUserSelective(@RequestBody UserInfo userInfo){
        List<UserInfo> userInfos = userService.selectUserSelective(userInfo);
        return userInfos;
    }

    /**
     * 登录验证是否存在用户
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping("checkUser")
    @ResponseBody
    public boolean checkUser(@RequestParam String userName,@RequestParam String password){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userName);
        userInfo.setPassword(password);
        boolean b = userService.checkUser(userInfo);
        if (b){
            return true;
        }
        return false;
    }

    /**
     * 根据accountName模糊查询
     * @param userInfo
     * @return
     */
    @RequestMapping("selectUserByFuzzy")
    @ResponseBody
    public List<UserInfo> selectUserByFuzzy(@RequestBody UserInfo userInfo){
        List<UserInfo> userInfos = userService.selectUserByFuzzy(userInfo);
//        System.out.println(userInfos);
        return userInfos;
    }
}
