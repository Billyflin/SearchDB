package data;

import model.Hora;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConexionEspecialist extends ConectionData {
    private static final String DB_URL = "jdbc:mysql://181.226.110.208:3306/DrSearch";
    private static final String USER = "root";
    private static final String PASS = "0208";

    public ConexionEspecialist() throws SQLException {
        super();
        conectar();
    }

    @Override
    public void conectar() throws SQLException {

        connection = DriverManager.getConnection(DB_URL, USER, PASS);
        statement = connection.createStatement();
    }

    public ResultSet leerTablahoras(String ID) throws SQLException {
        QUERY = "SELECT hora1,hora2,hora3,hora4,hora5,hora6,hora7,hora8,hora9,hora10 FROM horas" +
                " WHERE id = ?";
        preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setString(1, ID);
        return preparedStatement.executeQuery();
    }


    public ResultSet leerEspecilidades() throws SQLException {
        QUERY = "SELECT * FROM especialidades";
        preparedStatement = connection.prepareStatement(QUERY);
        return preparedStatement.executeQuery();
    }

    public ResultSet leerTablaEspecialistas() throws SQLException {
        QUERY = "SELECT * FROM especialistas";
        preparedStatement = connection.prepareStatement(QUERY);
        return preparedStatement.executeQuery();
    }

    public void guardarNuevasHoras(String id,ArrayList<Hora> horas) throws SQLException {

        QUERY = "UPDATE horas set hora1=?,hora2=?,hora3=?,hora4=?,hora5=?,hora6=?,hora7=?,hora8=?,hora9=?,hora10=?  WHERE id = ?";
        preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setTime(1, horas.get(0).getHora());
        preparedStatement.setTime(2, horas.get(1).getHora());
        preparedStatement.setTime(3, horas.get(2).getHora());
        preparedStatement.setTime(4, horas.get(3).getHora());
        preparedStatement.setTime(5, horas.get(4).getHora());
        preparedStatement.setTime(6, horas.get(5).getHora());
        preparedStatement.setTime(7, horas.get(6).getHora());
        preparedStatement.setTime(8, horas.get(7).getHora());
        preparedStatement.setTime(9, horas.get(8).getHora());
        preparedStatement.setTime(10, horas.get(9).getHora());
        preparedStatement.setString(11, id);
        preparedStatement.execute();
    }
}

