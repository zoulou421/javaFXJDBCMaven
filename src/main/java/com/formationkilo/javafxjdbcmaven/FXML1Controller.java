package com.formationkilo.javafxjdbcmaven;

import com.formationkilo.javafxjdbcmaven.tools.Tools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class FXML1Controller implements Initializable {
    @FXML
    private Label message;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        message.setText(MainController.userParams);
    }

    public void loadConsultation(ActionEvent event){
       try{
           Tools.loadSub(event,"Appointment Managment", "/appointmentui/appointment.fxml");
       }catch (Exception ex){
           ex.printStackTrace();
       }
    }
    public void loadNurse(ActionEvent event){
      try{
          Tools.loadSub(event,"Nurses Managment","/nurseui/nurse.fxml");
      }catch (Exception ex){
          ex.printStackTrace();
      }
    }
}
