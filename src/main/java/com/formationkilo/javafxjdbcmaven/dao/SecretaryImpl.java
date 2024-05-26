package com.formationkilo.javafxjdbcmaven.dao;

import com.formationkilo.javafxjdbcmaven.entities.NursePerson;
import com.formationkilo.javafxjdbcmaven.entities.Secretary;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SecretaryImpl implements ISecretary{
    private DB db=new DB();
    @Override
    public int add(Secretary sec) {
        return 0;
    }

    @Override
    public Secretary get(int id) {
        String sql="SELECT * FROM secretary WHERE id= ?";
        Secretary secreta=null;
        try {
            db.initPrepare(sql);
            db.getPreparedStatement().setInt(1,id);

            //execute
            ResultSet resultSet= db.executeSelect();

            if(resultSet.next()){
                secreta=new Secretary();
                secreta.setId(resultSet.getInt(1));
                secreta.setFirstName(resultSet.getString(2));
                secreta.setLastName(resultSet.getString(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return secreta;
    }
}
