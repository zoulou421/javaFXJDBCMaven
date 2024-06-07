package com.formationkilo.javafxjdbcmaven.entities;
import java.time.LocalDate;
public class Appointment {
    private int id;
    private  LocalDate date;
    private String wording;
    private NursePerson nursePerson=new NursePerson();
    private Secretary secretary=new Secretary();


    public Appointment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getWording() {
        return wording;
    }

    public void setWording(String wording) {
        this.wording = wording;
    }

    public NursePerson getNursePerson() {
        return nursePerson;
    }

    public void setNursePerson(NursePerson nursePerson) {
        this.nursePerson = nursePerson;
    }

    public Secretary getSecretary() {
        return secretary;
    }

    public void setSecretary(Secretary secretary) {
        this.secretary = secretary;
    }
}
