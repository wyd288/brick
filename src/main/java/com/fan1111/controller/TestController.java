package com.fan1111.controller;


import com.fan1111.entity.User;
import com.fan1111.service.user.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {

    @Resource
    private UserService userService;


    //测试访问接口
    @RequestMapping(value="getusers",method= RequestMethod.GET)
    @ResponseBody
    public List<User>  getUsers(){
        List<User> ulist = userService.getUserList(null,null);
        return ulist;
    }
}
