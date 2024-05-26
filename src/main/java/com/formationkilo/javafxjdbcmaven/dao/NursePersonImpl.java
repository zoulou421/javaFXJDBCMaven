package com.formationkilo.javafxjdbcmaven.dao;

import com.formationkilo.javafxjdbcmaven.entities.Appointment;
import com.formationkilo.javafxjdbcmaven.entities.NursePerson;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class NursePersonImpl implements INursePerson{

    private DB db=new DB();
    @Override
    public List<Appointment> getAppointmentByNurse(int id) {
        return null;
    }

    @Override
    public NursePerson get(int id) {
        String sql="SELECT * FROM nurseperson WHERE id= ?";
        NursePerson nurse=null;
        try {
            db.initPrepare(sql);
            db.getPreparedStatement().setInt(1,id);

            //execute
            ResultSet resultSet= db.executeSelect();

            if(resultSet.next()){
                nurse=new NursePerson();
                nurse.setId(resultSet.getInt(1));
                nurse.setFirstName(resultSet.getString(2));
                nurse.setLastName(resultSet.getString(3));
                nurse.setTelephone(resultSet.getString(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return nurse;
    }

    @Override
    public int add(NursePerson nurse) {
        return 0;
    }
}
