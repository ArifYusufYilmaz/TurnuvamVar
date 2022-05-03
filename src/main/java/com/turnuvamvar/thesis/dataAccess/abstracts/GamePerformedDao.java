package com.turnuvamvar.thesis.dataAccess.abstracts;

import com.turnuvamvar.thesis.entities.concretes.GamePerformed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamePerformedDao extends JpaRepository<GamePerformed, Long> {
}
