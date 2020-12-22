package com.kspt.app.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name="clients_on_lessons")
public class ClientsOnLessons extends AbstractEntity {
    @Column(name = "id_client")
    private Long idClient;

    @Column(name = "id_lesson")
    private Long idLesson;

    @Column(name = "status")
    private String status;

    @Column(name = "commentary")
    private String commentary;

    public ClientsOnLessons(final Long idClient,
                     final Long idLesson,
                     final String status,
                     final String commentary) {
        this.idClient = idClient;
        this.idLesson = idLesson;
        this.status = status;
        this.commentary = commentary;
    }
}
