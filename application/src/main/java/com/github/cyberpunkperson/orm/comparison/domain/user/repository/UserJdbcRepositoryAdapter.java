package com.github.cyberpunkperson.orm.comparison.domain.user.repository;

import com.github.cyberpunkperson.orm.comparison.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
@RequiredArgsConstructor
class UserJdbcRepositoryAdapter implements UserRepository {

    private final UserJdbcRepository userRepository;


    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(UUID userId) {
        return userRepository.findById(userId);
    }

}
