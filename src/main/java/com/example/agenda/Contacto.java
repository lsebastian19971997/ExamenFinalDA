package com.example.agenda;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.util.ArrayList;
import java.util.List;

public class Contacto extends AgendaInfo{
    private String nombre;
    private String apellidos;
    private String mail;
    private String telefono;
    private ObservableList<Evento> eventos = FXCollections.observableArrayList();

    //Constructor
    public Contacto() {
    }
    public Contacto(String nombre, String apellidos, String mail, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.mail = mail;
        this.telefono = telefono;
    }

    //Setters y getters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEventos(ObservableList<Evento> eventos) {
        this.eventos = eventos;
    }

    public void anadirEvento(Evento evento) {
        this.eventos.add(evento);
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getMail() {
        return mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public ObservableList<Evento> getEventos() {
        return eventos;
    }
}
