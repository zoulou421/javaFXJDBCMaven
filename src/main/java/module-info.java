module com.formationkilo.javafxjdbcmaven {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;
    requires controlsfx;
    requires transitive javafx.graphics;
    requires transitive javafx.base;


    opens com.formationkilo.javafxjdbcmaven to javafx.fxml;
    exports com.formationkilo.javafxjdbcmaven;
}