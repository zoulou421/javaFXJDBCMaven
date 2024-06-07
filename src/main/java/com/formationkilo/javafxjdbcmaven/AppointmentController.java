package com.formationkilo.javafxjdbcmaven;

import com.formationkilo.javafxjdbcmaven.dao.AppointmentImpl;
import com.formationkilo.javafxjdbcmaven.dao.IAppointment;
import com.formationkilo.javafxjdbcmaven.dao.INursePerson;
import com.formationkilo.javafxjdbcmaven.dao.NursePersonImpl;
import com.formationkilo.javafxjdbcmaven.entities.Appointment;
import com.formationkilo.javafxjdbcmaven.entities.NursePerson;
import com.formationkilo.javafxjdbcmaven.entities.Secretary;
import com.formationkilo.javafxjdbcmaven.tools.Tools;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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

    @FXML
    private TableView<Appointment>appointmenttable;
    @FXML
    private TableColumn<Appointment,Integer>identifierColumn;
    @FXML
    private TableColumn<Appointment,String>wordingColumn;
    @FXML
    private TableColumn<Appointment,String> dateapColumn;
    @FXML
    private TableColumn<Appointment,NursePerson>nurseapColumn;
    @FXML
    private TableColumn<Appointment, Secretary>secretaryapColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        identifierColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        wordingColumn.setCellValueFactory(new PropertyValueFactory<>("wording"));
        dateapColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        nurseapColumn.setCellValueFactory(new PropertyValueFactory<>("nursePerson"));
        secretaryapColumn.setCellValueFactory(new PropertyValueFactory<>("secretary"));
        loadAppointment();
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
                loadAppointment();
            }else{
                Tools.showErrorMessage("Error","Failed to save data");
            }
        }

    }

    public void loadAppointment(){
        ObservableList<Appointment> appointments= FXCollections.observableArrayList();
        List<Appointment>appointmentList=appointmentdao.getAll();
        for(Appointment appointment:appointmentList){
            appointments.add(appointment);
        }
        //nursetable.setItems(nursePeople);
        //nursecbx.setItems(nursePeople);
        appointmenttable.setItems(appointments);
    }
}
