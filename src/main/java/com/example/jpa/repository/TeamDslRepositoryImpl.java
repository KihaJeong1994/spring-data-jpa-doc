package com.example.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import static com.example.jpa.entity.QTeam.team;
import static com.example.jpa.entity.QPerson.person;
import static com.example.jpa.entity.QColCur.colCur;
import static com.example.jpa.entity.QAcaCur.acaCur;
import static com.example.jpa.entity.QClassGrp.classGrp;
import static com.example.jpa.entity.QClassOne.classOne;
import com.example.jpa.entity.Team;
import com.querydsl.jpa.impl.JPAQueryFactory;


@Repository
public class TeamDslRepositoryImpl extends QuerydslRepositorySupport implements TeamDslRepository{
    
    private final JPAQueryFactory jpaQueryFactory;
    public TeamDslRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        super(Team.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    

    @Override
    public List<Team> findAll(Pageable pageable){
        return jpaQueryFactory
                .selectFrom(team)
                .leftJoin(team.persons,person)
                // .fetchJoin() //fetch join시 pagination 메모리에서 작동
                .leftJoin(person.colCur,colCur)
                .leftJoin(colCur.classGrp,classGrp)
                .leftJoin(classGrp.classOnes,classOne)
                .leftJoin(colCur.classOnes,classOne)
                .leftJoin(person.acaCur,acaCur)
                .leftJoin(acaCur.classGrp,classGrp)
                .leftJoin(classGrp.classOnes,classOne)
                .leftJoin(acaCur.classOnes,classOne)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    };
}
