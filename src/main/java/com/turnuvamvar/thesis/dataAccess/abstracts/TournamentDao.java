package com.turnuvamvar.thesis.dataAccess.abstracts;

import com.turnuvamvar.thesis.entities.concretes.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentDao extends JpaRepository<Tournament,Long> { }
