package com.example.bookmistakes.entity.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class BookPojo {
    private int id;

    private String title;

    private String author;

    private String tag;

    private String bookId;

    private float rate;

    private int isDel;

    private Date createTime;

    private Date updateTime;

    private String createBy;

    private String updateBy;


//    id int auto_increment primary key,
//    title varchar(20),
//    book_id varchar(10) unique ,
//    author varchar(20) not null ,
//    tag varchar(10),
//    rate decimal,
//    is_del boolean,
//    create_time DATETIME not null ,
//    create_by varchar(20) not null ,
//    update_time DATETIME not null ,
//    update_by varchar(20) not null

}
