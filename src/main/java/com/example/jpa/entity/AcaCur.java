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
import javax.persistence.OrderColumn;

import org.springframework.beans.BeanUtils;

import com.example.jpa.dto.AcaCurDto;

import lombok.Data;

@Entity
@Data
public class AcaCur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acaCur_id")
    private Long id;

    // @OneToOne(mappedBy = "acaCur")
    // private Person person;

    @ManyToOne
    @JoinColumn(name="classGrp_id")
    private ClassGrp classGrp;

    @ManyToMany
    @JoinTable(name = "AcaCur_ClassOne",
    joinColumns = {@JoinColumn(name="acaCur_id")}
    ,inverseJoinColumns = {@JoinColumn(name="classOne_id")}
    ) //다대다 관계에서 중간에 연결고리 역할을 해줄 joinTable 생성
    @OrderColumn(name = "position")
    private List<ClassOne> classOnes = new ArrayList<>();

    public AcaCurDto convertEntityToDto(){
        AcaCurDto colCurDto = new AcaCurDto();
        BeanUtils.copyProperties(this, colCurDto);
        if(this.getClassGrp()!=null){
            colCurDto.setClassGrp(this.getClassGrp().convertEntityToDto());
        }
        colCurDto.setClassOnes(this.getClassOnes().stream().map(ClassOne::convertEntityToDto).collect(Collectors.toList()));
        return colCurDto;
    }
}
