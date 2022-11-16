package com.example.jpa.service;

import com.example.jpa.dto.PersonDto;

public interface PersonService {
    Iterable<PersonDto> findAll();
    PersonDto save(PersonDto person);
}
