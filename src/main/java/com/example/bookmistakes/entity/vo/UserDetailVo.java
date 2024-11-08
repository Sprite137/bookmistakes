package com.example.bookmistakes.entity.vo;

import lombok.Data;

/**
 * @author sprite-pc
 * @description:
 * @date 2024/10/27 16:02
 */
@Data
public class UserDetailVo {
    String userName;

    String avatarUrl;

    int postsCount;

    private String bookId;

    int followersCount;

    int followingCount;

    String email;


}
