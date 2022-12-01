package com.example.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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

    @OneToOne(cascade = CascadeType.ALL) // mappedBy 없는 쪽이 주인(fk를 가진다)
    // @JoinColumn(name="person_id")
    private ColCur colCur;

    @OneToOne(cascade = CascadeType.ALL)
    private AcaCur acaCur;

    // @ManyToOne(fetch = FetchType.LAZY) //(fetch = FetchType.EAGER)
    // @JoinColumn(name = "team_id")
    // private Team team;

    public PersonDto convertEntityToDto(){
        PersonDto pt = new PersonDto();
        BeanUtils.copyProperties(this, pt);
        if(this.getColCur()!=null){
            pt.setColCur(this.getColCur().convertEntityToDto());
        }
        if(this.getAcaCur()!=null){
            pt.setAcaCur(this.getAcaCur().convertEntityToDto());
        }
        return pt;
    }

}
