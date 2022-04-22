package com.turnuvamvar.thesis.dataAccess.abstracts;

import com.turnuvamvar.thesis.entities.concretes.TeamCaptain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamCaptainDao extends JpaRepository<TeamCaptain, Long> {
}
