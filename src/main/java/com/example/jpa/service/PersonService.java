package com.example.jpa.service;

import org.springframework.data.domain.Example;

import com.example.jpa.entity.Person;

public interface PersonService {
    Iterable<Person> findAll(Example<Person> example);
    Person save(Person person);
}
