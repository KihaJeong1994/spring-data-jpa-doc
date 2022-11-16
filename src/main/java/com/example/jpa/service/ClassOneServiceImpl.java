package com.example.jpa.service;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.jpa.dto.ClassOneDto;
import com.example.jpa.entity.ClassOne;
import com.example.jpa.repository.ClassOneRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ClassOneServiceImpl implements ClassOneService{

    private final ClassOneRepository classOneRepository;

    @Override
    public Iterable<ClassOneDto> findAll() {
        return classOneRepository.findAll().stream().map(ClassOne::convertEntityToDto).collect(Collectors.toList());
    }

    @Override
    public ClassOneDto save(ClassOneDto classOneDto) {
        return classOneRepository.save(classOneDto.convertDtoToEntity()).convertEntityToDto();
    }

    
}
