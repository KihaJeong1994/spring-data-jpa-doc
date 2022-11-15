package com.example.jpa.service;

import org.springframework.data.domain.Example;

import com.example.jpa.dto.PersonDto;
import com.example.jpa.entity.Person;

public interface PersonService {
    Iterable<PersonDto> findAll();
    PersonDto save(PersonDto person);
}
