package com.kspt.app.models.person;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignInModel {
    protected String login;
    protected String password;
    protected String status;
}
