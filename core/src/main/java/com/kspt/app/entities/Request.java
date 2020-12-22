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
@Table(name="requests")
public class Request extends AbstractEntity {
    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "status")
    private String status;

    @Column(name = "dates")
    private String dates;

    @Column(name = "date_of_send")
    private Date dateOfSend;

    public Request(final Long idUser, final String status, final String dates, Date dateOfSend) {
        this.idUser = idUser;
        this.status = status;
        this.dates = dates;
        this.dateOfSend = dateOfSend;
    }
}
