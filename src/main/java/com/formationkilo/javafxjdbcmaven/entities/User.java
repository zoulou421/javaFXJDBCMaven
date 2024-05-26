package com.formationkilo.javafxjdbcmaven.entities;

public class User {
    private int id;
    private String email;
    private String password;
    private NursePerson nurse;
    private Secretary sec;
    public User(){

    }
    public User(int id, String email, String password, NursePerson nurse, Secretary sec) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nurse = nurse;
        this.sec = sec;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public NursePerson getNurse() {
        return nurse;
    }

    public void setNurse(NursePerson nurse) {
        this.nurse = nurse;
    }

    public Secretary getSec() {
        return sec;
    }

    public void setSec(Secretary sec) {
        this.sec = sec;
    }
}
