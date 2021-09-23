package com.example.realtimedatabase;

public class User {
    private String username;
    private String email;
    private String sexo;

    public User(){
    }

    public User(String username, String email, String sexo) {
        this.username = username;
        this.email = email;
        this.sexo = sexo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", sexo='" + sexo + '\'' +
                '}';
    }
}
