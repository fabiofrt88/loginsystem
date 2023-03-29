package co.develhope.LoginSystemSpring.auth.entities;

import co.develhope.LoginSystemSpring.users.entities.User;

public class LoginRTO{
    private User user;
    private String JWT;

    public LoginRTO(){}

    public LoginRTO(User user, String JWT) {
        this.user = user;
        this.JWT = JWT;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setJWT(String JWT) {
        this.JWT = JWT;
    }

    public String getJWT() {
        return JWT;
    }

}
