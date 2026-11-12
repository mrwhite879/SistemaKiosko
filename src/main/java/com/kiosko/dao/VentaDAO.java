package com.kiosko.dao;

import com.kiosko.model.DetalleVenta;
import com.kiosko.model.Venta;

import java.sql.SQLException;
import java.util.List;

public interface VentaDAO {
    void registrarVenta(Venta venta, List<DetalleVenta> detalles) throws SQLException;
}
