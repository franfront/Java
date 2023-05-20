package org.ffernandez.java.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBase {
    private static String url = "jdbc:mysql://localhost:3307/java_curso";
    private static String username = "root";
    private static String password = "prueba01";
    private static Connection conn;

    public static Connection getConexion() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return conn;
    }
}
