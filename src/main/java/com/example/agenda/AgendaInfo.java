package com.example.agenda;


import com.fasterxml.jackson.annotation.JsonSubTypes;

@JsonSubTypes({
        @JsonSubTypes.Type(value = AgendaInfo.class, name = "contacto"),
        @JsonSubTypes.Type(value = Contacto.class, name = "contacto"),
        @JsonSubTypes.Type(value = Recordatorio.class, name = "recordatorio"),
        @JsonSubTypes.Type(value = Evento.class, name = "evento")
})

public class AgendaInfo {
}
