package service;

import data.ConexionEspecialist;
import data.ConexionLogin;
import model.Especialista;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EspecialistService {
    public ArrayList<String> getEspecialidades() {
        ArrayList<String> resultArray = new ArrayList<>();
        try {
            var conexion = new ConexionEspecialist();
            var result = conexion.leerEspecilidades();
            return getArrayResult(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultArray;
    }
    public ArrayList<String> getAreas() {
        ArrayList<String> resultArray = new ArrayList<>();
        try {
            var conexion = new ConexionEspecialist();
            var result = conexion.leerEspecilidades();
            return getArrayAreaResult(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultArray;
    }
    private static ArrayList<String> getArrayAreaResult(ResultSet resultados) throws SQLException {
        ArrayList<String> array = new ArrayList<>();
        while (resultados.next()) {
            array.add(resultados.getString("area"));
        }
        return array;
    }
    public void createEspecialista(ArrayList<String> especialistaData){
        try {
            var conexion = new ConexionEspecialist();
            var conexionlogin= new ConexionLogin();
            conexionlogin.crearEspecilista(especialistaData.get(0),especialistaData.get(1));
            conexion.guardarEspecilista(especialistaData);
            conexion.createHorario(especialistaData.get(0));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static ArrayList<String> getArrayResult(ResultSet resultados) throws SQLException {
        ArrayList<String> array = new ArrayList<>();
        while (resultados.next()) {
            array.add(resultados.getString("especialidad"));
        }
        return array;
    }
    public void delete(Object id){
        deleteEspecialista(id);
        deleteUser(id);
        deleteHorario(id);
    }

    private void deleteHorario(Object id) {
        try {
            var conexion = new ConexionEspecialist();
            conexion.deletehour
                    ((String) id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEspecialista(Object id){
        try {
            var conexion = new ConexionEspecialist();
            conexion.delete((String) id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(Object id) {
        try {
            var conexion = new ConexionLogin();
            conexion.delete((String) id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Especialista read(ResultSet resultado) throws SQLException {
        var id = resultado.getString("id");
        var rut = resultado.getString("rut");
        var nombre = resultado.getString("nombre");
        var apellido = resultado.getString("apellido");
        var area = resultado.getString("area");
        var especialidad = resultado.getString("especialidad");
        var isapre = resultado.getBoolean("isapre");
        var fonasa = resultado.getBoolean("fonasa");
        var direccionAtencion = resultado.getString("direccionAtencion");
        return new Especialista(id, rut, nombre, apellido, area, especialidad,isapre, fonasa, direccionAtencion);
    }

    public ArrayList<Especialista> getAllEspecialistas() {
        ArrayList<Especialista> array=new ArrayList<>();
        ConexionEspecialist conexion = null;
        try {
            conexion = new ConexionEspecialist();
            var resultSet = conexion.leerTablaEspecialistas();
            while (resultSet.next()){
                array.add(read(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return array;
    }

}
