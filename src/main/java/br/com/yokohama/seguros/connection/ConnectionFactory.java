package br.com.yokohama.seguros.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static Connection instance = null;

    public Connection conectar() {
<<<<<<< HEAD
        try {
            return DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "tm15", "21072006");
        } catch (SQLException e) {
            e.printStackTrace();
        }
=======
    	if (instance == null) {
    		try {
                instance = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "tm15", "21072006");
            } catch (SQLException e) {
                e.printStackTrace();
            }
    	}
>>>>>>> 247123798bc35add5433d2204be92dc1499b714c

        return instance;
    }
}
