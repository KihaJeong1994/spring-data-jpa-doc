package com.example.jpa.service;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.jpa.entity.Person;
import com.example.jpa.repository.PersonRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;

    @Override
    public Iterable<Person> findAll(Example<Person> example) {
        return personRepository.findAll(example);
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }
    
}
