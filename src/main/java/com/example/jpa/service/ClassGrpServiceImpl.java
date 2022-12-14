package com.example.jpa.service;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.jpa.dto.ClassGrpDto;
import com.example.jpa.entity.ClassGrp;
import com.example.jpa.repository.ClassGrpRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ClassGrpServiceImpl implements ClassGrpService{

    private final ClassGrpRepository classGrpRepository;

    @Override
    public Iterable<ClassGrpDto> findAll() {
        return classGrpRepository.findAll().stream().map(ClassGrp::convertEntityToDto).collect(Collectors.toList());
    }

    @Override
    public ClassGrpDto save(ClassGrpDto classGrpDto) {
        return classGrpRepository.save(classGrpDto.convertDtoToEntity()).convertEntityToDto();
    }

    
}
