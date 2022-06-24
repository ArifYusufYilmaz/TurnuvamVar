package com.turnuvamvar.thesis.dataAccess.abstracts;

import com.turnuvamvar.thesis.entities.concretes.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreDao extends JpaRepository<Score,Long> { }
