package com.proiect.colectiv.controller;

import com.proiect.colectiv.config.JwtTokenUtil;
import com.proiect.colectiv.dto.ForgotPasswordDTO;
import com.proiect.colectiv.dto.LoginUserDTO;
import com.proiect.colectiv.dto.ResetPasswordDTO;
import com.proiect.colectiv.dto.UserDTO;
import com.proiect.colectiv.model.*;
import com.proiect.colectiv.repository.UserRepository;
import com.proiect.colectiv.service.MailService;
import com.proiect.colectiv.service.UserService;
import com.proiect.colectiv.utils.SecurityUtils;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.security.access.prepost.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.util.Collection;

@Api
@Controller
@RequestMapping("/api")
@Transactional
public class LoginController {

    private AuthenticationManager authenticationManager;
    private JwtTokenUtil jwtTokenUtil;
    private UserService userService;
    private MailService mailService;
    private UserRepository userRepository;



    public LoginController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, UserService userService, MailService mailService, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
        this.mailService = mailService;
        this.userRepository = userRepository;
    }

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @CrossOrigin
    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody LoginUserDTO loginUserDTO) throws AuthenticationException {
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUserDTO.getUsername(), loginUserDTO.getPassword()));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        if(!authentication.isAuthenticated()){
//            return ResponseEntity.status(401).build();
//        }
//        String jwt = jwtTokenUtil.generateToken(authentication);
//        CurrentUser userPrincipal = (CurrentUser) authentication.getPrincipal();
//
//
//        return ResponseEntity.ok().header("Authorization",new AuthToken(jwt, userPrincipal.getUsername(), userPrincipal.getId()).toString()).build();
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUserDTO.getUsername(), loginUserDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenUtil.generateToken(authentication);
        CurrentUser userPrincipal = (CurrentUser) authentication.getPrincipal();

        return ResponseEntity.ok(new AuthToken(jwt, userPrincipal.getUsername(), userPrincipal.getId()));
    }

    @CrossOrigin
    @RequestMapping(value = "/forgot-password", method = RequestMethod.POST)
    public User resetPassword(@RequestBody ForgotPasswordDTO email) throws UnsupportedEncodingException, MessagingException {
        String plainPassword = RandomStringUtils.randomAlphanumeric(7);
        String encryptedPassword = passwordEncoder.encode(plainPassword);
        User updatedAccount = userService.updateUserPassword(email.getEmail(), encryptedPassword);
        mailService.sendEmail(updatedAccount.getEmail(), plainPassword);

        return userRepository.findByEmail(email.getEmail());

    }

    @CrossOrigin
    @PreAuthorize("hasAuthority('USER')  or hasAuthority('ADMINISTRATOR') ")
    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public ResponseEntity<?> check(@RequestBody HttpEntity tokenEntity){
        String token = tokenEntity.getHeaders().get("Authorizarion").get(0);
        boolean isOk = jwtTokenUtil.validateToken(token);
        if(!isOk) {
            return ResponseEntity.status(401).build();
        }
        return new ResponseEntity(HttpStatus.OK);
    }


    @CrossOrigin
    @PreAuthorize("hasAuthority('USER')")
    @RequestMapping(value = "/change-password", method = RequestMethod.POST)
    public void changePassword(@RequestBody ResetPasswordDTO resetPasswordDTO) throws Exception {

        User user = userRepository.findById(SecurityUtils.getCurrentUserID());
        String encodedP = passwordEncoder.encode(resetPasswordDTO.getNewPassword());
        userRepository.updateUserPassword(user.getId(),encodedP);
    }


    @CrossOrigin
    @PreAuthorize("hasAuthority('USER')  or hasAuthority('ADMINISTRATOR') ")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ResponseEntity<?> logout() throws AuthenticationException {
        Authentication authentication = new Authentication() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public Object getCredentials() {
                return null;
            }

            @Override
            public Object getDetails() {
                return null;
            }

            @Override
            public Object getPrincipal() {
                return null;
            }

            @Override
            public boolean isAuthenticated() {
                return false;
            }

            @Override
            public void setAuthenticated(boolean b) throws IllegalArgumentException {

            }

            @Override
            public String getName() {
                return null;
            }
        };
        authentication.setAuthenticated(false);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return ResponseEntity.ok(SecurityContextHolder.getContext().getAuthentication());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public @ResponseBody User register(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        String encryptedPassword = passwordEncoder.encode(userDTO.getPassword());
        user.setPassword(encryptedPassword);
        user.setRole(Role.USER);

        return userService.save(user);
    }

    @RequestMapping(value = "/register-admin", method = RequestMethod.POST)
    public @ResponseBody User registerAdmin(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        String encryptedPassword = passwordEncoder.encode(userDTO.getPassword());
        user.setPassword(encryptedPassword);
        user.setRole(Role.ADMINISTRATOR);

        return userService.save(user);
    }


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
