package com.example.loginsystem.auth.entities;


public class RestorePasswordDTO {

    private String newPassword;
    private String resetPasswordCode;

    public RestorePasswordDTO(String newPassword, String resetPasswordCode) {
        this.newPassword = newPassword;
        this.resetPasswordCode = resetPasswordCode;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getResetPasswordCode() {
        return resetPasswordCode;
    }

    public void setResetPasswordCode(String resetPasswordCode) {
        this.resetPasswordCode = resetPasswordCode;
    }
}
