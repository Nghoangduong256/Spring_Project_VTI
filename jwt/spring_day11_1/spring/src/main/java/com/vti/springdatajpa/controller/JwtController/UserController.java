package com.vti.springdatajpa.controller.JwtController;

import com.vti.springdatajpa.dto.AccountDto;
import com.vti.springdatajpa.entity.JwtEntity.AuthRequest;
import com.vti.springdatajpa.entity.JwtEntity.UserInfo;
import com.vti.springdatajpa.service.JwtService.JwtService;
import com.vti.springdatajpa.service.JwtService.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserInfoService service;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/addNewUser")
    public String addNewUser (@RequestBody UserInfo userInfo) {
        return service.addUser(userInfo);
    }

    // Removed the role checks here as they are already managed in SecurityConfig
    @PostMapping("/generateToken")
    public String authenticateAndGetToken (@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );

        if (authentication.isAuthenticated()){
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("Invalid user request!");
        }
    }
}
