package com.formationkilo.javafxjdbcmaven.test;

import com.formationkilo.javafxjdbcmaven.dao.IUser;
import com.formationkilo.javafxjdbcmaven.dao.UserImpl;

public class Test {
    public static void main(String[] v){
        IUser userDAO=new UserImpl();
        userDAO.getConnection("bonevybeby@example.com","123");

    }
}
