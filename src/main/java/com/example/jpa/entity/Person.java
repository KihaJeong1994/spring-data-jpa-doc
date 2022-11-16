package com.example.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.BeanUtils;

import com.example.jpa.dto.PersonDto;

import lombok.Data;

@Entity
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long id;

    private String firstname;

    private String lastname;

    // @ManyToOne(fetch = FetchType.LAZY) //(fetch = FetchType.EAGER)
    // @JoinColumn(name = "team_id")
    // private Team team;

    public PersonDto convertEntityToDto(){
        PersonDto pt = new PersonDto();
        BeanUtils.copyProperties(this, pt);
        return pt;
    }

}
