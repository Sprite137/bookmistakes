package com.example.bookmistakes.service.impl;

import com.example.bookmistakes.entity.errorEntiy.HttpEnum;
import com.example.bookmistakes.entity.errorEntiy.ResponseResult;
import com.example.bookmistakes.entity.pojo.UserPojo;
import com.example.bookmistakes.entity.vo.LoginUserVo;
import com.example.bookmistakes.entity.vo.RegisterUserVo;
import com.example.bookmistakes.event.LoginEvent;
import com.example.bookmistakes.mapper.UserMapper;
import com.example.bookmistakes.service.UserService;
import com.example.bookmistakes.util.BcryptUtil;

import com.example.bookmistakes.util.UUIDUtil;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;



    @Autowired
    private ApplicationContext applicationContext;

    public ResponseResult<Object> login(LoginUserVo loginUserVo){
//        LoginEvent loginEvent = new LoginEvent(applicationContext,loginUserVo.getUserName());
//        applicationContext.publishEvent(loginEvent);
        UserPojo user = userMapper.getUserByUserName(loginUserVo.getUserName());
        if(user == null){
            return ResponseResult.ErrorResult(HttpEnum.LOGINERROR);
        }
        if(BCrypt.checkpw(loginUserVo.getPassword(),user.getPassword())){

            return ResponseResult.SuccessResult();
        }
        else {
            return ResponseResult.ErrorResult(HttpEnum.LOGINERROR);
        }

    }

    public ResponseResult<Object> register(RegisterUserVo registerUserVo){
        UserPojo registerUser = new UserPojo();
        BeanUtils.copyProperties(registerUserVo,registerUser);
        registerUser.setUserId(UUIDUtil.get8UUID());
        registerUser.setPassword(BcryptUtil.encoding(registerUser.getPassword()));
        registerUser.setCreateTime(new Date());
        registerUser.setUpdateTime(new Date());
        registerUser.setCreateBy(registerUser.getUserName());
        registerUser.setUpdateBy(registerUser.getUserName());
        registerUser.setIsDel(0);
        userMapper.insertUser(registerUser);
        return ResponseResult.SuccessResult();
    }
}
