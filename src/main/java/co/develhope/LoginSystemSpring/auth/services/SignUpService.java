package co.develhope.LoginSystemSpring.auth.services;

import co.develhope.LoginSystemSpring.auth.entities.SignUpActivationDTO;
import co.develhope.LoginSystemSpring.auth.entities.SignUpDTO;
import co.develhope.LoginSystemSpring.notifications.services.MailNotificationService;
import co.develhope.LoginSystemSpring.users.entities.User;
import co.develhope.LoginSystemSpring.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class SignUpService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailNotificationService mailNotificationService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    public void signUp(SignUpDTO signUpDTO) throws Exception {
        User userInDB = userRepository.findByEmail(signUpDTO.getEmail());
        if(userInDB != null) throw new Exception("User already exists");
        User user = new User();
        user.setName(signUpDTO.getName());
        user.setEmail(signUpDTO.getEmail());
        user.setSurname(signUpDTO.getSurname());
        user.setPassword(passwordEncoder.encode(signUpDTO.getPassword()));
        user.setIsActive(false);
        user.setActivationCode(UUID.randomUUID().toString());

        mailNotificationService.sendActivationMail(user);
        userRepository.save(user);
    }

    public void activate(SignUpActivationDTO signUpActivationDTO) throws Exception {
        User user = userRepository.getByActivationCode(signUpActivationDTO.getActivationCode());
        if (user == null) throw new Exception("User not found");
        user.setIsActive(true);
        user.setActivationCode(null);
        userRepository.save(user);
    }
}
