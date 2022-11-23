package com.example.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.jpa.entity.Team;

public interface TeamDslRepository {
    public List<Team> findAll(Pageable pageable);
}
