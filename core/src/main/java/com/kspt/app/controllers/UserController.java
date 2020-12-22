package com.kspt.app.controllers;

import com.kspt.app.entities.Complaint;
import com.kspt.app.entities.Lesson;
import com.kspt.app.entities.Notification;
import com.kspt.app.entities.Request;
import com.kspt.app.entities.actor.User;
import com.kspt.app.models.info.ComplaintModel;
import com.kspt.app.models.info.RequestModel;
import com.kspt.app.models.person.IdAndPersonTypeModel;
import com.kspt.app.models.response.ResponseOrMessage;
import com.kspt.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/getUserById")
    public ResponseOrMessage<User> getUserById(@RequestBody IdAndPersonTypeModel model) {
        return service.getPersonById(model);
    }

    @PostMapping("/setComplaint")
    public ResponseOrMessage<Complaint> setComplaint(@RequestBody ComplaintModel complaint) {
        return service.setComplaint(complaint);
    }

    @PostMapping("/setRequest")
    public ResponseOrMessage<Request> setRequest(@RequestBody RequestModel request) {
        return service.setRequest(request);
    }


    @GetMapping("/getNotifications/{userId}")
    public List<Notification> getNotifications(@PathVariable Long userId) {
        return service.getNotifications(userId);
    }

    @GetMapping("/getSingleNotification/{id}")
    public Notification getSingleNotification(@PathVariable Long id) {
        return service.getSingleNotification(id);
    }

    @GetMapping("/getLessons")
    public List<Lesson> getLessonss() {
        return service.getLessons();
    }
}
