package com.example.bookmistakes.controller;

import com.example.bookmistakes.entity.errorEntiy.ResponseResult;
import com.example.bookmistakes.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/test")
    public ResponseResult getBookByTitle(String title){
        return bookService.getBookByTitle("深入理解java虚拟机");
    }
}
