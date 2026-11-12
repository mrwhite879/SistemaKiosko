package com.kiosko.dao;

import com.kiosko.model.DetalleVenta;
import com.kiosko.model.Venta;

import java.sql.*;
import java.util.List;

public class VentaDAOImpl implements VentaDAO {

    @Override
    public void registrarVenta(Venta venta, List<DetalleVenta> detalles) throws SQLException {

        String sqlVenta = "INSERT INTO ventas (fecha_hora, medio_pago, total) VALUES (datetime('now', 'localtime'), ?, ?)";
        String sqlDetalle = "INSERT INTO detalle_ventas (cantidad, precio_unitario, producto_id, venta_id) VALUES (?, ?, ?, ?)";


        try (Connection conn = DatabaseConnection.conectar()) {


            conn.setAutoCommit(false);

            long ventaId = -1;


            try (PreparedStatement stmtVenta = conn.prepareStatement(sqlVenta, Statement.RETURN_GENERATED_KEYS)) {
                stmtVenta.setString(1, venta.getMedio_pago());
                stmtVenta.setDouble(2, venta.getTotal());
                stmtVenta.executeUpdate();


                try (ResultSet generatedKeys = stmtVenta.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        ventaId = generatedKeys.getLong(1);
                    } else {
                        throw new SQLException("Error al crear la venta, no se pudo obtener el ID.");
                    }
                }
            }


            try (PreparedStatement stmtDetalle = conn.prepareStatement(sqlDetalle)) {
                for (DetalleVenta detalle : detalles) {

                    stmtDetalle.setInt(1, detalle.getCantidad());
                    stmtDetalle.setDouble(2, detalle.getPrecioUnitario());
                    stmtDetalle.setInt(3, detalle.getProductoId());
                    stmtDetalle.setLong(4, ventaId);

                    stmtDetalle.addBatch();
                }

                stmtDetalle.executeBatch();
            }


            conn.commit();

        } catch (SQLException e) {

            throw e;
        }
    }
}