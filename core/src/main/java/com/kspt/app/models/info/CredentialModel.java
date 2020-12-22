package com.kspt.app.models.info;

import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public class CredentialModel {
    private String email;
    private String password;
}
