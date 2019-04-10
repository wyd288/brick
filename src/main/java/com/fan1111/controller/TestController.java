package com.fan1111.controller;


import com.fan1111.entity.User;
import com.fan1111.service.user.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @Resource
    private UserService userService;


    //测试访问接口
    @RequestMapping(value="getlist",method= RequestMethod.GET)
    @ResponseBody
    public List<User>  getUsers(HttpServletResponse res){
        List<User> ulist = new ArrayList<>();
        ulist = userService.getUserList(null,null);
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Method", "POST,GET");
        res.setContentType("application/json;charset=utf-8");
        return ulist;
    }
}
