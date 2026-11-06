package com.kiosko.dao;
import com.kiosko.model.Producto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public interface ProductoDAO {
    void insertar(Producto producto);


}

