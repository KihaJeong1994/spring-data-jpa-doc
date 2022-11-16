package com.example.jpa.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.example.jpa.entity.ColCur;

import lombok.Data;

@Data
public class ColCurDto {
    private Long id;
    private ClassGrpDto classGrp;
    private List<ClassOneDto> classOnes;

    public ColCur convertDtoToEntity(){
        ColCur colCur = new ColCur();
        BeanUtils.copyProperties(this, colCur);
        colCur.setClassGrp(this.getClassGrp().convertDtoToEntity());
        colCur.setClassOnes(this.getClassOnes().stream().map(ClassOneDto::convertDtoToEntity).collect(Collectors.toList()));
        return colCur;
    }
}
