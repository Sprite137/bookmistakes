package com.example.bookmistakes.mapper;

import com.example.bookmistakes.entity.pojo.BookPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
     List<BookPojo> getBookByTitle(String title);
}
