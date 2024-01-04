package com.example.library.controller;

import com.example.library.payload.ApiResponse;
import com.example.library.payload.BookDto;
import com.example.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/book")
public class BooksController {

    private final BookService bookService;

    @PostMapping("/add")
    public ApiResponse addBook(@Valid @RequestBody BookDto bookDto){
        return bookService.addBook(bookDto);
    }

    @PutMapping("/edit/{id}")
    public ApiResponse editBook(@Valid @PathVariable Long id, @RequestBody BookDto bookDto){
        return bookService.editBook(bookDto,id);
    }


    @GetMapping("/view/all")
    public HttpEntity<?> getAllBook(){
        return bookService.getAllBook();
    }

    @GetMapping("/view/{id}")
    public HttpEntity<?> getAllBook(@Valid @PathVariable Long id){
        return bookService.getBookById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteBook(@Valid @PathVariable Long id){
       return bookService.deleteById(id);
    }

}
