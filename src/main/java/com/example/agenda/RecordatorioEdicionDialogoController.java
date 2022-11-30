package com.example.agenda;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class RecordatorioEdicionDialogoController implements Initializable {

    @FXML private Button btnGuardar;
    @FXML private Button btnSalir;
    @FXML private TextField txtFecha;
    @FXML private TextField txtNombre;
    @FXML private TextField txtTipo;
    private Recordatorio recordatorio;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML void SalirRecordatorio(ActionEvent event) {
        this.recordatorio=null;
        Stage stage = (Stage) this.btnSalir.getScene().getWindow();
        stage.close();
    }
    @FXML
    void guardarRecordatorio(ActionEvent event) {
        String tipo = this.txtTipo.getText();
        String nombre = this.txtNombre.getText();
        String fecha = this.txtFecha.getText();

        this.recordatorio = new Recordatorio(tipo,nombre,fecha);

        Stage stage = (Stage) this.btnGuardar.getScene().getWindow();
        stage.close();
    }

    public Recordatorio getRecordatorio() {
        return recordatorio;
    }
}
