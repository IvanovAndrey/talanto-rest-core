package com.kspt.app.models.person;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegistrationModel {
    protected String password;
    protected String name;
    protected String login;
    protected String status;
}
