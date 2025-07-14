package org.example.controller;

import org.example.pojo.User;
import org.example.service.UserService;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: xuxiaolei
 * @Description: TODO: UserController
 * @CreatTime: 2025/07/14 10:52
 **/
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("login")
    public Result login(@RequestBody User user){

        Result result = userService.login(user);

        return result;
    }

    @GetMapping("getUserInfo")
    public Result getUserInfo(@RequestHeader String token){

        Result result = userService.getUserInfo(token);

        return result;

    }

    @PostMapping("checkUserName")
    public Result checkUserName(String username){

       Result result = userService.checkUserName(username);
       return result;
    }
}
