package com.example.bookmistakes.service;

import com.example.bookmistakes.entity.errorEntiy.ResponseResult;


public interface BookService {
    ResponseResult getBookByTitle(String title);
}