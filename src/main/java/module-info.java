module com.example.agenda {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.annotation;


    opens com.example.agenda to javafx.fxml;
    exports com.example.agenda;
}