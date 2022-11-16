package com.example.jpa.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.example.jpa.entity.AcaCur;
import com.example.jpa.entity.ColCur;

import lombok.Data;

@Data
public class AcaCurDto {
    private Long id;
    private ClassGrpDto classGrp;
    private List<ClassOneDto> classOnes;

    public AcaCur convertDtoToEntity(){
        AcaCur colCur = new AcaCur();
        BeanUtils.copyProperties(this, colCur);
        colCur.setClassGrp(this.getClassGrp().convertDtoToEntity());
        colCur.setClassOnes(this.getClassOnes().stream().map(ClassOneDto::convertDtoToEntity).collect(Collectors.toList()));
        return colCur;
    }
}
