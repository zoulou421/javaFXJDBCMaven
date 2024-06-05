package com.formationkilo.javafxjdbcmaven;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TwoScene extends Application {
    @Override
    public void start(Stage stage) throws Exception {
       // Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("FXML1.fxml")));
        FXMLLoader root=new FXMLLoader(TwoScene.class.getResource("FXML1.fxml"));

       // Scene scene=new Scene(root);
        Scene scene=new Scene(root.load());

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] v){
        launch(v);
    }
}
