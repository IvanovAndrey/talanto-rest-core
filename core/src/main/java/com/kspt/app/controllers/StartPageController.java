package com.kspt.app.controllers;

import com.kspt.app.models.person.RegistrationModel;
import com.kspt.app.models.person.SignInModel;
import com.kspt.app.models.person.SignInResponse;
import com.kspt.app.models.response.ResponseOrMessage;
import com.kspt.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartPageController {
    @Autowired
    private UserService service;

    @PostMapping("/sign-up")
    public ResponseOrMessage<Boolean> signUp(@RequestBody RegistrationModel model) {
        return service.signUp(model);
    }

    @PostMapping("/sign-in")
    public ResponseOrMessage<SignInResponse> signIn(@RequestBody SignInModel model) {
        return service.signIn(model);
    }

}
