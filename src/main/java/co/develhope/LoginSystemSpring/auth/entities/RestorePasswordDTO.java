package co.develhope.LoginSystemSpring.auth.entities;

public class RestorePasswordDTO{
    private String newPassword;
    private String resetPasswordCode;

    public RestorePasswordDTO(){}

    public RestorePasswordDTO(String newPassword, String resetPasswordCode) {
        this.newPassword = newPassword;
        this.resetPasswordCode = resetPasswordCode;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setResetPasswordCode(String resetPasswordCode) {
        this.resetPasswordCode = resetPasswordCode;
    }

    public String getResetPasswordCode() {
        return resetPasswordCode;
    }

}
