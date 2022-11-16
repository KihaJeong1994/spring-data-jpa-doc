package com.example.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.jpa.dto.PersonDto;
import com.example.jpa.dto.TeamDto;
import com.example.jpa.entity.Person;
import com.example.jpa.entity.Team;
import com.example.jpa.repository.TeamRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TeamServiceImpl implements TeamService{

    private final TeamRepository teamRepository;
    
    @Override
    public TeamDto createTeam(TeamDto teamDto) {
        return teamRepository.save(teamDto.convertDtoToEntity()).convertEntityToDto();
    }

    @Override
    public Iterable<TeamDto> findAll() {
        return teamRepository.findAll().stream().map(Team::convertEntityToDto).collect(Collectors.toList());
    }

    @Override
    public Iterable<TeamDto> findByPersonsLastname(String lastname) {
        return teamRepository.findByPersonsLastname(lastname).stream().map(Team::convertEntityToDto).collect(Collectors.toList());
    }
    
}
