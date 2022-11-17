package com.example.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.example.jpa.entity.Team;

public interface TeamRepository extends CrudRepository<Team,Long>, QueryByExampleExecutor<Team>{
    List<Team> findByPersonsLastname(String lastname);
    // @Query("SELECT t FROM Team t"
    // +" JOIN FETCH t.persons AS tp LEFT JOIN FETCH tp.colCur AS tpc LEFT JOIN FETCH tpc.classGrp AS tpcc"
    // +" LEFT JOIN FETCH tp.acaCur AS tpa LEFT JOIN FETCH tpa.classGrp AS tpac"
    // )
    // @EntityGraph(type = EntityGraphType.LOAD,attributePaths = {"persons.colCur.classGrp","persons.acaCur.classGrp"})
     //@EntityGraph, fetch join, queryDsl 모두 다 multi fetch join(MultipleBagFetchException)문제를 해결할 수 없음
     //@EntityGraph, fetch join으로 MultipleBagFetchException이 발생하지 않는 범위 내에서 쿼리를 조정 후
     // hibernate의 default_batch_fetch_size 기능을 사용해서 in 기능을 통해 쿼리를 줄여야함
    List<Team> findAll(Pageable pageable);
}
