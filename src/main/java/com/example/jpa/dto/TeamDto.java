package com.example.jpa.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.example.jpa.entity.Team;

import lombok.Data;

@Data
public class TeamDto {
    
    private Long id;

    private String name;
    
    private List<PersonDto> persons = new ArrayList<>();

    public Team convertDtoToEntity(){
        Team team = new Team();
        BeanUtils.copyProperties(this, team);
        team.setPersons(this.getPersons().stream().map(PersonDto::convertDtoToEntity).collect(Collectors.toList()));
        return team;
    }
}
