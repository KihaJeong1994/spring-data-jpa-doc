package com.example.jpa.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.example.jpa.entity.ClassGrp;

import lombok.Data;

@Data
public class ClassGrpDto {
    private Long id;
    private String classGrpName;

    List<ClassOneDto> classOnes = new ArrayList<>();

    public ClassGrp convertDtoToEntity(){
        ClassGrp classGrp= new ClassGrp();
        BeanUtils.copyProperties(this, classGrp);
        classGrp.setClassOnes(this.getClassOnes().stream().map(ClassOneDto::convertDtoToEntity).collect(Collectors.toList()));
        return classGrp;
    }
}
