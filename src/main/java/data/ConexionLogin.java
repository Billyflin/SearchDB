package data;

import interfaz.ConectionData;

import java.sql.*;

public class ConexionLogin extends ConectionData {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/login";
    private static final String USER = "root";
    private static final String PASS = "0208";


    public ConexionLogin() throws SQLException {
        super();
        conectar();
    }
    public void conectar() throws SQLException {

        connection = DriverManager.getConnection(DB_URL, USER, PASS);
        statement = connection.createStatement();
    }
    private ResultSet buscarCliente(String rut,String pass) throws SQLException {

        var datosCliente = new ConexionLogin();

        QUERY = "SELECT * FROM login" +
                " WHERE rut = ?";

        return datosCliente.buscarRegistro(rut,pass);
    }


    public boolean passCorrect(String pass) throws SQLException {
        QUERY = "SELECT * FROM login WHERE pass = '"+ pass+"'";
        var rs=statement.executeQuery(QUERY);
        return rs.isBeforeFirst();
    }

    public boolean rutExist(String rut) throws SQLException {
        QUERY = "SELECT * FROM login WHERE rut = '"+ rut+"'";
        var rs=statement.executeQuery(QUERY);
        return rs.isBeforeFirst();
    }

    public ResultSet buscarRegistro(String rut,String pass) throws SQLException {

        QUERY = "SELECT * FROM login.login" +
                " WHERE rut = ? and pass = ?";
        preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setString(1, rut);
        preparedStatement.setString(2, pass);
        return preparedStatement.executeQuery();
    }
    public ResultSet buscarRegistro(String ID) throws SQLException {

        QUERY = "SELECT * FROM login.login" +
                " WHERE id = ?";
        preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setString(1, ID);
        return preparedStatement.executeQuery();
    }

    public void insertarDato(String rut, String pass,Integer access, String id) throws SQLException {

        QUERY = "INSERT INTO login(rut, pass, access, id)" +
                " VALUES (?, ?, ?, ?)";

        preparedStatement = connection.prepareStatement(QUERY);

        preparedStatement.setString(1, rut);
        preparedStatement.setString(2,pass);
        preparedStatement.setInt(3, access);
        preparedStatement.setString(4, id);

        preparedStatement.executeUpdate();
    }

    public void getall() throws SQLException {
        QUERY = "SELECT * FROM login";
        statement.execute(QUERY);
    }

    public void delete(String id) throws SQLException {
        QUERY = "DELETE FROM login WHERE id = '"+ id+"'";
        statement.execute(QUERY);
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
