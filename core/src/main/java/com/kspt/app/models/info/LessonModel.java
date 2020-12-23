package com.kspt.app.models.info;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
public class LessonModel {
    private Long id;
    private Long id_teacher;
    private String status;
    private String theme;
    private String commentary;
    private Date date_of_lesson;
    private String[] students;
}
