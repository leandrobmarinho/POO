package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
		
    public Connection getConnection() {

        try {
            return DriverManager.getConnection(
          "jdbc:postgresql://localhost/escola", "leandrobm", "superuser");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
