package config;

import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=BankingDB;encrypt=true;trustServerCertificate=true";
    private static final String USER = "arin";
    private static final String PASSWORD = "12345678";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
