package com.turnuvamvar.thesis.dataAccess.abstracts;

import com.turnuvamvar.thesis.entities.concretes.Stage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StageDao extends JpaRepository<Stage, Long> {
}
