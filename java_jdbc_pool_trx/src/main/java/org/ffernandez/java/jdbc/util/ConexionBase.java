package org.ffernandez.java.jdbc.util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBase {
    private static String url = "**********";
    private static String username = "*****";
    private static String password = "*****";
    private static BasicDataSource pool;

    public static BasicDataSource getInstance() throws SQLException {
        if(pool == null){
            pool = new BasicDataSource();
            pool.setUrl(url);
            pool.setUsername(username);
            pool.setPassword(password);
            pool.setInitialSize(3); //  número inicial de conexiones
            pool.setMinIdle(3); // número mínimo de conexiones inactivas
            pool.setMaxIdle(8); // número máximo de conexiones inactivas
            pool.setMaxTotal(10); // número máximo de conexiones totales
        }

        return pool;
    }

    public static Connection getConnection() throws SQLException {
        return getInstance().getConnection();
    }
}
