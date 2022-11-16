package com.example.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.BeanUtils;

import com.example.jpa.dto.ClassOneDto;

import lombok.Data;

@Entity
@Data
public class ClassOne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private Long id;
    private String className;

    public ClassOneDto convertEntityToDto(){
        ClassOneDto classOneDto= new ClassOneDto();
        BeanUtils.copyProperties(this, classOneDto);
        return classOneDto;
    }
}
