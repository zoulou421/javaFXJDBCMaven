module com.formationkilo.javafxjdbcmaven {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;
    requires controlsfx;


    opens com.formationkilo.javafxjdbcmaven to javafx.fxml;
    exports com.formationkilo.javafxjdbcmaven;
}