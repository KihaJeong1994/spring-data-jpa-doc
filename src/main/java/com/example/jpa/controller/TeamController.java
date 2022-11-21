package com.example.jpa.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.dto.TeamDto;
import com.example.jpa.service.TeamService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequiredArgsConstructor
@RequestMapping("/team")
public class TeamController {
    
    private final TeamService teamService;

    @GetMapping("")
    public Iterable<TeamDto> findAll(Pageable pageable){
        return teamService.findAll(pageable);
    }

    @GetMapping("/person")
    public Iterable<TeamDto> findByPersonsLastname(@RequestParam String lastname){
        return teamService.findByPersonsLastname(lastname);
    }

    @PostMapping("")
    public TeamDto createTeam(@RequestBody TeamDto team){
        return teamService.createTeam(team);
    }

    @PutMapping("/{id}")
    public void updateTeamById(@PathVariable Long id, @RequestBody TeamDto teamDto){
        teamService.updateTeamById(id,teamDto);
    }
}
