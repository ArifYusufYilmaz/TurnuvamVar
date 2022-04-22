package com.turnuvamvar.thesis.dataAccess.abstracts;

import com.turnuvamvar.thesis.entities.concretes.TeamCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamCodeDao extends JpaRepository<TeamCode, Long> {
}
