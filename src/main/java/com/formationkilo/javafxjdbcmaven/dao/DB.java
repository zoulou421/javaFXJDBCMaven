package com.formationkilo.javafxjdbcmaven.dao;
//import java.sql.*;
import java.sql.*;

public class DB {
    //for connexion
    private Connection cnx;

    //for request results of SELECT type
    private ResultSet rs;

    //For Prepared request
    private PreparedStatement preparedStatement;

    //for requests result of type UPDATE(INSERT,UPDATE,DELETE)
    private int ok;

    private void getConnection()  {
        String url="jdbc:mysql://localhost:3306/appointmentJavaFX";
        String user="root";
        String password="root";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnx=DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void initPrepare(String sql){
        try {
            getConnection();
            preparedStatement=cnx.prepareStatement(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet executeSelect(){
        try {
            rs=preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    public int executeMaj(){
        try {
            ok=preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ok;
    }

    public void closeConnection(){
        try {
            if(cnx!=null){
                cnx.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public PreparedStatement getPreparedStatement() throws SQLException{
        return preparedStatement;
    }


}
