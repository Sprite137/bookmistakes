package com.example.bookmistakes.entity.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author sprite-pc
 * @description:
 * @date 2024/11/8 12:15
 */
@Data
public class BookDetailVo {
    private String title;

    private String author;

    private String tag;

    private String bookId;

    private float rate;

    private int viewCount;

    private String publishingTime;

    private String publishingHouse;

    private String imgSrc;

    private String intro;
}
