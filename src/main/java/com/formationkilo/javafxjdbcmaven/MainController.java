package com.formationkilo.javafxjdbcmaven;

import com.formationkilo.javafxjdbcmaven.tools.Tools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
       /*String params=email+" "+password;
       Alert alert=new Alert(Alert.AlertType.INFORMATION);
       alert.setTitle("Message");
       alert.setContentText(params);

       alert.showAndWait();*/
       if(email.equals("")||password.equals("")){
           System.out.println("You must fill all field");
           Tools.showErrorMessage("Error","FIELDS ARE EMPTY");

       }else{

       }

   }
}