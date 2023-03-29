package com.example.loginsystem.auth.services;

import com.example.loginsystem.auth.entities.SignupActivationDTO;
import com.example.loginsystem.auth.entities.SignupDTO;
import com.example.loginsystem.notification.services.MailNotificationService;
import com.example.loginsystem.user.entities.User;
import com.example.loginsystem.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

@Service
public class SignupService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailNotificationService mailNotificationService;


    public User signup(SignupDTO signupDTO) throws IOException {
        User user = new User();
        user.setName(signupDTO.getName());
        user.setSurname(signupDTO.getSurname());
        user.setEmail(signupDTO.getEmail());
        user.setActive(false);
        user.setActivationCode(UUID.randomUUID().toString());

        mailNotificationService.sendActivationEmail(user);
        return userRepository.saveAndFlush(user);
    }

    public User activate(SignupActivationDTO signupActivationDTO) throws Exception {

        User user = userRepository.getByActivationCode(signupActivationDTO.getActivationCode());
        if(user == null) throw new Exception("User not found");
        user.setActive(true);
        user.setActivationCode(null);
        return userRepository.saveAndFlush(user);

    }
}
