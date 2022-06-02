package com.turnuvamvar.thesis.api.controllers;

import com.turnuvamvar.thesis.business.concretes.RefreshTokenManager;
import com.turnuvamvar.thesis.business.concretes.UserManager;
import com.turnuvamvar.thesis.core.utilities.results.ErrorResult;
import com.turnuvamvar.thesis.dto.Request.RefreshRequestDto;
import com.turnuvamvar.thesis.dto.Request.UserRequestDto;
import com.turnuvamvar.thesis.dto.Response.AuthResponseDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turnuvamvar.thesis.entities.concretes.RefreshToken;
import com.turnuvamvar.thesis.entities.concretes.User;
import com.turnuvamvar.thesis.security.JwtTokenProvider;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private UserManager userManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RefreshTokenManager refreshTokenManager;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserManager userManager,
                          PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider, RefreshTokenManager refreshTokenManager) {
        this.authenticationManager = authenticationManager;
        this.userManager = userManager;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
        this.refreshTokenManager = refreshTokenManager;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody UserRequestDto loginRequest) {
        boolean isLoginSuccessful = userManager.validateUserLogin(loginRequest);
        if(!isLoginSuccessful){
            return new ResponseEntity(new ErrorResult("Kullanıcı adı veya şifre hatalı."), HttpStatus.BAD_REQUEST);
        }

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword());
        Authentication auth = authenticationManager.authenticate(authToken);
        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwtToken = jwtTokenProvider.generateJwtToken(auth);
        Optional<User> user = userManager.getOneUserByUserName(loginRequest.getUserName());
        AuthResponseDto authResponse = new AuthResponseDto();
        authResponse.setAccessToken(jwtToken);
        authResponse.setRefreshToken(refreshTokenManager.createRefreshToken(user.get()));
        authResponse.setUserId(user.get().getId());
        return new ResponseEntity(authResponse, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDto> register(@RequestBody UserRequestDto registerRequestDto) {
        AuthResponseDto authResponse = new AuthResponseDto();
        if(userManager.getOneUserByUserName(registerRequestDto.getUserName()).isPresent()) {
            authResponse.setMessage("Username already in use.");
            return new ResponseEntity(authResponse, HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setUserName(registerRequestDto.getUserName());
        user.setPassword(passwordEncoder.encode(registerRequestDto.getPassword()));
        userManager.saveOneUser(user);

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(registerRequestDto.getUserName(), registerRequestDto.getPassword());
        Authentication auth = authenticationManager.authenticate(authToken);
        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwtToken = jwtTokenProvider.generateJwtToken(auth);

        authResponse.setMessage("User successfully registered.");
        authResponse.setAccessToken(jwtToken);
        authResponse.setRefreshToken(refreshTokenManager.createRefreshToken(user));
        authResponse.setUserId(user.getId());
        return new ResponseEntity<>(authResponse, HttpStatus.CREATED);
    }

    @PostMapping("/refresh")
    public ResponseEntity<AuthResponseDto> refresh(@RequestBody RefreshRequestDto refreshRequestDto) {
        AuthResponseDto response = new AuthResponseDto();
        RefreshToken token = refreshTokenManager.getByUser(refreshRequestDto.getUserId());
        if(token.getToken().equals(refreshRequestDto.getRefreshToken()) &&
                !refreshTokenManager.isRefreshExpired(token)) {

            User user = token.getUser();
            String jwtToken = jwtTokenProvider.generateJwtTokenByUserId(user.getId());
            response.setMessage("token successfully refreshed.");
            response.setAccessToken(jwtToken);
            response.setUserId(user.getId());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.setMessage("refresh token is not valid.");
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }

    }


}