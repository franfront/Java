package org.ffernandez.java.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBase {
    private static String url = "**********";
    private static String username = "*****";
    private static String password = "*****";
    private static Connection conn;

    public static Connection getConexion() throws SQLException {

        return DriverManager.getConnection(url, username, password);
    }
}
