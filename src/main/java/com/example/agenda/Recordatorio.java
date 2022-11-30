package com.example.agenda;

public class Recordatorio extends AgendaInfo{
    private String tipoRecordatorio;
    private String nombreRecordatorio;
    private String fechaRecordatorio;

    //Constructores
    public Recordatorio(String tipoRecordatorio, String nombreRecordatorio, String fechaRecordatorio) {
        this.tipoRecordatorio = tipoRecordatorio;
        this.nombreRecordatorio = nombreRecordatorio;
        this.fechaRecordatorio = fechaRecordatorio;
    }

    public Recordatorio() {
    }

    //Getters y setters
    public String getTipoRecordatorio() {
        return tipoRecordatorio;
    }

    public String getNombreRecordatorio() {
        return nombreRecordatorio;
    }

    public String getFechaRecordatorio() {
        return fechaRecordatorio;
    }

    public void setTipoRecordatorio(String tipoRecordatorio) {
        this.tipoRecordatorio = tipoRecordatorio;
    }

    public void setNombreRecordatorio(String nombreRecordatorio) {
        this.nombreRecordatorio = nombreRecordatorio;
    }

    public void setFechaRecordatorio(String fechaRecordatorio) {
        this.fechaRecordatorio = fechaRecordatorio;
    }
}
