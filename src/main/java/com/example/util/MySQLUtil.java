package com.example.util;

import java.sql.*;

public class MySQLUtil {

    public MySQLUtil() {
    }

    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssm?serverTimezone=UTC&useSSL=false", "root", "root");
            return connection;
        } catch (SQLException | ClassNotFoundException var2) {
            var2.printStackTrace();
            return connection;
        }
    }

    public static void close(ResultSet rs, Connection connection, Statement stmt) {
        try {
            rs.close();
            connection.close();
            stmt.close();
        } catch (SQLException var4) {
            var4.printStackTrace();
        }

    }

    public static void close(Connection connection, Statement stmt) {
        try {
            connection.close();
            stmt.close();
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

    }
}