package com.example.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Data
public class Team {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;

    private String name;
    
    @OneToMany(cascade = CascadeType.ALL)//mappedby 설정 시 연관관계 테이블 생성x
    // @JsonIgnoreProperties({"team"})
    private List<Person> persons = new ArrayList<>();

    // public void addPerson(Person person){
    //     this.getPersons().add(person);
    //     person.setTeam(this);
    // }
}
