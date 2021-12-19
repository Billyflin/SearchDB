package service;

import data.ConexionAPP;
import interfaz.CRUD;
import model.Paciente;
import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AppService {
    public void guardar(Paciente p){
        try {
            var conexion= new ConexionAPP();
            conexion.crearPaciente(p);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Paciente activo(String ID){
        ConexionAPP conexion= null;
        try {
            conexion = new ConexionAPP();
            var resultSet =conexion.buscarPacientePorID(ID);
            while (resultSet.next()){
                return (read(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Paciente create(ArrayList<String> pacienteData){
        var id=pacienteData.get(0);
        var rut = pacienteData.get(1);
        var nombre=pacienteData.get(2);
        var apellido=pacienteData.get(3);
        var fechaNacimiento=pacienteData.get(4);
        var correo=pacienteData.get(5);
        var numero=pacienteData.get(6);
        var isapre=pacienteData.get(7);
        var fonasa=pacienteData.get(8);
        return new Paciente(id,rut, nombre, apellido, fechaNacimiento,correo, numero, isapre, fonasa);
    }


    public Paciente read(@NotNull ResultSet list) throws SQLException {
            var id = list.getString("id");
            var rut = list.getString("rut");
            var nombre = list.getString("nombre");
            var apellido = list.getString("apellido");
            var edad = list.getInt("edad");
            var fechaNacimiento = list.getDate("fechaNacimiento").toLocalDate();
            var correo = list.getString("correo");
            var telefono = list.getString("numero");
            var fechaCreacion = list.getDate("fechaCreacion").toLocalDate();
            var isapre = list.getBoolean("isapre");
            var fonasa = list.getBoolean("fonasa");
            return new Paciente(id,rut, nombre, apellido, edad, fechaNacimiento,correo,telefono, fechaCreacion, isapre, fonasa);
    }
    public void actualizar(Paciente paciente){
        try {
            var conexion = new ConexionAPP();
            conexion.actualizarPaciente(paciente);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public ArrayList<Paciente> getAllPacientes(){
        ArrayList<Paciente> array=new ArrayList<>();
        ConexionAPP conexion = null;
        try {
            conexion = new ConexionAPP();
            var resultSet = conexion.leerTablaPacientes();
            while (resultSet.next()){
                array.add(read(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return array;
    }


}




//    private void pantalla1() {
//        ArrayList<String> countrys= Listas.listCountry();
//        Collections.sort(countrys);
//        for (String pais:countrys
//        ) {
//            comboBox1.addItem(pais);
//        }
//        button5.addActionListener(e ->  previusly());

//    private void pantalla4() {
//        BufferedImage img = null;
//        try {
//            img = ImageIO.read(new File("src/main/resources/anime_girl_PNG52.png"));
//        } catch (IOException e) {
//        }
//        xImagePanel1.setImage(img);
//        repaint();
