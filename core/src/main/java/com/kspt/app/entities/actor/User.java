package com.kspt.app.entities.actor;

import com.kspt.app.entities.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Users")
@EqualsAndHashCode(callSuper = true)
public class User extends AbstractEntity {
    @Column(name = "name", nullable = false)
    protected String name;

    @Column(name = "login")
    private String login;

    @Column(name = "status", nullable = false)
    protected String status;

    @Column(name = "password")
    private String password;

    public User(@NotNull final String name,
                @NotNull final String login,
                @NotNull final String status,
                @NotNull final String password) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.status = status;

    }

}
