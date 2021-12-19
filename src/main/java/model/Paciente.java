package model;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Paciente {
    private String id;
    private String rut;
    private String nombre;
    private String apellido;
    private int edad;
    private LocalDate fechaNacimiento;
    private String correo;
    private String numero;
    private LocalDate fechaCreacion;
    private boolean Isapre;
    private boolean Fonasa;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Paciente(String id,String rut, String nombre, String apellido,String fechaNacimiento, String correo,String numero, String isapre, String fonasa){
        System.out.println(fechaNacimiento);
        LocalDate f2 = LocalDate.now();
        this.id = id;
        this.rut=rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = Period.between(LocalDate.parse(fechaNacimiento), f2).getYears();
        this.fechaNacimiento = LocalDate.parse(fechaNacimiento);
        this.correo = correo;
        this.numero=numero;
        this.fechaCreacion = LocalDate.now();
        Isapre = Boolean.parseBoolean(isapre);
        Fonasa = Boolean.parseBoolean(fonasa);
    }

    public Paciente(String id, String rut, String nombre, String apellido, int edad, LocalDate fechaNacimiento, String correo, String numero, LocalDate fechaCreacion, boolean isapre, boolean fonasa) {
        this.id = id;
        this.rut=rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.numero=numero;
        this.fechaCreacion = fechaCreacion;
        Isapre = isapre;
        Fonasa = fonasa;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setIsapre(boolean isapre) {
        Isapre = isapre;
    }

    public void setFonasa(boolean fonasa) {
        Fonasa = fonasa;
    }

    public String getId() {
        return id;
    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNumero() {
        return numero;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public boolean isIsapre() {
        return Isapre;
    }

    public boolean isFonasa() {
        return Fonasa;
    }
}
