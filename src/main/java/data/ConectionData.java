package data;

import interfaz.Conection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public abstract class ConectionData implements Conection {
    String DB_URL;
    String USER;
    String PASS;
    protected String QUERY;
    protected Connection connection;
    protected Statement statement;
    protected PreparedStatement preparedStatement;
}

//TODO
//Implementar los métodos de la interfaz.
//La interfaz debe tener el comportamiento que tiene tu clase que se conecta con la BBDD.

