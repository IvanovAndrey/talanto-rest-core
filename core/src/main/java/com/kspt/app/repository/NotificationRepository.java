package com.kspt.app.repository;

import com.kspt.app.entities.Notification;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotificationRepository extends JPARepository<Notification> {
    List<Notification> findAllByIdTo (@NotNull final Long id_user);
}
