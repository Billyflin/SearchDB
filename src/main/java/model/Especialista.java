package model;

public class Especialista {
    private String id;
    private String rut;
    private String nombre;
    private String apellido;
    private String area;
    private String especialidad;
    private boolean isapre;
    private boolean fonasa;
    private String direccionAtencion;

    public Especialista(String id, String rut, String nombre, String apellido, String area, String especialidad, boolean isapre, boolean fonasa, String direccionAtencion) {
        this.id = id;
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.area = area;
        this.especialidad = especialidad;
        this.isapre = isapre;
        this.fonasa = fonasa;
        this.direccionAtencion = direccionAtencion;
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

    public String getArea() {
        return area;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public boolean isIsapre() {
        return isapre;
    }

    public boolean isFonasa() {
        return fonasa;
    }

    public String getDireccionAtencion() {
        return direccionAtencion;
    }
}
