package com.example.jpa.dto;

import java.util.List;

import lombok.Data;

@Data
public class TeamDto {
    
    private Long id;

    private String name;
    
    private List<PersonDto> persons;
}
