package org.example.controller;

import org.example.pojo.User;
import org.example.service.UserService;
import org.example.utils.JwtHelper;
import org.example.utils.Result;
import org.example.utils.ResultCodeEnum;
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

    @Autowired
    private JwtHelper jwtHelper;

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
    @PostMapping("regist")
    public Result regist(@RequestBody User user){
        Result result = userService.regist(user);
        return result;
    }
    //用户登录检查
    @GetMapping("checkLogin")
    public Result checklogin(@RequestHeader String token){

        boolean expiration = jwtHelper.isExpiration(token);

        if(expiration){
            //登录过期
            return Result.build(null, ResultCodeEnum.NOTLOGIN);
        }
        return Result.ok(null);
    }
}
