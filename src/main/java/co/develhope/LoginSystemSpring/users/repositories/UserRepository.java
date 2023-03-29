package co.develhope.LoginSystemSpring.users.repositories;

import co.develhope.LoginSystemSpring.users.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{
    User findByEmail(String email);
    User getByActivationCode(String activationCode);
    User findByPasswordResetCode(String resetPasswordCode);

}
