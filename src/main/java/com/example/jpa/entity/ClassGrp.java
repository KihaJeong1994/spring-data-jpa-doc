package com.example.jpa.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

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

    @OneToMany(mappedBy = "classGrp")
    private List<ColCur> colCurs= new ArrayList<>();

    @OneToMany(mappedBy = "classGrp")
    private List<AcaCur> acaCurs= new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "ClassGrp_ClassOne",
    joinColumns = {@JoinColumn(name="classGrp_id")}
    ,inverseJoinColumns = {@JoinColumn(name="classOne_id")}
    )
    List<ClassOne> classOnes = new ArrayList<>();

    public ClassGrpDto convertEntityToDto(){
        ClassGrpDto classGrpDto= new ClassGrpDto();
        BeanUtils.copyProperties(this, classGrpDto);
        classGrpDto.setClassOnes(this.getClassOnes().stream().map(ClassOne::convertEntityToDto).collect(Collectors.toList()));
        return classGrpDto;
    }
}
