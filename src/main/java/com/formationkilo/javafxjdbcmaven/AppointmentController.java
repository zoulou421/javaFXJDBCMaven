package com.formationkilo.javafxjdbcmaven;

import com.formationkilo.javafxjdbcmaven.dao.AppointmentImpl;
import com.formationkilo.javafxjdbcmaven.dao.IAppointment;
import com.formationkilo.javafxjdbcmaven.dao.INursePerson;
import com.formationkilo.javafxjdbcmaven.dao.NursePersonImpl;
import com.formationkilo.javafxjdbcmaven.entities.Appointment;
import com.formationkilo.javafxjdbcmaven.entities.NursePerson;
import com.formationkilo.javafxjdbcmaven.tools.Tools;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AppointmentController implements Initializable {
    @FXML
    private TextField wordingtxt;

    @FXML
    private DatePicker datepkr;

    @FXML
    private ComboBox<NursePerson> nursecbx;

    private INursePerson nursePersondao=new NursePersonImpl();
    private IAppointment appointmentdao=new AppointmentImpl();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      loadNurse();
    }
    public void loadNurse(){
        ObservableList<NursePerson> nursePeople= FXCollections.observableArrayList();
        List<NursePerson> nursePersonList=nursePersondao.getAllNurse();
        for(NursePerson nurse:nursePersonList){
            nursePeople.add(nurse);
        }
        //nursetable.setItems(nursePeople);
        nursecbx.setItems(nursePeople);
    }

    public void insertApNurse(ActionEvent event){
        if(MainController.secretaryParams==null){
            //Notification.NotifError("Rights","You don't have rights to save an appointment");
            Tools.showErrorMessage("Rights","You don't have rights to save an appointment");
        }else{
            Appointment appointment=new Appointment();
            appointment.setWording(wordingtxt.getText());
            appointment.setDate(datepkr.getValue());
            appointment.setNursePerson(nursecbx.getValue());
            appointment.setSecretary(MainController.secretaryParams);
            int ok=appointmentdao.add(appointment);
            if(ok!=0){
                Tools.showConfirmationMessage("Success","Appoint saved successfully!");
            }else{
                Tools.showErrorMessage("Error","Failed to save data");
            }
        }

    }
}
