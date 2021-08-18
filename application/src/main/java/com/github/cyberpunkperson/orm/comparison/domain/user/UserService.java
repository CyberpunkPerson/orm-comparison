package com.github.cyberpunkperson.orm.comparison.domain.user;

import com.github.cyberpunkperson.orm.comparison.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
class UserService {

    private final UserRepository userRepository;


    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(UUID userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User with such id was not found"));
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
