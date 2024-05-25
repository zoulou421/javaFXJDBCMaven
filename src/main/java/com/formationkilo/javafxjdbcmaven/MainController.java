package com.formationkilo.javafxjdbcmaven;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class MainController {
    @FXML
    private TextField emailtxt;

    @FXML
    private PasswordField passwordtxt;
   public void getLogin(ActionEvent e){
       String email=emailtxt.getText();
       String password=passwordtxt.getText();
       String params=email+" "+password;
       Alert alert=new Alert(Alert.AlertType.INFORMATION);
       alert.setTitle("Message");
       alert.setContentText(params);

       alert.showAndWait();
   }
}