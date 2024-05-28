package com.formationkilo.javafxjdbcmaven.tools;

import javafx.scene.control.Alert;

public class Tools {
    public static void showConfirmationMessage(String title,String message){
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setContentText(message);

        alert.showAndWait();
    }

    public static void showErrorMessage(String title,String message){
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);

        alert.showAndWait();
    }

    public static void showErrorWarning(String title,String message){
        Alert alert=new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setContentText(message);

        alert.showAndWait();
    }




}
