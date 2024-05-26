package com.formationkilo.javafxjdbcmaven.dao;

import com.formationkilo.javafxjdbcmaven.entities.Appointment;

import java.util.List;

public interface IAppointment {
    public int add(Appointment ap);
    public int update(Appointment ap);
    public int delete(int id);
    public List<Appointment>getAll();
}
