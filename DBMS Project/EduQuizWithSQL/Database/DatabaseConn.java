package Database;

import java.sql.*;

public class DatabaseConn {

    // Connection details
    private static final String URL = "jdbc:mysql://localhost:3306/eduquizdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password"; 

    // Establish a connection to the database
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}