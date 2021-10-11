package Application;

import java.sql.*;

public class ConnectionClass {
    public static Connection connection;
    public Connection getConnection() {
        System.out.println("Loading drivers");
        String myURL = "#########";
        String userName = "###########";  String pw = "#####";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot find driver", e);
        }
        connection = null;

        System.out.println ("Trying to connect to database");
        try {
            connection = DriverManager.getConnection(myURL, userName, pw );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
