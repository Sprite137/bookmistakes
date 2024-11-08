package com.example.bookmistakes.controller;

import com.example.bookmistakes.annotationLog.SystemLog;
import com.example.bookmistakes.entity.dto.LoginUserDto;
import com.example.bookmistakes.entity.dto.RegisterUserDto;
import com.example.bookmistakes.entity.errorEntiy.ResponseResult;
import com.example.bookmistakes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @SystemLog(logName = "login")
    public ResponseResult<Object> login(@RequestBody LoginUserDto loginUserDto){
        return userService.login(loginUserDto);
    }

    @PostMapping("/register")
    public ResponseResult<Object> register(@RequestBody RegisterUserDto registerUserDto){
        return userService.register(registerUserDto);
    }

    @GetMapping("/info")
    public ResponseResult<Object> userDetail(@RequestParam String userName){
        return userService.getUserDetail(userName);
    }
}
