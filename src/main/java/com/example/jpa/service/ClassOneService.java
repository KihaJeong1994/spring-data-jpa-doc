package com.example.jpa.service;

import com.example.jpa.dto.ClassOneDto;

public interface ClassOneService {
    Iterable<ClassOneDto> findAll();
    ClassOneDto save(ClassOneDto classOneDto);
}
