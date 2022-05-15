package com.turnuvamvar.thesis.dataAccess.abstracts;

import com.turnuvamvar.thesis.entities.concretes.StageTeam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StageTeamDao extends JpaRepository<StageTeam, Long> {

    Optional<StageTeam> findByTeamIdAndStageId(Long id, Long id1);
}
