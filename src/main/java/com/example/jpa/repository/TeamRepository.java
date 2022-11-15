package com.example.jpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.example.jpa.entity.Team;

public interface TeamRepository extends CrudRepository<Team,Long>, QueryByExampleExecutor<Team>{
    Iterable<Team> findByPersonsLastname(String lastname);
}
