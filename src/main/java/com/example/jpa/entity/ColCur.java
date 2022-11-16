package com.example.jpa.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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

    @OneToOne(mappedBy = "colCur")
    private Person person;

    @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name="colCur_id")
    private ClassGrp classGrp;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="colCur_id")
    private List<ClassOne> classOnes = new ArrayList<>();

    public ColCurDto convertEntityToDto(){
        ColCurDto colCurDto = new ColCurDto();
        BeanUtils.copyProperties(this, colCurDto);
        colCurDto.setClassGrp(this.getClassGrp().convertEntityToDto());
        colCurDto.setClassOnes(this.getClassOnes().stream().map(ClassOne::convertEntityToDto).collect(Collectors.toList()));
        return colCurDto;
    }
}
