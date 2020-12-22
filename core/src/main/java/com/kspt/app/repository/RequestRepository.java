package com.kspt.app.repository;

import com.kspt.app.entities.ClientsOnLessons;
import com.kspt.app.entities.Request;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RequestRepository extends JPARepository<Request>  {
    Optional<Request> findByIdUser (@NotNull final Long id_user);
}
