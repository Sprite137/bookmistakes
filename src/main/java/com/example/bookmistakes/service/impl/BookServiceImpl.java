package com.example.bookmistakes.service.impl;

import com.example.bookmistakes.entity.errorEntiy.ResponseResult;
import com.example.bookmistakes.entity.pojo.BookPojo;
import com.example.bookmistakes.entity.vo.BookDetailVo;
import com.example.bookmistakes.entity.vo.HomeBooksVo;
import com.example.bookmistakes.mapper.BookMapper;
import com.example.bookmistakes.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public ResponseResult<Object> getBookByTitle(String title) {
        return ResponseResult.SuccessResult(bookMapper.getBookByTitle(title));
    }

    @Override
    public ResponseResult getHotBooks() {
        return ResponseResult.SuccessResult(bookMapper.getHotBooks());
    }

    @Override
    public ResponseResult getHomeBooks() {
        List<BookPojo> hotBooks = bookMapper.getHotBooks();
        List<HomeBooksVo> homeBooks = hotBooks.stream().map(item ->{
            HomeBooksVo temp = new HomeBooksVo();
            BeanUtils.copyProperties(item,temp);
            return temp;
        }).collect(Collectors.toList());
        BeanUtils.copyProperties(hotBooks,homeBooks);
        return ResponseResult.SuccessResult(homeBooks);
    }

    @Override
    public ResponseResult getBookDetails(String bookId) {
        BookDetailVo bookDetailVo = new BookDetailVo();
        BookPojo bookPojo = bookMapper.findBookByBookId(bookId);
        BeanUtils.copyProperties(bookPojo,bookDetailVo);
        return ResponseResult.SuccessResult(bookDetailVo);
    }
}
