package com.formationkilo.javafxjdbcmaven.dao;

import com.formationkilo.javafxjdbcmaven.entities.User;

public interface IUser {
    public User getConnection(String email, String password);
}
