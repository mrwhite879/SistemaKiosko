package com.kiosko.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:kiosko.db?busy_timeout=3000";

    public static Connection conectar() throws SQLException {
        Connection conn = DriverManager.getConnection(URL);

        crearTablaProductos(conn);
        return conn;
    }

    private static void crearTablaProductos(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS productos (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT NOT NULL, " +
                "codigo_barra TEXT UNIQUE, " +
                "presentacion TEXT, " +
                "precio REAL)";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla: " + e.getMessage());
        }
    }
}
