package co.develhope.LoginSystemSpring.auth.entities;

public class SignUpActivationDTO{
    private String activationCode;

    public SignUpActivationDTO(){}

    public SignUpActivationDTO(String activationCode) {
        this.activationCode = activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getActivationCode() {
        return activationCode;
    }

}
