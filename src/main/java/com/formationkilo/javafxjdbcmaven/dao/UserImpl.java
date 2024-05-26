package com.formationkilo.javafxjdbcmaven.dao;

import com.formationkilo.javafxjdbcmaven.entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserImpl implements IUser{
    private DB db=new DB();
    @Override
    public User getConnection(String email, String password) {
        User user=null;
        String sql="SELECT * FROM user WHERE email = ? AND password = ?";
        try {
            db.initPrepare(sql);
            db.getPreparedStatement().setString(1,email);
            db.getPreparedStatement().setString(2,password);
            ResultSet rs= db.executeSelect();
            if(rs.next()){
                user=new User();
                user.setId(rs.getInt(1));
                user.setEmail(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setNurse(null);
                user.setSec(null);
                Object nurse=rs.getObject(4);
                if(nurse!=null){
                  //System.out.println("Nurse"+ (Integer)nurse);
                    user.setNurse(new NursePersonImpl().get((Integer)nurse));
                }
                Object secreta=rs.getObject(5);
                if(secreta!=null){
                   //System.out.println("Secretary "+(Integer)secreta);
                    user.setSec(new SecretaryImpl().get((Integer)secreta));
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
