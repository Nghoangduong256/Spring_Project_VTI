package com.vti.springdatajpa.service.JwtService;

import com.vti.springdatajpa.entity.JwtEntity.UserInfo;
import com.vti.springdatajpa.repository.JwtRepo.UserInfoRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserInfoService implements UserDetailsService {

    private final UserInfoRepository repository;
    private final PasswordEncoder encoder;

    public UserInfoService(UserInfoRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    // Method to load user details by username (email)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch user from the database by email (username)
        UserInfo user = repository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + username));

        List<SimpleGrantedAuthority> authorities =
                List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole()));

        return new User(
                user.getEmail(),
                user.getPassword(),
                authorities
        );
    }

    // Add any additional methods for registering or managing users
    public String addUser(UserInfo userInfo) {
        // Encrypt password before saving
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "User added successfully!";
    }
}
