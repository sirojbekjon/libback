package com.example.library.controller;

import com.example.library.log.Loggerr;
import com.example.library.payload.ApiResponse;
import com.example.library.payload.BookTypeDto;
import com.example.library.service.BookTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/type")
public class BooksTypeController {

    @Autowired
    BookTypeService bookTypeService;

    @PostMapping("/add")
    public ApiResponse addBookType(@Valid @RequestBody BookTypeDto bookTypeDto){
        Loggerr.log();
        return bookTypeService.addBookType(bookTypeDto);
    }


    @PostMapping("/edit/{id}")
    public ApiResponse editBookType(@Valid @PathVariable Long id, @RequestBody BookTypeDto bookTypeDto){
        Loggerr.log();
        return bookTypeService.editBookType(id,bookTypeDto);
    }


    @GetMapping("/all")
    public HttpEntity<?> getBookType(){
        Loggerr.log();
        return bookTypeService.getAllBookType();
    }


    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteBookType(@Valid @PathVariable Long id){
        Loggerr.log();
        return bookTypeService.deleteById(id);
    }


}
