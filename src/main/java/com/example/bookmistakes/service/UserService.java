package com.example.bookmistakes.service;

import com.example.bookmistakes.entity.errorEntiy.ResponseResult;
import com.example.bookmistakes.entity.vo.LoginUserVo;
import com.example.bookmistakes.entity.vo.RegisterUserVo;

public interface UserService {
    public ResponseResult<Object> login(LoginUserVo loginUser);

    public ResponseResult<Object> register(RegisterUserVo registerUserVo);
}
