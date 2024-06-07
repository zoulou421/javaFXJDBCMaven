package com.formationkilo.javafxjdbcmaven.dao;

import com.formationkilo.javafxjdbcmaven.entities.Appointment;

import java.util.List;

public class AppointmentImpl implements IAppointment{
    private DB db=new DB();
    @Override
    public int add(Appointment ap) {
        String sql="INSERT INTO appointment VALUES(NULL, ?, ?, ?,?)";
        int ok=0;
        try {
            db.initPrepare(sql);
            db.getPreparedStatement().setString(1,ap.getDate().toString());
            db.getPreparedStatement().setString(2,ap.getWording());
            db.getPreparedStatement().setInt(3,ap.getNursePerson().getId());
            db.getPreparedStatement().setInt(4,ap.getSecretary().getId());
            ok=db.executeMaj();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return ok;
    }

    @Override
    public int update(Appointment ap) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public List<Appointment> getAll() {
        return null;
    }
}
