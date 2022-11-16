package com.example.jpa.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.dto.ClassOneDto;
import com.example.jpa.service.ClassOneService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/classOne")
public class ClassOneController {
    
    private final ClassOneService classOneService;

    @GetMapping("")
    public Iterable<ClassOneDto> findPeople(){
        return classOneService.findAll();
    }

    @PostMapping("")
    public ClassOneDto save(@RequestBody ClassOneDto classOneDto){
        return classOneService.save(classOneDto);
    }
    
}
