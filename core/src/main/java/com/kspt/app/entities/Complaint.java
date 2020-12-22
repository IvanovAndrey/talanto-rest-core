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
@Table(name="complaints")
public class Complaint extends AbstractEntity {
    @Column(name = "id_incedent")
    private Long idIncedent;

    @Column(name = "theme")
    private String theme;

    @Column(name = "text")
    private String text;

    public Complaint(final Long idIncedent, final String theme, final String text) {
            this.idIncedent = idIncedent;
            this.theme = theme;
            this.text = text;
        }
}
