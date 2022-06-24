package com.turnuvamvar.thesis.dataAccess.abstracts;

import com.turnuvamvar.thesis.entities.concretes.Stage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StageDao extends JpaRepository<Stage, Long> {
    Optional<Stage> findByStageName(String stageName);
    List<Stage> findAllByTournamentId(Long tournamentId);
    Stage findByStageNameAndTournamentId(String stageName, Long tournamentId);
}
