package com.example.bookmistakes.controller;

import com.example.bookmistakes.annotationLog.SystemLog;
import com.example.bookmistakes.entity.errorEntiy.ResponseResult;
import com.example.bookmistakes.entity.vo.LoginUserVo;
import com.example.bookmistakes.entity.vo.RegisterUserVo;
import com.example.bookmistakes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @SystemLog(logName = "login")
    public ResponseResult<Object> login(@RequestBody LoginUserVo loginUser){
        return userService.login(loginUser);
    }

    @PostMapping("/register")
    public ResponseResult<Object> register(@RequestBody RegisterUserVo registerUserVo){
        return userService.register(registerUserVo);
    }
}
