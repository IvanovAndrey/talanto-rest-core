package com.kspt.app.entities;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Credentials")
@EqualsAndHashCode(callSuper = true)
public final class Credentials extends AbstractEntity {

    @Column(unique = true, name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    public Credentials(@NotNull final String email,
                       @NotNull final String password) {
        this.email = email;
        this.password = password;
        this.username = email.split("@")[0];
    }
}
