package com.example.bookmistakes.service;

import com.example.bookmistakes.entity.dto.LoginUserDto;
import com.example.bookmistakes.entity.dto.RegisterUserDto;
import com.example.bookmistakes.entity.errorEntiy.ResponseResult;

public interface UserService {
    public ResponseResult<Object> login(LoginUserDto loginUserDto);

    public ResponseResult<Object> register(RegisterUserDto registerUserDto);

    public ResponseResult<Object> getUserDetail(String userName);
}
