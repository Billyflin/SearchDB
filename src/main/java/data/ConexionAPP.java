package data;

import model.Paciente;

import java.sql.*;

public class ConexionAPP extends ConectionData {
    private static final String DB_URL = "jdbc:mysql://181.226.110.208:3306/DrSearch";
    private static final String USER = "root";
    private static final String PASS = "0208";


    public ConexionAPP() throws SQLException {
        conectar();
    }


    public void conectar() throws SQLException {

        connection = DriverManager.getConnection(DB_URL, USER, PASS);
        statement = connection.createStatement();
    }
    public ResultSet leerTablaPacientes() throws SQLException {
        QUERY = "SELECT * FROM PACIENTES";
        return statement.executeQuery(QUERY);
    }


    public ResultSet buscarPacientePorID(String id) throws SQLException {
        QUERY = "SELECT * FROM PACIENTES WHERE id = ?";
        preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setString(1, id);
        return preparedStatement.executeQuery();
    }
    public void actualizarPaciente(Paciente paciente) throws SQLException {
        QUERY = "UPDATE pacientes set rut=?,nombre=?,apellido=?,edad=?,fechaNacimiento=?,correo=?,numero=?,fechaCreacion=?,isapre=?,fonasa=?  WHERE id = ?";
        preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setString(1,paciente.getRut());
        preparedStatement.setString(2,paciente.getNombre());
        preparedStatement.setString(3,paciente.getApellido());
        preparedStatement.setInt(4,paciente.getEdad());
        preparedStatement.setDate(5,Date.valueOf(paciente.getFechaNacimiento()));
        preparedStatement.setString(6,paciente.getCorreo());
        preparedStatement.setString(7,paciente.getNumero());
        preparedStatement.setDate(8, Date.valueOf(paciente.getFechaCreacion()));
        preparedStatement.setBoolean(9,paciente.isIsapre());
        preparedStatement.setBoolean(10,paciente.isFonasa());
        preparedStatement.setString(11,paciente.getId());
        preparedStatement.execute();

    }

    public void crearPaciente(Paciente paciente) throws SQLException {
        QUERY="INSERT INTO pacientes (id, rut, nombre, apellido, edad, fechaNacimiento, correo, numero, fechaCreacion, isapre, fonasa) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setString(1,paciente.getId());
        preparedStatement.setString(2,paciente.getRut());
        preparedStatement.setString(3,paciente.getNombre());
        preparedStatement.setString(4,paciente.getApellido());
        preparedStatement.setInt(5,paciente.getEdad());
        preparedStatement.setDate(6, Date.valueOf(paciente.getFechaNacimiento()));
        preparedStatement.setString(7,paciente.getCorreo());
        preparedStatement.setString(8,paciente.getNumero());
        preparedStatement.setDate(9, Date.valueOf(paciente.getFechaCreacion()));
        preparedStatement.setBoolean(10,paciente.isIsapre());
        preparedStatement.setBoolean(11,paciente.isFonasa());
        preparedStatement.execute();
    }


    public void cerrarConexion() throws SQLException {

        if (statement != null) {
            statement.close();
        }

        if (preparedStatement != null) {
            preparedStatement.close();
        }

        if (connection != null) {
            connection.close();
        }
    }
}
