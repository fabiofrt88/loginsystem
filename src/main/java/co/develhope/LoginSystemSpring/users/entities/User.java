package co.develhope.LoginSystemSpring.users.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id", nullable = false)
    private Long id;

    private String name;
    private String surname;

    @Column(unique = true)
    private String email;
    private String password;
    private LocalDateTime jwtCreatedOn;
    private boolean isActive;

    @Column(length = 36)
    private String activationCode;

    @Column(length = 36)
    private String passwordResetCode;

    public User(){}

    public User(long id, String name, String surname, String email, String password, LocalDateTime jwtCreatedOn, boolean isActive, String activationCode, String passwordResetCode) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.jwtCreatedOn = jwtCreatedOn;
        this.isActive = isActive;
        this.activationCode = activationCode;
        this.passwordResetCode = passwordResetCode;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public LocalDateTime getJwtCreatedOn(){
        return jwtCreatedOn;
    }

    public void setJwtCreatedOn(LocalDateTime jwtCreatedOn){
        this.jwtCreatedOn = jwtCreatedOn;
    }

    public boolean getIsActive(){
        return isActive;
    }

    public void setIsActive(boolean active){
        isActive = active;
    }

    public String getActivationCode(){
        return activationCode;
    }

    public void setActivationCode(String activationCode){
        this.activationCode = activationCode;
    }

    public String getPasswordResetCode(){
        return passwordResetCode;
    }

    public void setPasswordResetCode(String passwordResetCode){
        this.passwordResetCode = passwordResetCode;
    }

}