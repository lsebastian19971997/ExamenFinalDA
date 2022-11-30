package com.example.agenda;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EventoEdicionDialogoController implements Initializable {

    @FXML private Button btnGuardar;
    @FXML private Button btnSalir;
    @FXML private TextField txtEvento;
    @FXML private TextField txtNombre;
    @FXML private TextField txtTipo;

    private Evento evento;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    @FXML
    void guardarEvento(ActionEvent event) {
        String tipo = this.txtTipo.getText();
        String nombre = this.txtNombre.getText();
        String fecha = this.txtEvento.getText();

        this.evento = new Evento(tipo,nombre,fecha);

        Stage stage = (Stage) this.btnGuardar.getScene().getWindow();
        stage.close();
    }

    @FXML
    void salirEvento(ActionEvent event) {
        this.evento=null;
        Stage stage = (Stage) this.btnSalir.getScene().getWindow();
        stage.close();
    }
    public Evento getEvento(){
        return this.evento;
    }

}
