package com.example.agenda;

public class Evento extends AgendaInfo{
    private String tipoEvento;
    private String nombreEvento;
    private String fechaEvento;
    private Recordatorio recordatorioEvento;
    public Evento() {
    }

    public Evento(String tipoEvento, String nombreEvento, String fechaEvento) {
        this.tipoEvento = tipoEvento;
        this.nombreEvento = nombreEvento;
        this.fechaEvento = fechaEvento;
    }

    public Evento(String tipoEvento, String nombreEvento, String fechaEvento, Recordatorio recordatorio) {
        this.tipoEvento = tipoEvento;
        this.nombreEvento = nombreEvento;
        this.fechaEvento = fechaEvento;
        this.recordatorioEvento = recordatorio;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public String getFechaEvento() {
        return fechaEvento;
    }

    public Recordatorio getRecordatorio() {
        return recordatorioEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public void setFechaEvento(String fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public void setRecordatorio(Recordatorio recordatorio) {
        this.recordatorioEvento = recordatorio;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "tipoEvento='" + tipoEvento + '\'' +
                ", nombreEvento='" + nombreEvento + '\'' +
                ", fechaEvento='" + fechaEvento + '\'' +
                ", recordatorioEvento=" + recordatorioEvento +
                '}';
    }
}
