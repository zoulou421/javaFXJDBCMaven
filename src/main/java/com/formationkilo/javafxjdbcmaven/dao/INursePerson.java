package com.formationkilo.javafxjdbcmaven.dao;

import com.formationkilo.javafxjdbcmaven.entities.Appointment;
import com.formationkilo.javafxjdbcmaven.entities.NursePerson;

import java.util.List;

public interface INursePerson {
    public List<Appointment> getAppointmentByNurse(int id);
    public NursePerson get(int id);
    public int add(NursePerson nurse);
    public List<NursePerson>getAllNurse();

    public NursePerson delete(int id);
}
