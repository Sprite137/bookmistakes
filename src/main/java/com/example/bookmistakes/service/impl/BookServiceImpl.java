package com.example.bookmistakes.service.impl;

import com.example.bookmistakes.entity.errorEntiy.ResponseResult;
import com.example.bookmistakes.mapper.BookMapper;
import com.example.bookmistakes.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public ResponseResult<Object> getBookByTitle(String title) {
        return ResponseResult.SuccessResult(bookMapper.getBookByTitle(title));
    }
}
