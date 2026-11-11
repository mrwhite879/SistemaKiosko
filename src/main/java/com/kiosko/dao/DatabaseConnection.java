package com.kiosko.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:kiosko.db?busy_timeout=3000";

    public static Connection conectar() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
        } catch (SQLException  e) {
            System.out.println("Error al conectar con la base de datos" + e.getMessage());
        }
        return conn;
    }

    public static void inicializarBaseDeDatos() {
        try (Connection conn = conectar()) {
            if (conn != null) {
                crearTablaProductos(conn);
                crearTablaVentas(conn);
                crearTablaDetalleVentas(conn);
                crearTablaRetirosCaja(conn);
                System.out.println("Base de datos inicializada correctamente");
            }
        } catch (SQLException e) {
            System.out.println("Error al inicializar las tablas: " + e.getMessage());
        }
    }

    private static void crearTablaProductos(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS productos (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT NOT NULL, " +
                "codigo_barra TEXT UNIQUE, " +
                "presentacion TEXT, " +
                "precio REAL)";
        executeSQL(conn, sql);
    }

    private static void crearTablaVentas(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS ventas (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "fecha_hora TEXT NOT NULL, " +
                "medio_pago TEXT NOT NULL, " +
                "total REAL NOT NULL)";
        executeSQL(conn, sql);
    }

    private static void crearTablaDetalleVentas(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS detalle_ventas (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "venta_id INTEGER, " +
                "producto_id INTEGER, " +
                "cantidad INTEGER NOT NULL, " +
                "precio_unitario REAL NOT NULL, " +
                "FOREIGN KEY (venta_id) REFERENCES ventas(id), " +
                "FOREIGN KEY (producto_id) REFERENCES productos(id))";
        executeSQL(conn, sql);
    }

    private static void crearTablaRetirosCaja(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS retiros_caja (" +
                "id INTEGER PRIMARY AUTOINCREMENT, " +
                "fecha_hora TEXT NOT NULL, " +
                "monto REAL NOT NULL, " +
                "responsable TEXT NOT NULL, " +
                "motivo TEXT)";
        executeSQL(conn, sql);
    }

    private static void executeSQL(Connection conn, String sql) throws SQLException {
        try ( Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }
}
