package com.turnuvamvar.thesis.dataAccess.abstracts;

import com.turnuvamvar.thesis.entities.concretes.PlayerToAdd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerToAddDao extends JpaRepository<PlayerToAdd, Long> {
}
