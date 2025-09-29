package com.rto.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/rto_db?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "root";      // change if needed
    private static final String PASSWORD = "Shree@123";  // change if needed

    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("✅ Connected to database!");
            }
        } catch (ClassNotFoundException e) {
            throw new SQLException("❌ JDBC Driver not found!", e);
        } catch (SQLException e) {
            throw new SQLException("❌ Database connection failed!", e);
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("🔒 Database connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("❌ Error closing connection: " + e.getMessage());
        }
    }
}
