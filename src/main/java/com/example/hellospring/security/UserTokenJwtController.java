package com.example.hellospring.security;

import com.example.hellospring.role.User;
import com.example.hellospring.role.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/token")
@RequiredArgsConstructor
public class UserTokenJwtController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepo repo;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginVm loginVm) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginVm.getPassword(), loginVm.getUsername()));
        User user = repo.findByUsernameAndPassword(loginVm.getPassword(), loginVm.getUsername());
        if (user == null) {
            throw new UsernameNotFoundException("BU user mavjud emas");
        }
        String token = jwtTokenProvider.createToken(user.getUsername(), user.getRoles());
        Map<Object, Object> objectMap = new HashMap<>();
        objectMap.put("userName", user.getUsername());
        objectMap.put("token", token);
        return ResponseEntity.ok(objectMap);
    }
}
