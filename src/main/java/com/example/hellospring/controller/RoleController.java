package com.example.hellospring.controller;

import com.example.hellospring.cor.Permission;
import com.example.hellospring.cor.SuccessfulResponse;
import com.example.hellospring.cor.constant.CabinetType;
import com.example.hellospring.cor.request.PageableRequest;
import com.example.hellospring.cor.response.SuccessDataIterable;
import com.example.hellospring.roles.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/v1/oauth/role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;
//    private final RoleMapper roleMapper;
    private final RoleRepository roleRepository;

    @PostMapping("/pageable")
    public SuccessDataIterable<RoleResponse> pageable(@RequestBody PageableRequest pageableRequest) {
        log.debug("role pageable {}", pageableRequest);
        return new SuccessDataIterable<>(roleService.getAll(pageableRequest).map(RoleResponse::new));
    }

    @GetMapping("/{id}")
    public SuccessfulResponse<RoleResponse> getById(@PathVariable Integer id) {
        log.debug("role get by id {}", id);
        return new SuccessfulResponse<>(new RoleResponse(roleService.findById(id)));
    }

    @GetMapping
    public SuccessfulResponse<RoleResponse> getAll() {
        return new SuccessfulResponse(roleRepository.findAll());
    }

    @PostMapping
    public SuccessfulResponse<RoleResponse> create(@RequestBody RolePayload payload) {
        log.debug("role create {}", payload);
        return new SuccessfulResponse<>(new RoleResponse(roleService.create(payload)));
    }

    @PutMapping("/{id}")
    public SuccessfulResponse<RoleResponse> update(@PathVariable Integer id,
                                                   @RequestBody RolePayload payload) {
        log.debug("role update {} {} ", id, payload);
        return new SuccessfulResponse<>(new RoleResponse(roleService.update(id, payload)));
    }

    @GetMapping("/permission")
    public List<PermissionResponse> getRolePermission(@RequestParam(defaultValue = "ADMIN_CABINET")
                                                              CabinetType cabinet_type) {
        log.debug("role permission {}", cabinet_type);
        return Arrays.stream(Permission.values()).
                filter(permission -> permission.getCabinetType().equals(cabinet_type)).
                map(PermissionResponse::new).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public SuccessfulResponse<Void> delete(@PathVariable Integer id) {
        log.debug("role delete {} ", id);
        roleService.delete(id);
        return new SuccessfulResponse<>();
    }
}
