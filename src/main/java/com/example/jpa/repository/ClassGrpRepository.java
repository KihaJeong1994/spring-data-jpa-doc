package com.example.jpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.example.jpa.entity.ClassGrp;

public interface ClassGrpRepository extends CrudRepository<ClassGrp,Long>, QueryByExampleExecutor<ClassGrp>{
    List<ClassGrp> findAll();
}
