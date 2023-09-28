package com.br.puc.beachtennis.service;

import com.br.puc.beachtennis.model.Team;
import com.br.puc.beachtennis.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Optional<Team> getTeamById(Long id) {
        return teamRepository.findById(id);
    }

    public Team updateTeam(Long id, Team updatedTeam) {
        Optional<Team> existingTeam = teamRepository.findById(id);
        if (existingTeam.isPresent()) {
            Team team = existingTeam.get();
            team.setNmPlayer(updatedTeam.getNmPlayer());
            team.setDsTeam(updatedTeam.getDsTeam());
            return teamRepository.save(team);
        } else {
            throw new RuntimeException("Team not found with ID: " + id);
        }
    }

    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }
}
