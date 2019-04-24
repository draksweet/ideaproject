package com.nj.userinfo.controller;

import com.nj.pojo.UserInfo;
import com.nj.userinfo.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestIUserController {
    @Test
    public void selectAll(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-service.xml", "spring-mybatis.xml");
        UserService bean = context.getBean(UserService.class);
        List<UserInfo> userInfos = bean.selectUserAll();
        System.out.println(userInfos);
    }
    @Test
    public void insertSelective(){
        UserInfo userInfo = new UserInfo();
        userInfo.setAccountName("tangsanzang");
        userInfo.setUserName("唐三藏");
        userInfo.setPassword("123456");
        userInfo.setEmail("tangsanzang@nj.com");
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-service.xml", "spring-mybatis.xml");
        UserService bean = context.getBean(UserService.class);
        bean.insertUserSelective(userInfo);
    }
    @Test
    public void selectByIdSelective(){
        UserInfo userInfo = new UserInfo();
//        userInfo.setAccountName("nezha");
//        userInfo.setUserName("哪吒");
//        userInfo.setPassword("123456");
//        userInfo.setEmail("nezha@nj.com");
        userInfo.setUserId(3);
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-service.xml", "spring-mybatis.xml");
        UserService bean = context.getBean(UserService.class);
        List<UserInfo> userInfos = bean.selectUserSelective(userInfo);
        System.out.println(userInfos);
    }
    @Test
    public void updateByIdSelective(){
        UserInfo userInfo = new UserInfo();
        userInfo.setAccountName("linezha");
        userInfo.setUserId(4);
        userInfo.setUserName("李哪吒");
        userInfo.setPassword("123789");
        userInfo.setEmail("linezha@nj.com");
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-service.xml", "spring-mybatis.xml");
        UserService bean = context.getBean(UserService.class);
        bean.updateUserByIdSelective(userInfo);
        List<UserInfo> userInfos = bean.selectUserSelective(userInfo);
        System.out.println(userInfos);
    }
    @Test
    public void deleteById(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(13);
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-service.xml", "spring-mybatis.xml");
        UserService bean = context.getBean(UserService.class);
        bean.deleteUserById(userInfo);
//        List<UserInfo> userInfos = bean.selectAll();
        System.out.println("success");

    }
//    模糊查询
    @Test
    public void selectByfuzzy(){
        UserInfo userInfo = new UserInfo();
        userInfo.setAccountName("哪");
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-service.xml", "spring-mybatis.xml");
        UserService bean = context.getBean(UserService.class);
        List<UserInfo> userInfos = bean.selectUserByFuzzy(userInfo);
        System.out.println(userInfos);

    }
}
