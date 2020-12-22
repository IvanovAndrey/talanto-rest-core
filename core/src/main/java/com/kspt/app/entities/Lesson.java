package com.kspt.app.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name="lessons")
public class Lesson extends AbstractEntity {
    @Column(name = "id_teacher")
    private Long idTeacher;

    @Column(name = "theme")
    private String theme;

    @Column(name = "commentary")
    private String commentary;

    @Column(name = "status")
    private String status;

    @Column(name = "date_of_lesson")
    private Date dateOfLesson;

    public Lesson(final Long idTeacher,
                  final String theme,
                  final String commentary,
                  final String status,
                  Date dateOfLesson) {
        this.idTeacher = idTeacher;
        this.status = status;
        this.theme = theme;
        this.commentary = commentary;
        this.dateOfLesson = dateOfLesson;
    }
}
