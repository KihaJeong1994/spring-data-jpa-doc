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
import com.querydsl.jpa.JPAExpressions;
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
        List<Long> idList = jpaQueryFactory
        .select(team.id)
        .from(team)
        .offset(pageable.getOffset())
        .limit(pageable.getPageSize())
        .fetch();

        return jpaQueryFactory
                .selectFrom(team)
                .leftJoin(team.persons,person)
                .fetchJoin() //fetch join시 pagination 메모리에서 작동(기존 fetchjoin에서 pagination 작동 안하는 원리와 동일, 그러나 fetch join 사용 안하면 결과값이 Team의 column만 한정해서 나옴)
                .leftJoin(person.colCur,colCur)
                .fetchJoin() 
                .leftJoin(colCur.classGrp,classGrp)
                .fetchJoin() 
                .leftJoin(classGrp.classOnes,classOne)
                .fetchJoin() 
                .leftJoin(colCur.classOnes,classOne)
                .fetchJoin() 
                .leftJoin(person.acaCur,acaCur)
                .fetchJoin() 
                .leftJoin(acaCur.classGrp,classGrp)
                .fetchJoin() 
                .leftJoin(classGrp.classOnes,classOne)
                .fetchJoin() 
                .leftJoin(acaCur.classOnes,classOne)
                .fetchJoin() 
                .distinct()
                // .where(team.id.in(JPAExpressions.select(team.id)
                //                         .from(team)
                //                         .offset(pageable.getOffset())// sub query에서 작동안함
                //                         .limit(pageable.getPageSize()))) // sub query에서 작동안함
                .where(team.id.in(idList))
                .fetch();
    }
}
