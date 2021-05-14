package com.example.wmbeautystudio;

public class LoginHelperClass {
    private String logUserName;
    private String Password;

    public LoginHelperClass() {
    }

    public LoginHelperClass(String logUserName, String password) {
        this.logUserName = logUserName;
        Password = password;
    }

    public String getLogUserName() {
        return logUserName;
    }

    public void setLogUserName(String logUserName) {
        this.logUserName = logUserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
