package com.example.jpa.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.example.jpa.entity.AcaCur;

import lombok.Data;

@Data
public class AcaCurDto {
    private Long id;
    private ClassGrpDto classGrp;
    private List<ClassOneDto> classOnes = new ArrayList<>();

    public AcaCur convertDtoToEntity(){
        AcaCur colCur = new AcaCur();
        BeanUtils.copyProperties(this, colCur);
        if(this.getClassGrp()!=null){
            colCur.setClassGrp(this.getClassGrp().convertDtoToEntity());
        }
        colCur.setClassOnes(this.getClassOnes().stream().map(ClassOneDto::convertDtoToEntity).collect(Collectors.toList()));
        return colCur;
    }
}
