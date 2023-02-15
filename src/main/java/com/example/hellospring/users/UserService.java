package com.example.hellospring.users;

import com.example.hellospring.cor.ResponseStatus;
import com.example.hellospring.cor.Status;
import com.example.hellospring.cor.exception.ApiException;
import com.example.hellospring.cor.request.PageableRequest;
import com.example.hellospring.cor.request.PageableRequestUtil;
import com.example.hellospring.cor.request.SearchSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
//    private final com.example.hellospring.UserMapper userMapper;

    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ApiException(ResponseStatus.USER_NOT_FOUND));
    }

    public Page<User> getAll(PageableRequest pageable) {
        return userRepository.findAll(new SearchSpecification<>(pageable.getSearch()),
                PageableRequestUtil.toPageable(pageable));
    }

    public User create(UserPayload payload) {
        User user = new User();
        if (userRepository.existsByUserName(payload.getUserName())) {
            throw new ApiException(ResponseStatus.USER_ALREADY_EXIST);
        }
//        userMapper.toEntity(user, payload);
        user.setPassword(payload.getPassword());
        user.setFirstName(payload.getFirstName());
        user.setUserName(payload.getUserName());
        user.setLastName(payload.getLastName());
        user.setMiddleName(payload.getMiddleName());
        user.setPin(payload.getPin());
        user.setStatus(payload.getStatus());
        user.setRoleId(Math.toIntExact(payload.getRoleId()));
        return userRepository.save(user);
    }

    public User update(Long id, UserPayload payload) {
        User user = getById(id);
        if (userRepository.existsByUserNameAndIdNot(payload.getUserName(), id)) {
            throw new ApiException(ResponseStatus.USER_ALREADY_EXIST);
        }
        if (payload.getRoleId() == null) {
            throw new ApiException(ResponseStatus.USER_ALREADY_EXIST);
        }
//        userMapper.toEntity(user, payload);
        user.setPassword(payload.getPassword());
        user.setFirstName(payload.getFirstName());
        user.setUserName(payload.getUserName());
        user.setLastName(payload.getLastName());
        user.setMiddleName(payload.getMiddleName());
        user.setPin(payload.getPin());
        user.setStatus(payload.getStatus());
        user.setRoleId(Math.toIntExact(payload.getRoleId()));
        return userRepository.save(user);
    }

    public void delete(Long id) {
        User userEntity = getById(id);
        userEntity.setStatus(Status.DELETED);
        userRepository.save(userEntity);
    }

    public User updatePasswordUser(Long id, UserUpdatePassword userUpdatePassword) {
        User userEntity = getById(id);
        if (userUpdatePassword.getPassword().equals(userUpdatePassword.getRetryPassword()))
            throw new ApiException(ResponseStatus.PASSWORD_NOT_EQUALS);
        userEntity.setPassword(userUpdatePassword.getPassword());
        return userRepository.save(userEntity);

    }
}

