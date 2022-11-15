package com.example.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.jpa.dto.PersonDto;
import com.example.jpa.entity.Person;
import com.example.jpa.entity.Team;
import com.example.jpa.repository.PersonRepository;
import com.example.jpa.repository.TeamRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonService{

    private final TeamRepository teamRepository;
    private final PersonRepository personRepository;

    @Override
    public Iterable<PersonDto> findAll() {
        List<PersonDto> newPersonDtos = new ArrayList<>();
        Iterable<Person> findAll = personRepository.findAll();
        for(Person t: findAll){
            PersonDto newPersonDto = new PersonDto();
            BeanUtils.copyProperties(t, newPersonDto);
            newPersonDtos.add(newPersonDto);
        }
        return newPersonDtos;
    }

    @Override
    public PersonDto save(PersonDto personDto) {
        Person person = new Person();
        BeanUtils.copyProperties(personDto, person);
        // person.setTeam(teamRepository.findById(personDto.getTeamid()).get());
        Person newPerson = personRepository.save(person);
        PersonDto newPersonDto = new PersonDto();
        BeanUtils.copyProperties(newPerson, newPersonDto);
        return newPersonDto;
    }
    
}
