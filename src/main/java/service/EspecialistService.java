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
    public void createEspecialista(ArrayList<String> especialistaData){

    }


    private static ArrayList<String> getArrayResult(ResultSet resultados) throws SQLException {
        ArrayList<String> array = new ArrayList<>();
        while (resultados.next()) {
            array.add(resultados.getString("especialidad").replaceAll(",",""));
        }
        return array;
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
//
//    private static String readResult(ResultSet resultados) throws SQLException {
//        while (resultados.next()) {
//            return resultados.getString("especialidad");
//        }
//        return null;
//    }
}
