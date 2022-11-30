package com.example.agenda;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ContactoEdicionDialogoControlador implements Initializable {

    ObservableList<Contacto> contactosLista;
    Contacto contacto;

    @FXML
    private Button btnSalir;

    @FXML
    private Button btnGuardar;

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void cancelar(ActionEvent event) {

    }

    @FXML
    void guardar(ActionEvent event) {
        String nombre = this.txtNombre.getText();
        String apellidos = this.txtApellidos.getText();
        String email = this.txtEmail.getText();
        String telefono = this.txtTelefono.getText();

        this.contacto = new Contacto(nombre,apellidos,email,telefono);

        Stage stage = (Stage) this.btnGuardar.getScene().getWindow();
        stage.close();
    }

    @FXML
    void salir(ActionEvent event) {
            this.contacto=null;
            Stage stage = (Stage) this.btnSalir.getScene().getWindow();
            stage.close();

        }


    public void initAttributes(ObservableList<Contacto> contactos) {
        this.contactosLista = contactos;
    }

    public Contacto getContacto(){
        return this.contacto;
    }
}
