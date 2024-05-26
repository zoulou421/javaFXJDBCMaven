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
}
