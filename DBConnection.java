package com.mishra;

import java.sql.*;

public class DBConnection {

    private Connection connection;

    private static final String URL =
            "jdbc:mysql://localhost:3306/bankdb?useSSL=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "8270840800@Kc";

    public Connection openConn() {
        try {
            // Load MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create connection
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // SUCCESS MESSAGE
            System.out.println("✅ DATABASE CONNECTED SUCCESSFULLY");

        } catch (Exception e) {
            System.out.println("❌ DATABASE CONNECTION FAILED");
            e.printStackTrace();
            connection = null;
        }
        return connection;
    }

    public void closeConn() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("🔒 DATABASE CONNECTION CLOSED");
            }
        } catch (Exception e) {
            System.out.println("❌ FAILED TO CLOSE DATABASE CONNECTION");
        }
    }
}
