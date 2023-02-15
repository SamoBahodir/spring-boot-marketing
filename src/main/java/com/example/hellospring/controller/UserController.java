package com.example.hellospring.controller;

import com.example.hellospring.cor.Permission;
import com.example.hellospring.cor.SuccessfulResponse;
import com.example.hellospring.cor.constant.CabinetType;
import com.example.hellospring.cor.request.PageableRequest;
import com.example.hellospring.cor.response.SuccessDataIterable;
import com.example.hellospring.roles.PermissionResponse;
import com.example.hellospring.users.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/v1/oauth/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
//    private final UserMapper userMapper;

    @GetMapping("/{id}")
    public SuccessfulResponse<UserSingleResponse> getById(@PathVariable Long id) {
        log.debug("get by id {}", id);
        return new SuccessfulResponse<>(new UserSingleResponse(userService.getById(id)));
    }

    @PostMapping("/pageable")
    public SuccessDataIterable<UserListResponse> getList(@RequestBody PageableRequest pageableRequest) {
        log.debug("pageable request {}", pageableRequest);
        return new SuccessDataIterable<>(userService.getAll(pageableRequest).map(UserListResponse::new));
    }

    @PostMapping
    public SuccessfulResponse<UserSingleResponse> create(@RequestBody UserPayload payload) {
        log.debug("users create {}", payload);
        return new SuccessfulResponse<>(new UserSingleResponse(userService.create(payload)));
    }

    @PutMapping("/{id}")
    public SuccessfulResponse<UserSingleResponse> update(@PathVariable Long id,
                                                         @RequestBody UserPayload payload) {
        log.debug("users update {} {} ", id, payload);
        return new SuccessfulResponse<>(new UserSingleResponse(userService.update(id, payload)));
    }

    @GetMapping("/permission")
    public List<PermissionResponse> getRolePermission(@RequestParam(defaultValue = "ADMIN_CABINET") CabinetType cabinet_type) {
        log.debug("users permission {}", cabinet_type);
        return Arrays.stream(Permission.values()).
                filter(permission -> permission.getCabinetType().equals(cabinet_type)).
                map(PermissionResponse::new).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public SuccessfulResponse<Void> delete(@PathVariable Long id) {
        log.debug("users delete {}  ", id);
        userService.delete(id);
        return new SuccessfulResponse<>();
    }

    @PutMapping("/updatePassword/{id}")
    public SuccessfulResponse<UserUpdatePasswordResponse> updatePassword(@PathVariable Long id,
                                                                         @RequestBody UserUpdatePassword userUpdatePassword) {
        log.debug("UserUpdatePassword {} {}", id, userUpdatePassword);
        return new SuccessfulResponse<>(new UserUpdatePasswordResponse(userService.updatePasswordUser(id, userUpdatePassword)));

    }
}
