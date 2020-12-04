package com.example.memento.model;

public class UserModel {
    String fullname;
    String password;

    public UserModel(String fullname, String password) {
        this.fullname = fullname;
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}