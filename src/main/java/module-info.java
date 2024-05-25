module com.formationkilo.javafxjdbcmaven {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.formationkilo.javafxjdbcmaven to javafx.fxml;
    exports com.formationkilo.javafxjdbcmaven;
}