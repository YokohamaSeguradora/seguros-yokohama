package br.com.yokohama.seguros.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static Connection instance = null;

    public Connection conectar() {
    	if (instance == null) {
    		try {
                instance = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "tm15", "21072006");
            } catch (SQLException e) {
                e.printStackTrace();
            }
    	}

        return instance;
    }
}
