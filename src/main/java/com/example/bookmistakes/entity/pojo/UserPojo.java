package com.example.bookmistakes.entity.pojo;
import java.io.Serializable;

import java.util.Date;
import lombok.Data;

/**
* 
* @TableName user
*/
@Data
public class UserPojo implements Serializable {

    private Integer id;

    private String userId;

    private String userName;

    private String password;

    private String email;

    private Integer isDel;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    private String avatarUrl;

    private int postsCount;

    private int followersCount;

    private int followingCount;

}
