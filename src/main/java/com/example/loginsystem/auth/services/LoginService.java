package com.example.loginsystem.auth.services;

import com.example.loginsystem.auth.entities.LoginDTO;
import com.example.loginsystem.auth.entities.LoginRTO;
import com.example.loginsystem.user.entities.User;
import com.example.loginsystem.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;


    public LoginRTO login(LoginDTO loginDTO) {
        if(loginDTO == null) return null;
        User userFromDb = userRepository.findByEmail(loginDTO.getEmail());
        if(userFromDb == null || !userFromDb.isActive()) return null;

        boolean canLogin = this.canUserLogin(userFromDb, loginDTO.getPassword());
        if(!canLogin) return null;

        String JWT = getJWT(userFromDb);
        userFromDb.setJwtCreatedOn(LocalDateTime.now());
        userRepository.save(userFromDb);

        LoginRTO out = new LoginRTO();
        out.setJWT(JWT);
        out.setUser(userFromDb);
        return out;
    }

    public static boolean canUserLogin(User user, String password){
        return user.getPassword().equals(password);
    }

    public static String getJWT(User user){
        return "---------";
    };
}
