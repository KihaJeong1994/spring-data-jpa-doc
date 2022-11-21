package com.example.jpa.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.jpa.dto.TeamDto;
import com.example.jpa.entity.Team;
import com.example.jpa.repository.TeamRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TeamServiceImpl implements TeamService{

    private final TeamRepository teamRepository;
    
    @Override
    public TeamDto createTeam(TeamDto teamDto) {
        return teamRepository.save(teamDto.convertDtoToEntity()).convertEntityToDto();
    }

    @Override
    public Iterable<TeamDto> findAll(Pageable pageable) {
        return teamRepository.findAll(pageable).stream().map(Team::convertEntityToDto).collect(Collectors.toList());
    }

    @Override
    public Iterable<TeamDto> findByPersonsLastname(String lastname) {
        return teamRepository.findByPersonsLastname(lastname).stream().map(Team::convertEntityToDto).collect(Collectors.toList());
    }

    @Override
    public void updateTeamById(Long id, TeamDto teamDto) {
        Optional<Team> updateTeam = teamRepository.findById(id);
        updateTeam.ifPresentOrElse(
            u->{
                Team dtoToTeam = teamDto.convertDtoToEntity();
                dtoToTeam.setId(id);
                u = dtoToTeam;
                teamRepository.save(u);
            }
            ,()->  System.out.println("no team")
        );
    }
    
}
