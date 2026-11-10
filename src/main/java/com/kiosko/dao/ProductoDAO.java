package com.kiosko.dao;
import com.kiosko.model.Producto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ProductoDAO {
    void insertar(Producto producto);
    Producto buscarPorCodigoBarra(String codigo_barra);
    ArrayList<Producto> listarTodos();
    void actualizarPrecio(String codigo_barra, double nuevoPrecio);
}

