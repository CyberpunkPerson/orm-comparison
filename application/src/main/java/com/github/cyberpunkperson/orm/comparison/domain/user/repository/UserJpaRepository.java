package com.github.cyberpunkperson.orm.comparison.domain.user.repository;

import com.github.cyberpunkperson.orm.comparison.domain.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

interface UserJpaRepository extends UserRepository, CrudRepository<User, UUID> {
}
