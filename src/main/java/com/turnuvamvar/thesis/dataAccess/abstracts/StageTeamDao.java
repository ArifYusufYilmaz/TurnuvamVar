package com.turnuvamvar.thesis.dataAccess.abstracts;

import com.turnuvamvar.thesis.entities.concretes.StageTeam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StageTeamDao extends JpaRepository<StageTeam, Long> {
}
