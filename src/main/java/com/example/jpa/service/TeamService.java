package com.example.jpa.service;

import org.springframework.data.domain.Pageable;

import com.example.jpa.dto.TeamDto;

public interface TeamService {
    TeamDto createTeam(TeamDto team);
    Iterable<TeamDto> findAll(Pageable pageable);
    Iterable<TeamDto> findByPersonsLastname(String lastname);
}
