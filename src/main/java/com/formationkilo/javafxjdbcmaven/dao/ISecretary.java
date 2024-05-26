package com.formationkilo.javafxjdbcmaven.dao;

import com.formationkilo.javafxjdbcmaven.entities.Secretary;

public interface ISecretary {
    public int add(Secretary sec);
    public Secretary get(int id);
}
