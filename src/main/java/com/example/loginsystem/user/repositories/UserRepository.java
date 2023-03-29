package com.example.loginsystem.user.repositories;

import com.example.loginsystem.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {


    User findByEmail(String email);

    User getByActivationCode(String activationCode);
}
