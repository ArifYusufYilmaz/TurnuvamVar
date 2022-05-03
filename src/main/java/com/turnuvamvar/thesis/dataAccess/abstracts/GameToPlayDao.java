package com.turnuvamvar.thesis.dataAccess.abstracts;

import com.turnuvamvar.thesis.entities.concretes.GameToPlay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameToPlayDao extends JpaRepository<GameToPlay, Long> {
}
