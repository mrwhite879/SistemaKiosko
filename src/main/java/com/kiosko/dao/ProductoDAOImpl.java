package com.kiosko.dao;

import com.kiosko.model.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoDAOImpl implements ProductoDAO {
    @Override
    public void insertar(Producto producto) {
        String sql = "INSERT INTO producto (nombre, codigo_barra, presentacion, precio ) VALUES (?, ?, ?, ?)";

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

    @Override
    public Producto buscarPorCodigoBarra(String codigo_barra) {
        String sql = "SELECT * FROM producto WHERE codigo_barra = ?"; //se crea la consulta para buscar el codigo de barra

        try (Connection conn = DatabaseConnection.conectar(); // nos conectamos a la base de datos
             PreparedStatement stmt = conn.prepareStatement(sql)) { //le mandamos la consulta al preparedstatement

            stmt.setString(1, codigo_barra); // buscamos el codigo de barras

            try (ResultSet rs = stmt.executeQuery()){
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String codigo_barraDB = rs.getString("codigo_barra");
                    String presentacion = rs.getString("presentacion");
                    double precio = rs.getDouble("precio");

                    return new Producto(id, nombre, codigo_barra, presentacion, precio);
                }

            }

        } catch (SQLException e) {
            System.out.println("Error al buscar producto por codigo de barras " + e.getMessage());
        }
        return null;
    }
}