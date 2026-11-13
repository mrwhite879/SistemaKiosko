package com.kiosko.dao;

import com.kiosko.model.DetalleVenta;
import com.kiosko.model.Venta;

import java.sql.*;
import java.util.List;

public class VentaDAOImpl implements VentaDAO {

    @Override
    public void registrarVenta(Venta venta, List<DetalleVenta> detalles) throws SQLException {

        String sqlVenta = "INSERT INTO ventas (fecha_hora, monto_efectivo, monto_transferencia, total) VALUES (datetime('now', 'localtime'), ?, ?, ?)";
        String sqlDetalle = "INSERT INTO detalle_ventas (cantidad, precio_unitario, producto_id, venta_id) VALUES (?, ?, ?, ?)";
        Connection conn = null;

        try  {

            conn = DatabaseConnection.conectar();
            conn.setAutoCommit(false);

            long ventaId = -1;


            try (PreparedStatement stmtVenta = conn.prepareStatement(sqlVenta, Statement.RETURN_GENERATED_KEYS)) {
                stmtVenta.setDouble(1, venta.getMonto_efectivo());
                stmtVenta.setDouble(2, venta.getMonto_transferencia());
                stmtVenta.setDouble(3, venta.getTotal());
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
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }

            throw e;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException closeEx) {
                    closeEx.printStackTrace();
                }
            }
        }
    }
}