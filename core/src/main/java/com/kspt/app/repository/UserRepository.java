package com.kspt.app.repository;

import com.kspt.app.entities.actor.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JPARepository<User> {
    Optional<User> findByLogin(@NotNull final String login);
}
