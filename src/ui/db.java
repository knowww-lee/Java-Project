package ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class db {
    private static final String URL = "jdbc:mysql://localhost:3306/pos";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection connection;
    private static Properties props;

    public static Connection mycon() {
        if (connection == null) {
            try {
                props = new Properties();
                props.setProperty("user", USER);
                props.setProperty("password", PASSWORD);

                connection = DriverManager.getConnection(URL, props);
            } catch (SQLException e) {
                // Re-throw the exception or log it
                throw new RuntimeException("Error connecting to database: " + e.getMessage());
            }
        }
        return connection;
    }
}