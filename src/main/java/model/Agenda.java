package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Agenda {
    private String idPaciente;
    private String idEspecialista;
    private LocalDateTime fecha;

    public Agenda(String idPaciente, String idEspecialista, LocalDateTime fecha) {
        this.idPaciente = idPaciente;
        this.idEspecialista = idEspecialista;
        this.fecha = fecha;
    }


    public Agenda(String idpaciente, String idespecialista, LocalDate date, LocalTime time) {
        this.idPaciente = idpaciente;
        this.idEspecialista = idespecialista;
        this.fecha = date.atTime(time);
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public String getIdEspecialista() {
        return idEspecialista;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

}
