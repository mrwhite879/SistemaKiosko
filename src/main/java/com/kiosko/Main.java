package com.kiosko;


import com.kiosko.dao.DatabaseConnection;
import com.kiosko.dao.ProductoDAO;
import com.kiosko.dao.ProductoDAOImpl;
import com.kiosko.model.Producto;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DatabaseConnection.inicializarBaseDeDatos();
    }

}