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
@Table(name="notifications")
public class Notification extends AbstractEntity {
    @Column(name = "id_from")
    private Long idFrom;

    @Column(name = "id_to")
    private Long idTo;

    @Column(name = "status")
    private String status;

    @Column(name = "theme")
    private String theme;

    @Column(name = "text")
    private String text;

    public Notification(final Long idFrom, final Long idTo, final String status, final String theme, final String text) {
        this.idFrom = idFrom;
        this.idTo = idTo;
        this.status = status;
        this.theme = theme;
        this.text = text;
    }
}
