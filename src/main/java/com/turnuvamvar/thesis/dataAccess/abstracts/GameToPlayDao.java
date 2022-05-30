package com.turnuvamvar.thesis.dataAccess.abstracts;

import com.turnuvamvar.thesis.entities.concretes.GameToPlay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameToPlayDao extends JpaRepository<GameToPlay, Long> {
    Optional<GameToPlay> findByStageTeamFirstIdAndStageTeamSecondId(Long firstStageTeamId, Long secondStageTeamId);

    GameToPlay findByStageTeamFirstId(Long firstStageTeamId);

    GameToPlay findByStageTeamSecondId(Long secondStageTeamId);
}
