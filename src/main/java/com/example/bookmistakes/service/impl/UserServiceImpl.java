package com.example.bookmistakes.service.impl;

import com.example.bookmistakes.entity.dto.LoginUserDto;
import com.example.bookmistakes.entity.dto.RegisterUserDto;
import com.example.bookmistakes.entity.errorEntiy.HttpEnum;
import com.example.bookmistakes.entity.errorEntiy.ResponseResult;
import com.example.bookmistakes.entity.pojo.UserPojo;
import com.example.bookmistakes.entity.vo.UserDetailVo;
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

    public ResponseResult<Object> login(LoginUserDto loginUserDto){
        UserPojo user = userMapper.getUserByUserName(loginUserDto.getUserName());
        if(user == null){
            return ResponseResult.ErrorResult(HttpEnum.LOGINERROR);
        }
        if(BCrypt.checkpw(loginUserDto.getPassword(),user.getPassword())){

            return ResponseResult.SuccessResult();
        }
        else {
            return ResponseResult.ErrorResult(HttpEnum.LOGINERROR);
        }

    }

    public ResponseResult<Object> register(RegisterUserDto registerUserDto){
        UserPojo registerUser = new UserPojo();
        BeanUtils.copyProperties(registerUserDto,registerUser);
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

    @Override
    public ResponseResult<Object> getUserDetail(String userName) {
        UserDetailVo userDetailVo = new UserDetailVo();
        userDetailVo.setUserName(userName);
        // 获取关注与粉丝数量
        UserPojo userPojo = userMapper.getUserByUserName(userName);
        BeanUtils.copyProperties(userPojo,userDetailVo);

        return  ResponseResult.SuccessResult(userDetailVo);
    }
}
