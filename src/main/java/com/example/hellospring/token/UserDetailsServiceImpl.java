package com.example.hellospring.token;

import com.example.hellospring.cor.Status;
import com.example.hellospring.roles.RoleService;
import com.example.hellospring.users.UserEntity;
import com.example.hellospring.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleService elasticRoleService;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository, RoleService elasticRoleService) {
        this.userRepository = userRepository;
        this.elasticRoleService = elasticRoleService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userCheck = userRepository.findByUserNameAndStatus(username, Status.ACTIVE);
        if (userCheck.isEmpty()) {
            String msg = "User [" + username + "] not found.";
            throw new UsernameNotFoundException(msg);
        }
        UserEntity user = userCheck.get();
        Collection<GrantedAuthority> permissions = new ArrayList<>();
        if (user.getRoleId() != null)
            elasticRoleService.findOptionalById(user.getRoleId()).ifPresent(elasticRole -> elasticRole.getPermissions().forEach(permission -> permissions.add(new SimpleGrantedAuthority(permission.name()))));

        return new UserDetailsImpl(user, permissions);
    }

}