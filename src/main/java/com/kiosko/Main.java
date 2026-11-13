package com.kiosko;


import com.kiosko.dao.*;

public class Main {
    public static void main(String[] args) {


        DatabaseConnection.inicializarBaseDeDatos();
        System.out.println("¡Base de datos lista para arrancar!");


    }
}