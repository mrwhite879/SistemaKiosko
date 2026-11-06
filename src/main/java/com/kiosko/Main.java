package com.kiosko;


import com.kiosko.dao.DatabaseConnection;

public class Main {
    public static void main(String[] args) {
        try {
            DatabaseConnection.conectar();
            System.out.println("Conexion exitosa");
        } catch (Exception e ) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
    }
}