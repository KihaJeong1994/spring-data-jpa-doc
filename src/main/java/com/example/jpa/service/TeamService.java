package com.example.jpa.service;

import com.example.jpa.dto.TeamDto;
import com.example.jpa.entity.Team;

public interface TeamService {
    TeamDto createTeam(TeamDto team);
    Iterable<TeamDto> findAll();
    Iterable<TeamDto> findByPersonsLastname(String lastname);
}
