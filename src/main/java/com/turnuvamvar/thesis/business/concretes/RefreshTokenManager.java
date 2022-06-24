package com.turnuvamvar.thesis.business.concretes;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

import com.turnuvamvar.thesis.dataAccess.abstracts.RefreshTokenDao;
import com.turnuvamvar.thesis.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.turnuvamvar.thesis.entities.concretes.RefreshToken;


@Service
public class RefreshTokenManager {
    @Value("${refresh.token.expires.in}")
    Long expireSeconds;
    @Autowired
    private RefreshTokenDao refreshTokenDao;
    @Autowired
	public RefreshTokenManager(RefreshTokenDao refreshTokenDao) {
        this.refreshTokenDao = refreshTokenDao;
    }
    public String createRefreshToken(User user) {
        RefreshToken token = refreshTokenDao.findByUserId(user.getId());
        if(token == null) {
            token =	new RefreshToken();
            token.setUser(user);
        }
        token.setToken(UUID.randomUUID().toString());
        token.setExpiryDate(Date.from(Instant.now().plusSeconds(expireSeconds)));
        refreshTokenDao.save(token);
        return token.getToken();
    }
    public boolean isRefreshExpired(RefreshToken token) {
        return token.getExpiryDate().before(new Date());
    }
    public RefreshToken getByUser(Long userId) {
        return refreshTokenDao.findByUserId(userId);
    }
}