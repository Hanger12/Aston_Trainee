package aston.aston_trainee.ServiceServlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionToDataBase {
    public static Connection GetConnection() throws SQLException, ClassNotFoundException {
        String url = "jdbc:postgresql://localhost:5432/ServiceAston";
        String username = "postgres";
        String password = "121245";
        return DriverManager.getConnection(url,username,password);
    }
}
