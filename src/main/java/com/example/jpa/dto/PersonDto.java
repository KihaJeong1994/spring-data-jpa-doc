package com.example.jpa.dto;

import org.springframework.beans.BeanUtils;

import com.example.jpa.entity.Person;

import lombok.Data;

@Data
public class PersonDto {

    private Long id;

    private String firstname;

    private String lastname;

    private ColCurDto colCur;

    private AcaCurDto acaCur;


    public Person convertDtoToEntity(){
        Person person = new Person();
        BeanUtils.copyProperties(this, person);
        person.setColCur(this.getColCur().convertDtoToEntity());
        person.setAcaCur(this.getAcaCur().convertDtoToEntity());
        return person;
    }
}
