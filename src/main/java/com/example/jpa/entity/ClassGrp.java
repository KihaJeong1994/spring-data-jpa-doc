package com.example.jpa.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.beans.BeanUtils;

import com.example.jpa.dto.ClassGrpDto;

import lombok.Data;

@Entity
@Data
public class ClassGrp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classGrp_id")
    private Long id;
    private String classGrpName;

    @OneToOne(mappedBy = "classGrp")
    private ColCur colCur;

    @OneToOne(mappedBy = "classGrp")
    private AcaCur acaCur;

    @OneToMany(cascade = CascadeType.ALL)//mappedby 설정 시 연관관계 테이블 생성x
    @JoinColumn(name="classGrp_id")
    List<ClassOne> classOnes = new ArrayList<>();

    public ClassGrpDto convertEntityToDto(){
        ClassGrpDto classGrpDto= new ClassGrpDto();
        BeanUtils.copyProperties(this, classGrpDto);
        classGrpDto.setClassOnes(this.getClassOnes().stream().map(ClassOne::convertEntityToDto).collect(Collectors.toList()));
        return classGrpDto;
    }
}
