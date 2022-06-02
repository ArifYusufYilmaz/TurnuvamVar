package com.turnuvamvar.thesis.business.concretes;

import com.turnuvamvar.thesis.dataAccess.abstracts.UserDao;
import com.turnuvamvar.thesis.entities.concretes.User;
import com.turnuvamvar.thesis.security.JwtUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsManager implements UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Autowired
    public UserDetailsManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUserName(username);
        return JwtUserDetails.create(user);
    }

    public UserDetails loadUserById(Long id) {
        User user = userDao.findById(id).get();
        return JwtUserDetails.create(user);
    }

}