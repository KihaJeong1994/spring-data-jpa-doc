package com.example.jpa.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.beans.BeanUtils;

import com.example.jpa.dto.ColCurDto;

import lombok.Data;

@Entity
@Data
public class ColCur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "colCur_id")
    private Long id;

    // @OneToOne(mappedBy = "colCur")
    // private Person person;

    @ManyToOne //다대일, 일대다 관계에서는 항상 "다"쪽이 외래키를 가짐=> "다"쪽인 @ManyToOne은 항상 연관관계의 주인 => mappedBy 속성이 없음
    @JoinColumn(name="classGrp_id")
    private ClassGrp classGrp;

    @ManyToMany
    @JoinTable(name = "ColCur_ClassOne",
    joinColumns = {@JoinColumn(name="colCur_id")}
    ,inverseJoinColumns = {@JoinColumn(name="classOne_id")}
    )
    private List<ClassOne> classOnes = new ArrayList<>();

    public ColCurDto convertEntityToDto(){
        ColCurDto colCurDto = new ColCurDto();
        BeanUtils.copyProperties(this, colCurDto);
        if(this.getClassGrp()!=null){
            colCurDto.setClassGrp(this.getClassGrp().convertEntityToDto());
        }
        colCurDto.setClassOnes(this.getClassOnes().stream().map(ClassOne::convertEntityToDto).collect(Collectors.toList()));
        return colCurDto;
    }
}
