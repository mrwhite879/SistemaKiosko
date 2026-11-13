package com.kiosko.dao;

import com.kiosko.model.RetiroCaja;

import java.sql.SQLException;

public interface RetiroCajaDAO {
    void registrarRetiro(RetiroCaja retiro) throws SQLException;
}
