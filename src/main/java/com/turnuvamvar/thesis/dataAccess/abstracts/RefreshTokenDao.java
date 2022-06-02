package com.turnuvamvar.thesis.dataAccess.abstracts;

import com.turnuvamvar.thesis.entities.concretes.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenDao extends JpaRepository<RefreshToken, Long> {
    RefreshToken findByUserId(Long userId);
}
