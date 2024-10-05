package com.example.bookmistakes.mapper;

import com.example.bookmistakes.entity.pojo.UserPojo;
import com.example.bookmistakes.entity.vo.RegisterUserVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    UserPojo getUserByUserName(String userName);

    void insertUser(UserPojo userPojo);
}
