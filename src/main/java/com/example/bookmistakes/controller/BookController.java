package com.example.bookmistakes.controller;

import com.example.bookmistakes.entity.errorEntiy.ResponseResult;
import com.example.bookmistakes.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/test")
    public ResponseResult getBookByTitle(String title){
        return bookService.getBookByTitle("深入理解java虚拟机");
//        return ResponseResult.SuccessResult(1);
    }

    @GetMapping("/hotBooks")
    public ResponseResult getHotBooks(){
        return bookService.getHotBooks();
    }

    @GetMapping("/homeBooks")
    public ResponseResult getHomeBooks(){
        return bookService.getHomeBooks();
    }

    @GetMapping("/bookDetail")
    public ResponseResult getBookDetails(@RequestParam String bookId){
        return bookService.getBookDetails(bookId);
    }


}
