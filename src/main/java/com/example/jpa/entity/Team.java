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

import org.springframework.beans.BeanUtils;

import com.example.jpa.dto.TeamDto;

import lombok.Data;

@Entity
@Data
public class Team {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;

    private String name;
    
    @OneToMany(cascade = CascadeType.ALL)//mappedby 혹은 JoinColumn 설정 시 연관관계 테이블 생성x
    @JoinColumn(name="team_id")
    // @JsonIgnoreProperties({"team"})
    private List<Person> persons = new ArrayList<>();

    public TeamDto convertEntityToDto(){
        TeamDto newTeamDto = new TeamDto();
        BeanUtils.copyProperties(this, newTeamDto);
        newTeamDto.setPersons(this.getPersons().stream().map(Person::convertEntityToDto).collect(Collectors.toList()));
        return newTeamDto;
    }
}
