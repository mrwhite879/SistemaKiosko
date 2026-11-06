package com.kiosko.dao;

import com.kiosko.model.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductoDAOImpl implements ProductoDAO {
    @Override
    public void insertar(Producto producto) {
        String sql = "INSERT INTO producto (nombre, codigo_barra, presentacion, precio ) VALUES (?, ?, ?, ?";

        try (Connection conn = DatabaseConnection.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getCodigo_barra());
            stmt.setString(3, producto.getPresentacion());
            stmt.setDouble(4, producto.getPrecio());

            stmt.executeUpdate();
            System.out.println("Producto guardado con exito");
        } catch (SQLException e) {
            System.out.println("Error al insertar producto: "+ e.getMessage());
        }
    }
}