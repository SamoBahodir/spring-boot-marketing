package com.example.hellospring.roles;

import com.example.hellospring.cor.ResponseStatus;
import com.example.hellospring.cor.Status;
import com.example.hellospring.cor.exception.ApiException;
import com.example.hellospring.cor.request.PageableRequest;
import com.example.hellospring.cor.request.PageableRequestUtil;
import com.example.hellospring.cor.request.SearchSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;
//    private final RoleMapper roleMapper;

    public Role findById(Integer id) {
        return roleRepository.findById(id).filter(role -> role.getStatus() != Status.DELETED).orElseThrow(() -> new ApiException(ResponseStatus.ROLE_NOT_FOUND));
    }

    public Optional<Role> findOptionalById(Integer id) {
        return roleRepository.findById(id);
    }

    public Page<Role> getAll(PageableRequest pageable) {
        return roleRepository.findAll(new SearchSpecification<>(pageable.getSearch()),
                PageableRequestUtil.toPageable(pageable));
    }

    public Role create(RolePayload payload) {
        Role role = new Role();
//        roleMapper.toEntity(role, payload);
        role.setPermissions(payload.getPermissions());
        role.getName().setEn(payload.getNameEn());
        role.getName().setOz(payload.getNameOz());
        role.getName().setRu(payload.getNameRu());
        role.getName().setUz(payload.getNameUz());
        role.setStatus(payload.getStatus());
        return roleRepository.save(role);
    }

    public Role update(Integer id, RolePayload payload) {
        Role role = findById(id);
//        roleMapper.toEntity(role, payload);
        role.setPermissions(payload.getPermissions());
        role.getName().setEn(payload.getNameEn());
        role.getName().setOz(payload.getNameOz());
        role.getName().setRu(payload.getNameRu());
        role.getName().setUz(payload.getNameUz());
        role.setStatus(payload.getStatus());
        return roleRepository.save(role);
    }

    public void delete(Integer id) {
        Role role = findById(id);
        role.setStatus(Status.DELETED);
        roleRepository.save(role);
    }

}
