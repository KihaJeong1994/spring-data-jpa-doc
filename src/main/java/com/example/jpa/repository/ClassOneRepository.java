package com.example.jpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.example.jpa.entity.ClassOne;

public interface ClassOneRepository extends CrudRepository<ClassOne,Long>, QueryByExampleExecutor<ClassOne>{
    List<ClassOne> findAll();
}
