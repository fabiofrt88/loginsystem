package co.develhope.LoginSystemSpring.auth.services;

import co.develhope.LoginSystemSpring.auth.entities.LoginDTO;
import co.develhope.LoginSystemSpring.auth.entities.LoginRTO;
import co.develhope.LoginSystemSpring.users.entities.User;
import co.develhope.LoginSystemSpring.users.repositories.UserRepository;

import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.auth0.jwt.JWT;

import java.time.LocalDateTime;



@Service
public class LoginService{

    public static final String JWT_SECRET = "7a2fce55-07fd-42a5-b098-ae1d1270c7b9";

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public LoginRTO login(LoginDTO loginDTO) {
        if(loginDTO == null) return null;
        User userFromDB = userRepository.findByEmail(loginDTO.getEmail());
        if(userFromDB == null || !userFromDB.getIsActive()) return null;
        boolean canLogin = this.canUserLogin(userFromDB, loginDTO.getPassword());
        if (!canLogin) return null;

        String JWT = getJWT(userFromDB);
        userFromDB.setJwtCreatedOn(LocalDateTime.now());
        userRepository.save(userFromDB);

        LoginRTO out = new LoginRTO();
        out.setJWT(JWT);
        out.setUser(userFromDB);

        return out;
    }

    public boolean canUserLogin(User user, String password) {
        return passwordEncoder.matches(password, user.getPassword());
    }
    public static String getJWT(User user) {
        return JWT.create().withClaim("id", user.getId()).sign(Algorithm.HMAC512(JWT_SECRET));
    }

}
