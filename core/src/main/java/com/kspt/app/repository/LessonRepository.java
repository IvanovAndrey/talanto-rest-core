package com.kspt.app.repository;

import com.kspt.app.entities.Lesson;
import com.kspt.app.entities.Notification;
import com.kspt.app.entities.Request;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface LessonRepository extends JPARepository<Lesson> {
    Optional<Lesson> findByIdTeacherAndAndDateOfLesson (@NotNull final Long id_teacher, Date date_of_lesson);
}
