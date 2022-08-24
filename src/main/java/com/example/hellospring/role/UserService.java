package com.example.hellospring.role;

import com.example.hellospring.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final JwtTokenProvider passwordEncoder;

    public User create(User user){
        user.setPassword(passwordEncoder.passwordEncoder().encode(user.getPassword()));
        return userRepo.save(user);
    }
    public boolean checkUserName(String username){
        return userRepo.existsByUsername(username);
    }
}
