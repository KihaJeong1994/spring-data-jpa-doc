package com.example.jpa.dto;

import org.springframework.beans.BeanUtils;

import com.example.jpa.entity.ClassOne;

import lombok.Data;

@Data
public class ClassOneDto {
    private Long id;
    private String className;

    public ClassOne convertDtoToEntity(){
        ClassOne classOne = new ClassOne();
        BeanUtils.copyProperties(this, classOne);
        return classOne;
    }
}
