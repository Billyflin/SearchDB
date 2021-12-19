package model;

import java.sql.Time;

public class Hora {
    private Time hora;

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Hora() {
    }

    public Hora(Time hora) {
       this.hora = hora;
    }

    public Time getHora() {
        return hora;
    }

}
