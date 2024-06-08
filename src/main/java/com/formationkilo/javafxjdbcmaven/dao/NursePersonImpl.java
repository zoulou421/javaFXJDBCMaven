package com.formationkilo.javafxjdbcmaven.dao;

import com.formationkilo.javafxjdbcmaven.entities.Appointment;
import com.formationkilo.javafxjdbcmaven.entities.NursePerson;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        String sql="INSERT INTO nurseperson VALUES(NULL, ?, ?, ?)";
        int ok=0;
        try {
            db.initPrepare(sql);
            db.getPreparedStatement().setString(1,nurse.getFirstName());
            db.getPreparedStatement().setString(2,nurse.getLastName());
            db.getPreparedStatement().setString(3,nurse.getTelephone());
            ok=db.executeMaj();
        }catch (Exception ex) {
           ex.printStackTrace();
        }
        return ok;
    }

    @Override
    public List<NursePerson> getAllNurse() {
        String sql="SELECT * FROM nurseperson";
        List<NursePerson>nurseList=new ArrayList<NursePerson>();
        try {
            db.initPrepare(sql);
            //execute
            ResultSet resultSet= db.executeSelect();

            while (resultSet.next()){
                NursePerson nurse=new NursePerson();
                nurse.setId(resultSet.getInt(1));
                nurse.setFirstName(resultSet.getString(2));
                nurse.setLastName(resultSet.getString(3));
                nurse.setTelephone(resultSet.getString(4));
                nurseList.add(nurse);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return nurseList;
    }


    @Override
    public NursePerson delete(int id) {
        String sql="DELETE  FROM nurseperson WHERE id= ?";
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


}
