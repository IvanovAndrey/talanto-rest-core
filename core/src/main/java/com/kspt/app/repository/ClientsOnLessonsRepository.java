package com.kspt.app.repository;

import com.kspt.app.entities.ClientsOnLessons;
import com.kspt.app.entities.actor.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientsOnLessonsRepository extends JPARepository<ClientsOnLessons>  {
    Optional<ClientsOnLessons> findByIdClientAndIdLesson (@NotNull final Long id_client, @NotNull final Long id_lesson);
}
