package com.myblog5.myblog5.controller;

import com.myblog5.myblog5.entity.Role;
import com.myblog5.myblog5.entity.User;
import com.myblog5.myblog5.payload.LoginDto;
import com.myblog5.myblog5.payload.SignUpDto;
import com.myblog5.myblog5.repository.RoleRepository;
import com.myblog5.myblog5.repository.UserRepository;
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

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(), loginDto.getPassword());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        SecurityContextHolder.getContext().setAuthentication(authenticate);
        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);

    }

    @PostMapping("/signup")
    public ResponseEntity<?> createRegistration(@RequestBody SignUpDto signUpDto) {
        if(userRepository.existsByEmail(signUpDto.getEmail())){
            return new ResponseEntity<>("Email already exists",HttpStatus.BAD_REQUEST);
        }
        if(userRepository.existsByUsername(signUpDto.getUsername())){
            return new ResponseEntity<>("Username already exists",HttpStatus.BAD_REQUEST);
        }
        User user= new User();
        user.setName(signUpDto.getName());
        user.setUsername(signUpDto.getUsername());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        userRepository.save(user);
        Role roles = roleRepository.findByName(signUpDto.getRoleType()).get();
        Set<Role>convertToSet=new HashSet<>();
        convertToSet.add(roles);
        user.setRoles(convertToSet);
        return new ResponseEntity<>("Registration done successfully", HttpStatus.CREATED);
    }
}
