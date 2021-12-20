package service;

import data.ConexionLogin;
import interfaz.Session;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class LoginService implements Session {
    @Override
    public boolean access(Object rut, Object pass) {
        try {
            var conexion = new ConexionLogin();
            return conexion.rutExist((String) rut) && conexion.passCorrect((String) pass);
        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int accessLevel(Object ID) {
        try {
            var conexion = new ConexionLogin();
            var resultado = conexion.buscarRegistro((String) ID);
            return Integer.parseInt(Objects.requireNonNull(readResult(resultado, "access")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public void accessChange(String id,int nivel){
        try {
            var conexion = new ConexionLogin();
            conexion.cambiarAccess( id,nivel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object sessionID(Object rut, Object pass) {
        try {
            var conexion = new ConexionLogin();
            return readResult(conexion.buscarRegistro((String) rut, (String) pass),"id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void register(Object rut, Object pass, Object level, Object id) {
        try {
            var conexion = new ConexionLogin();
            conexion.insertarDato((String) rut, (String) pass, (Integer) level, (String) id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(Object id) {
        try {
            var conexion = new ConexionLogin();
            conexion.delete((String) id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String readResult(ResultSet resultados,String column) throws SQLException {
        while (resultados.next()) {
            return resultados.getString(column);
        }
        return null;
    }
}
