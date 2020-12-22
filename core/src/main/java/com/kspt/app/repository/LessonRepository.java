package com.kspt.app.repository;

import com.kspt.app.entities.Lesson;
import com.kspt.app.entities.Notification;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LessonRepository extends JPARepository<Lesson> {
}
