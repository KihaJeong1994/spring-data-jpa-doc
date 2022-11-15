package com.example.jpa.controller;


import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.dto.PersonDto;
import com.example.jpa.entity.Person;
import com.example.jpa.service.PersonService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {
    
    private final PersonService personService;

    @GetMapping("")
    public Iterable<PersonDto> findPeople(){
        return personService.findAll();
    }

    @PostMapping("")
    public PersonDto save(@RequestBody PersonDto person){
        return personService.save(person);
    }
    
}