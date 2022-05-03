package com.turnuvamvar.thesis.dataAccess.abstracts;

import com.turnuvamvar.thesis.entities.concretes.ScorePlayer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScorePlayerDao extends JpaRepository<ScorePlayer, Long> {
}
