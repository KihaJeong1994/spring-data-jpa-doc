package com.example.jpa.service;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.jpa.dto.PersonDto;
import com.example.jpa.entity.Person;
import com.example.jpa.repository.PersonRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;

    @Override
    public Iterable<PersonDto> findAll() {
        return personRepository.findAll().stream().map(Person::convertEntityToDto).collect(Collectors.toList());
    }

    @Override
    public PersonDto save(PersonDto personDto) {
        return personRepository.save(personDto.convertDtoToEntity()).convertEntityToDto();
    }
    
}
