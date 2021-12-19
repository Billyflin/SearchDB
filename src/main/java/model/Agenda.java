package model;

import java.time.LocalDateTime;

public class Agenda {
    private String idPaciente;
    private String idEspecialista;
    private LocalDateTime fecha;

    public Agenda(String idPaciente, String idEspecialista, LocalDateTime fecha) {
        this.idPaciente = idPaciente;
        this.idEspecialista = idEspecialista;
        this.fecha = fecha;
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
