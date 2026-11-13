package com.kiosko.dao;
import com.kiosko.model.RetiroCaja;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class RetiroCajaDAOImpl implements RetiroCajaDAO {
    public void registrarRetiro(RetiroCaja retiro) throws SQLException {
        String sql = "INSERT INTO retiros_caja (fecha_hora, monto, responsable, motivo) VALUES (datetime('now', 'localtime'), ?, ?, ?)";

        try (Connection conn = DatabaseConnection.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, retiro.getMonto());
            stmt.setString(2, retiro.getResponsable());
            stmt.setString(3, retiro. getMotivo());

            stmt.executeUpdate();
        }
    }
}
