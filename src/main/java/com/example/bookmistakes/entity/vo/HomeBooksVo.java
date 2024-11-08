package com.example.bookmistakes.entity.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author sprite-pc
 * @description:
 * @date 2024/10/18 20:48
 */
@Data
public class HomeBooksVo {
    private String title;

    private float rate;

    private String bookId;

    private String author;

    private String imgSrc;

    private String publishingHouse;

    private String publishingTime;
}
