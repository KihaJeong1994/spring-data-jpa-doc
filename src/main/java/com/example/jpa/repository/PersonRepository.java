package com.example.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import com.example.jpa.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person,Long>, QueryByExampleExecutor<Person>{
    
}
