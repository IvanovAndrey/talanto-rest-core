package com.kspt.app.models.person;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
public class SignInResponse {
    Long personId;
    String password;
    String userStatus;
}
