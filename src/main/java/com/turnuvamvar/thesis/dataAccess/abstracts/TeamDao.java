package com.turnuvamvar.thesis.dataAccess.abstracts;

import com.turnuvamvar.thesis.entities.concretes.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamDao extends JpaRepository<Team, Long> {


    List<Team> findAllByTournamentId(Long tournamentId);
}
