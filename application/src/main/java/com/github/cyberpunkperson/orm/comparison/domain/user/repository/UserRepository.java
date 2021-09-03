package com.github.cyberpunkperson.orm.comparison.domain.user.repository;

import com.github.cyberpunkperson.orm.comparison.domain.user.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    User save(User user);

    List<User> findAll();

    Optional<User> findById(UUID userId);

}
