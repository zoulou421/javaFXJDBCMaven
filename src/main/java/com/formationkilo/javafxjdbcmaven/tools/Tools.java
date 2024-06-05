package com.formationkilo.javafxjdbcmaven.tools;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

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

    private void landingPage(ActionEvent event,String title,String url) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent root= FXMLLoader.load(getClass().getResource(url));
        Scene scene=new Scene(root);

        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setTitle(title);

        stage.show();
    }

    public static void load(ActionEvent event,String title,String url) throws IOException{
        new Tools().landingPage(event,title,url);
    }




}
