package com.github.cyberpunkperson.orm.comparison.domain.user;

import com.github.cyberpunkperson.orm.comparison.controller.UsersApiDelegate;
import com.github.cyberpunkperson.orm.comparison.model.GetUserResponse;
import com.github.cyberpunkperson.orm.comparison.model.GetUsersResponse;
import com.github.cyberpunkperson.orm.comparison.model.PutUserRequest;
import com.github.cyberpunkperson.orm.comparison.model.PutUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.ok;

@Component
@RequiredArgsConstructor
class UserController implements UsersApiDelegate {

    private final UserService userService;

    private final UserMapper userMapper;


    @Override
    public ResponseEntity<GetUsersResponse> getUsers() {
        return ok(new GetUsersResponse()
                .items(userService.findAll().stream()
                        .map(user -> userMapper.userToUserProjection(user))
                        .collect(toList())));
    }

    @Override
    public ResponseEntity<GetUserResponse> getUserById(UUID userId) {
        User foundUser = userService.findById(userId);
        return ok(new GetUserResponse().payload(userMapper.userToUserProjection(foundUser)));
    }

    @Override
    public ResponseEntity<PutUserResponse> putUser(PutUserRequest putUserRequest) {
        User savedUser = userService.save(userMapper.userProjectionToUser(putUserRequest.getPayload()));
        return ok(new PutUserResponse().payload(userMapper.userToUserProjection(savedUser)));
    }
}
