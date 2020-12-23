package com.kspt.app.service;

import com.kspt.app.entities.ClientsOnLessons;
import com.kspt.app.entities.Complaint;
import com.kspt.app.entities.Lesson;
import com.kspt.app.entities.Notification;
import com.kspt.app.entities.Request;
import com.kspt.app.entities.actor.User;
import com.kspt.app.models.info.ComplaintModel;
import com.kspt.app.models.info.LessonModel;
import com.kspt.app.models.info.NotificationModel;
import com.kspt.app.models.info.RequestModel;
import com.kspt.app.models.person.RegistrationModel;
import com.kspt.app.models.person.SignInModel;
import com.kspt.app.models.person.SignInResponse;
import com.kspt.app.models.response.ApiResult;
import com.kspt.app.models.response.ResponseOrMessage;
import com.kspt.app.models.person.IdAndPersonTypeModel;
import com.kspt.app.repository.ClientsOnLessonsRepository;
import com.kspt.app.repository.ComplaintRepository;
import com.kspt.app.repository.LessonRepository;
import com.kspt.app.repository.NotificationRepository;
import com.kspt.app.repository.RequestRepository;
import com.kspt.app.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;
    private ComplaintRepository complaintRepository;
    private RequestRepository requestRepository;
    private ClientsOnLessonsRepository clientsOnLessonsRepository;
    private NotificationRepository notificationRepository;
    private LessonRepository lessonRepository;

    UserService(UserRepository userRepository,
                ComplaintRepository complaintRepository,
                RequestRepository requestRepository,
                NotificationRepository notificationRepository,
                LessonRepository lessonRepository,
                ClientsOnLessonsRepository clientsOnLessonsRepository) {
        this.userRepository = userRepository;
        this.complaintRepository = complaintRepository;
        this.requestRepository = requestRepository;
        this.clientsOnLessonsRepository = clientsOnLessonsRepository;
        this.notificationRepository = notificationRepository;
        this.lessonRepository = lessonRepository;
    }

    public ResponseOrMessage<Boolean> signUp(RegistrationModel model) {
        if ( model.getLogin() == null) {
            return new ResponseOrMessage<>("Login already exist");
        }
                    User user = new User(model.getName(),
                            model.getLogin(),
                            model.getStatus(),
                            model.getPassword());
                    userRepository.save(user);
                    return new ResponseOrMessage<>(true);
    }

    public ResponseOrMessage<SignInResponse> signIn(SignInModel model) {
        if (!model.getLogin().isEmpty()) {
            final User user = userRepository.findByLogin(model.getLogin()).orElse(null);
            if (user != null) {
                if(model.getPassword().equals(user.getPassword().replaceAll(" ", ""))){
                SignInResponse response = new SignInResponse();
                response.setUserStatus(user.getStatus());
                response.setPersonId(user.id);
                response.setPassword(user.getPassword());
                model.setStatus(user.getStatus());
                return new ResponseOrMessage<>(response);
                } else {
                    return new ResponseOrMessage<>("Incorrect password");
                }
            } else return new ResponseOrMessage<>("Incorrect username");
        } else return new ResponseOrMessage<>("Wrong parameter");
    }

    public ResponseOrMessage<User> getPersonById(IdAndPersonTypeModel model) {
        User user = userRepository.findById(model.getPersonId()).orElse(null);
        if (user == null) {
            return new ResponseOrMessage<>("Person not found");
        }
        return new ResponseOrMessage<>(user);
    }

    public ResponseOrMessage<Complaint> setComplaint(ComplaintModel model) {
        final Complaint complaint = new Complaint(model.getId_incedent(),
                model.getTheme(),
                model.getText());
        ClientsOnLessons exist = clientsOnLessonsRepository.findByIdClientAndIdLesson(model.getId(),
                model.getId_incedent())
                .orElse(null);
        if (exist != null) {
                complaintRepository.save(complaint);
        } else return new ResponseOrMessage<>("Вас не было на этом уроке");
        return new ResponseOrMessage<>("Жалоба была добавлена");
    }

    public ResponseOrMessage<Request> setRequest(RequestModel model) {
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        Request exist = requestRepository.findByIdUser(model.getId()).orElse(null);;
        if (exist == null) {
            final Request request = new Request(model.getId(),
                    "NEW",
                    model.getDaysArr(),
                    date);
            requestRepository.save(request);
            return new ResponseOrMessage<>("Запрос был добавлен");
        } else {
            exist.setStatus("NEW");
            exist.setDateOfSend(date);
            exist.setDates(model.getDaysArr());
            requestRepository.save(exist);
            return new ResponseOrMessage<>("Запрос был обновлен");
        }
    }

    public List<Notification> getNotifications(Long userId) {
        return new ArrayList<>(notificationRepository.findAllByIdTo(userId));
    }

    public List<Lesson> getLessons() {
        return new ArrayList<>(lessonRepository.findAll());
    }

    public Notification getSingleNotification(Long id) {
        return notificationRepository.findById(id).orElse(null);
    }

    public List<User> getUsers() {
        return new ArrayList<>(userRepository.findAll());
    }

    public ResponseOrMessage<Notification> setNotification(NotificationModel model) {
        Notification notification = new Notification(
                model.getId_from(),
                model.getId_to(),
                model.getStatus(),
                model.getTheme(),
                model.getText()
        );
        if(userRepository.findById(model.getId_to()).orElse(null) == null) {
            return new ResponseOrMessage<>("Пользователя с таким id не существует");
        } else {
            notificationRepository.save(notification);
            return new ResponseOrMessage<>("Уведомление успешно отправлено");
        }
    }

    public ResponseOrMessage<Lesson> setLesson(LessonModel model) {
        if (model.getStudents().length == 0){
            return new ResponseOrMessage<>("Необходимо ввести хотя бы одного ученика");
        }
        User teacher = userRepository.findById(model.getId_teacher()).orElse(null);
        if (teacher == null) {
            return new ResponseOrMessage<>("Учителя с таким id не существует");
        }
        if (!teacher.getStatus().equals("teacher")) {
            return new ResponseOrMessage<>("Пользователь с таким id не является учителем");
        }
        for (int i = 0; i < model.getStudents().length; i++) {
            User student = userRepository.findById(Long.parseLong(model.getStudents()[i])).orElse(null);
            if (student == null) {
                return new ResponseOrMessage<>("Ученика с id = " + model.getStudents()[i] + " не существует");
            }
            if (!student.getStatus().equals("client")) {
                return new ResponseOrMessage<>("Ученик с id = " + model.getStudents()[i] + " не явлется клиентом");
            }

        }
        Lesson lesson = lessonRepository.findByIdTeacherAndAndDateOfLesson(model.getId_teacher(),
                model.getDate_of_lesson()).orElse(null);
        if (lesson == null) {
            lesson = new Lesson(
                    model.getId_teacher(),
                    model.getTheme(),
                    model.getCommentary(),
                    model.getStatus(),
                    model.getDate_of_lesson()
            );
            lessonRepository.save(lesson);
            lesson = lessonRepository.findByIdTeacherAndAndDateOfLesson(model.getId_teacher(),
                    model.getDate_of_lesson()).orElse(null);
            if (lesson != null) {
                for (int i = 0; i < model.getStudents().length; i++) {
                    ClientsOnLessons clientsOnLessons = new ClientsOnLessons(
                            Long.parseLong(model.getStudents()[i]),
                            lesson.getId(),
                            "Планирует посетить",
                            ""
                    );
                    clientsOnLessonsRepository.save(clientsOnLessons);
                }
                return new ResponseOrMessage<>("Урок был успешно создан");
            } else {
                return new ResponseOrMessage<>("Ошибка при создании урока");
            }
        } else {
            return new ResponseOrMessage<>("У этого преподавателя уже есть урока в эту дату");
        }
    }
}
