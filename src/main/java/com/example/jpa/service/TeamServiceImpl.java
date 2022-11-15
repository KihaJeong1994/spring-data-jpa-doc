package com.example.jpa.service;

import java.util.ArrayList;
import java.util.List;

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
        Team team = new Team();
        BeanUtils.copyProperties(teamDto, team);
        // List<PersonDto> personDtos = teamDto.getPerson();
        // for(PersonDto pt : personDtos){
        //     Person person = new Person();
        //     BeanUtils.copyProperties(pt, person);
        //     team.addPerson(person);
        // }
        List<PersonDto> personDtos = teamDto.getPersons();
        for(PersonDto pt : personDtos){
            Person person = new Person();
            BeanUtils.copyProperties(pt, person);
            team.getPersons().add(person);
        }
        Team newTeam = teamRepository.save(team);
        TeamDto newTeamDto = new TeamDto();
        BeanUtils.copyProperties(newTeam, newTeamDto);
        return newTeamDto;
    }

    @Override
    public Iterable<TeamDto> findAll() {
        List<TeamDto> newTeamDtos = new ArrayList<>();
        Iterable<Team> findAll = teamRepository.findAll();
        for(Team t: findAll){
            TeamDto newTeamDto = new TeamDto();
            BeanUtils.copyProperties(t, newTeamDto);
            List<Person> persons = t.getPersons();
            List<PersonDto> personDtos = new ArrayList<>();
            for(Person p: persons){
                PersonDto pt = new PersonDto();
                BeanUtils.copyProperties(p, pt);
                personDtos.add(pt);
            }
            newTeamDto.setPersons(personDtos);
            newTeamDtos.add(newTeamDto);
        }
        return newTeamDtos;
    }

    @Override
    public Iterable<TeamDto> findByPersonsLastname(String lastname) {
        List<TeamDto> newTeamDtos = new ArrayList<>();
        Iterable<Team> findAll = teamRepository.findByPersonsLastname(lastname);
        for(Team t: findAll){
            TeamDto newTeamDto = new TeamDto();
            BeanUtils.copyProperties(t, newTeamDto);
            List<Person> persons = t.getPersons();
            List<PersonDto> personDtos = new ArrayList<>();
            for(Person p: persons){
                PersonDto pt = new PersonDto();
                BeanUtils.copyProperties(p, pt);
                personDtos.add(pt);
            }
            newTeamDto.setPersons(personDtos);
            newTeamDtos.add(newTeamDto);
        }
        return newTeamDtos;
    }
    
}
