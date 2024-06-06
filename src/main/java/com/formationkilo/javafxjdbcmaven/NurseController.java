package com.formationkilo.javafxjdbcmaven;

import com.formationkilo.javafxjdbcmaven.dao.INursePerson;
import com.formationkilo.javafxjdbcmaven.dao.NursePersonImpl;
import com.formationkilo.javafxjdbcmaven.entities.NursePerson;
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

public class NurseController implements Initializable {
    @FXML
    private TextField firstnametxt;

    @FXML
    private TextField lastnametxt;

    @FXML
    private TextField teltxt;

    @FXML
    private Button validatebt;

    @FXML
    private Button cancelbt;

    @FXML
    private Button updatebt;

    @FXML
    private Button deletebt;

    @FXML
    private TableView <NursePerson>nursetable;

    @FXML
    private TableColumn<NursePerson,Integer>idColumn;

    @FXML
    private TableColumn<NursePerson,String>firstnameColumn;

    @FXML
    private TableColumn<NursePerson,String>lastnameColumn;


    @FXML
    private TableColumn<NursePerson,String>telColumn;

    private INursePerson nursePersondao=new NursePersonImpl();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstnameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastnameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        telColumn.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        load();

    }
    public void insertValidate(ActionEvent event){
        NursePerson nursePerson=new NursePerson();
        nursePerson.setFirstName(firstnametxt.getText());
        nursePerson.setLastName(lastnametxt.getText());
        nursePerson.setTelephone(teltxt.getText());

        int ok=nursePersondao.add(nursePerson);
        if(ok!=0){
            Tools.showConfirmationMessage("Success","Data inserted successfully");
            load();
        }else{
            Tools.showErrorMessage("Error","Insertion failed");
        }

    }

    public void resetCancel(ActionEvent event){

    }
    public void updateNurse(ActionEvent event){

    }

    public void deleteNurse(ActionEvent event){

    }

    public void load(){
        ObservableList<NursePerson>nursePeople= FXCollections.observableArrayList();
        List<NursePerson>nursePersonList=nursePersondao.getAllNurse();
        for(NursePerson nurse:nursePersonList){
            nursePeople.add(nurse);
        }
        nursetable.setItems(nursePeople);
    }

}
