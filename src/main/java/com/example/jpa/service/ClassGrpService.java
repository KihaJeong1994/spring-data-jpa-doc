package com.example.jpa.service;

import com.example.jpa.dto.ClassGrpDto;

public interface ClassGrpService {
    Iterable<ClassGrpDto> findAll();
    ClassGrpDto save(ClassGrpDto classGrpDto);
}
