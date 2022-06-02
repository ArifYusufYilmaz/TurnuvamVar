package com.turnuvamvar.thesis.business.concretes;

import com.turnuvamvar.thesis.dataAccess.abstracts.UserDao;
import com.turnuvamvar.thesis.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserManager {
    @Autowired
    UserDao userDao;
    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao
        ;
    }

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public User saveOneUser(User newUser) {
        return userDao.save(newUser);
    }

    public User getOneUserById(Long userId) {
        return userDao.findById(userId).orElse(null);
    }

    public User updateOneUser(Long userId, User newUser) {
        Optional<User> user = userDao.findById(userId);
        if(user.isPresent()) {
            User foundUser = user.get();
            foundUser.setUserName(newUser.getUserName());
            foundUser.setPassword(newUser.getPassword());
            foundUser.setEmail(newUser.getEmail());
            userDao.save(foundUser);
            return foundUser;
        }else
            return null;
    }

    public void deleteById(Long userId) {
        try {
            userDao.deleteById(userId);
        }catch(EmptyResultDataAccessException e) { //user zaten yok, db'den empty result gelmiş
            System.out.println("User "+userId+" doesn't exist"); //istersek loglayabiliriz
        }
    }

    public User getOneUserByUserName(String userName) {
        return userDao.findByUserName(userName);
    }
}
