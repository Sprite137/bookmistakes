package com.example.bookmistakes.mapper;

import com.example.bookmistakes.entity.pojo.BookPojo;
import com.example.bookmistakes.entity.vo.BookDetailVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
     List<BookPojo> getBookByTitle(String title);

     List<BookPojo> getHotBooks();

     BookPojo findBookByBookId(String bookId);
}
