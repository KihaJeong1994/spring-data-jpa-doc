package com.example.jpa.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.dto.ClassGrpDto;
import com.example.jpa.service.ClassGrpService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/classGrp")
public class ClassGrpController {
    
    private final ClassGrpService classGrpService;

    @GetMapping("")
    public Iterable<ClassGrpDto> findPeople(){
        return classGrpService.findAll();
    }

    @PostMapping("")
    public ClassGrpDto save(@RequestBody ClassGrpDto classGrpDto){
        return classGrpService.save(classGrpDto);
    }
    
}
