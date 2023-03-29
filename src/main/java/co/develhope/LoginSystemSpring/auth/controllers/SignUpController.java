package co.develhope.LoginSystemSpring.auth.controllers;

import co.develhope.LoginSystemSpring.auth.entities.SignUpActivationDTO;
import co.develhope.LoginSystemSpring.auth.entities.SignUpDTO;
import co.develhope.LoginSystemSpring.auth.services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class SignUpController{
    @Autowired
    private SignUpService signUpService;

    @PostMapping("/sign-up")
    public void signUp(@RequestBody SignUpDTO signUpDTO) throws Exception {
        signUpService.signUp(signUpDTO);
    }

    @PostMapping("/sign-up/activation")
    public void signUpActivation(@RequestBody SignUpActivationDTO signUpActivationDTO) throws Exception {
        signUpService.activate(signUpActivationDTO);
    }
}
