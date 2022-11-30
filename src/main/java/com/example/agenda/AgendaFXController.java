package com.example.agenda;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AgendaFXController implements Initializable {

    @FXML private TableColumn colApellidosContacto;
    @FXML private TableColumn colFechaEvento;
    @FXML private TableColumn colFechaRecordatorio;
    @FXML private TableColumn colNombreContacto;
    @FXML private TableColumn colNombreRecordatorio;
    @FXML private TableColumn colTipoEvento;
    @FXML private TableColumn colTipoNombre;
    @FXML private TableColumn colTipoRecordatorio;
    @FXML private Label lblApellidos;
    @FXML private Label lblEmail;
    @FXML private Label lblFechaEvento;
    @FXML private Label lblFechaRecordatorio;
    @FXML private Label lblNombre;
    @FXML private Label lblNombreEvento;
    @FXML private Label lblNombreRecordatorio;
    @FXML private Label lblTelefono;
    @FXML private Label lblTipoEvento;
    @FXML private Label lblTipoRecordatorio;
    @FXML private TableView<Contacto> tblContactos;
    @FXML private TableView<Evento> tblEventos;
    @FXML private TableView<Recordatorio> tblRecordatorios;

    private List<Evento> eventosLista = new ArrayList<>();

    private ObservableList<Contacto> contactos;
    private ObservableList<Evento> eventos;
    private ObservableList<Recordatorio> recordatorios;
    private Contacto contactoActual;
    private Evento eventoActual;
    private Recordatorio recordatorioActual;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        contactos = FXCollections.observableArrayList();
        eventos = FXCollections.observableArrayList();
        recordatorios = FXCollections.observableArrayList();
        this.tblContactos.setItems(contactos);
        this.tblEventos.setItems(eventos);
        this.tblRecordatorios.setItems(recordatorios);

        this.colNombreContacto.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colApellidosContacto.setCellValueFactory(new PropertyValueFactory("apellidos"));

        this.colTipoEvento.setCellValueFactory(new PropertyValueFactory("tipoEvento"));
        this.colTipoNombre.setCellValueFactory(new PropertyValueFactory("nombreEvento"));
        this.colFechaEvento.setCellValueFactory(new PropertyValueFactory("fechaEvento"));

        this.colTipoRecordatorio.setCellValueFactory(new PropertyValueFactory("tipoRecordatorio"));
        this.colTipoRecordatorio.setCellValueFactory(new PropertyValueFactory("nombreRecordatorio"));
        this.colTipoRecordatorio.setCellValueFactory(new PropertyValueFactory("fechaRecordatorio"));

        tblContactos.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue1) -> showContactoDetails((Contacto) newValue1));



    }

    private void showContactoDetails(Contacto contacto)
    {
        this.contactoActual = contacto;
        if (contacto != null) {
            // Fill the labels with info from the contactoDTO object.
            lblNombre.setText(this.contactoActual.getNombre());
            lblApellidos.setText(this.contactoActual.getApellidos());
            lblEmail.setText(this.contactoActual.getMail());
            lblTelefono.setText(this.contactoActual.getTelefono());
            this.setContactoActual(contacto);


        } else {
            // ContactoDTO is null, remove all the text.
            lblNombre.setText("");
            lblApellidos.setText("");
            lblTelefono.setText("");
            lblEmail.setText("");
        }

        if(contactoActual.getEventos()!=null){
            eventos = null;
            eventos = contactoActual.getEventos();
            tblEventos.setItems(eventos);
            tblEventos.refresh();
        }

    }

    @FXML
    void modificarContacto(ActionEvent event) {

    }

    void setContactoActual(Contacto c){
        this.contactoActual = c;
    }

    @FXML
    void nuevoContacto(ActionEvent event) {
        try {
            FXMLLoader loader =  new FXMLLoader(getClass().getResource("ContactoEdicionDialogoView.fxml"));
            Parent root = loader.load();
            ContactoEdicionDialogoControlador controlador = loader.getController();
            controlador.initAttributes(contactos);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

            Contacto c = controlador.getContacto();
            if(c!= null){
                this.contactos.add(c);
                this.tblContactos.refresh();
            }

        }catch(IOException ex){
            System.out.println(ex);
        }
    }

    @FXML
    void nuevoEvento(ActionEvent event) {
        Contacto c = this.tblContactos.getSelectionModel().getSelectedItem();
        Contacto selection = this.contactoActual;
        if(c== null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("INFORMACION");
            alert.setContentText("Debe seleccionar una persona");
            alert.showAndWait();
        }
        else {
            try {
                FXMLLoader loader =  new FXMLLoader(getClass().getResource("EventoEdicionDialogoView.fxml"));
                Parent root = loader.load();
                EventoEdicionDialogoController controlador = loader.getController();

                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();

                Evento e = controlador.getEvento();

                if(e!= null){
                    //c.anadirEvento(e);

                    for (Contacto con: contactos){
                        if(con.equals(contactoActual)){
                            con.anadirEvento(e);
                            eventos = con.getEventos();
                        }
                    }
                    this.tblEventos.refresh();
                }

            }catch(IOException ex){
                System.out.println(ex);
            }
        }

    }

    @FXML
    void nuevoRecordatorio(ActionEvent event) {

        Evento e = this.tblEventos.getSelectionModel().getSelectedItem();
        Contacto c = this.tblContactos.getSelectionModel().getSelectedItem();
        Evento selection = this.eventoActual;
        if(e== null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("INFORMACION");
            alert.setContentText("Debe seleccionar un evento");
            alert.showAndWait();
        }
        else {
            try {
                FXMLLoader loader =  new FXMLLoader(getClass().getResource("RecordatorioEdicionDialogoView.fxml"));
                Parent root = loader.load();
                RecordatorioEdicionDialogoController controlador = loader.getController();

                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();

                Recordatorio r = controlador.getRecordatorio();

                if(r!= null){
                    //c.anadirEvento(e);
                    for(Contacto con: contactos){
                        if(con.equals(c)){
                            for (Evento eve : c.getEventos()){
                               if (eve.equals(e)){
                                   eve.setRecordatorio(r);
                                   recordatorios.add(r);
                               }
                            }
                        }
                    }
                }

                this.tblRecordatorios.refresh();

            }catch(IOException ex){
                System.out.println(ex);
            }
        }



    }

    @FXML
    void seleccionarEvento(MouseEvent event) {

    }

    @FXML
    void seleccionarRecordatorio(MouseEvent event) {

    }






    }
