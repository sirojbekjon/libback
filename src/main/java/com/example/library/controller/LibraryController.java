package com.example.library.controller;


import com.example.library.log.Loggerr;
import com.example.library.payload.ApiResponse;
import com.example.library.payload.LibDto;
import com.example.library.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/library")
public class LibraryController {

    private final LibraryService libraryService;


    @PostMapping("/add")
    public HttpEntity<?> addLibrary(@Valid @RequestBody LibDto libDto ){
        Loggerr.log();
        ApiResponse apiResponse = libraryService.addLib(libDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }



    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> deleteLibById(@PathVariable Long id){
        Loggerr.log();
        ApiResponse apiResponse = libraryService.deleteLib(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }


    @PutMapping("/edit/{edit_id}")
    public HttpEntity<?> editLib(@PathVariable Long edit_id,@RequestBody LibDto libDto){
        Loggerr.log();
        ApiResponse apiResponse = libraryService.editLib(edit_id,libDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }



    @GetMapping("/view/{libId}")
    public HttpEntity<?> getLibById(@Valid @PathVariable Long libId){
        Loggerr.log();
        return libraryService.getLibById(libId);
    }



    @GetMapping("/view/all")
    public HttpEntity<?> getAllLib(){
        Loggerr.log();
        return libraryService.getAll();
    }

}
