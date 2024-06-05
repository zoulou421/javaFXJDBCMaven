package com.formationkilo.javafxjdbcmaven;

import com.formationkilo.javafxjdbcmaven.dao.IUser;
import com.formationkilo.javafxjdbcmaven.dao.UserImpl;
import com.formationkilo.javafxjdbcmaven.entities.User;
import com.formationkilo.javafxjdbcmaven.tools.Tools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class MainController {
    @FXML
    private TextField emailtxt;

    @FXML
    private PasswordField passwordtxt;

    private IUser userdao=new UserImpl();

    public static String userParams;

   public void getLogin(ActionEvent event) throws IOException {
       String email=emailtxt.getText();
       String password=passwordtxt.getText();
       /*String params=email+" "+password;
       Alert alert=new Alert(Alert.AlertType.INFORMATION);
       alert.setTitle("Message");
       alert.setContentText(params);

       alert.showAndWaZit();*/
       if(email.equals("")||password.equals("")){
           System.out.println("You must fill all field");
           Tools.showErrorMessage("Error","You must fill all field");

       }else{

          User user=userdao.getConnection(email,password);
          if(user!=null){
              /*Stage stage=new Stage();
              Parent root;
              System.out.println("SUCCESSFULL LOooooo");
              root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/FXML2.fxml")));
              Scene scene = new Scene(root);
              stage.setScene(scene);
              stage.show();*/
              if(user.getNurse()!=null){
                  userParams="Hello"+user.getNurse().getFirstName()+" "+user.getNurse().getLastName();
              }
              if(user.getSec()!=null){
                  userParams="Hello"+user.getSec().getFirstName()+" "+user.getSec().getLastName();
              }
              Tools.load(event,"Welcome on your interface","/fxml/FXML1.fxml");
          }else {
              Tools.showErrorMessage("Error","Email or Password incorrect");
          }
       }

   }
}