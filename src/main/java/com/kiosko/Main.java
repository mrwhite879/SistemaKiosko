package com.kiosko;


import com.kiosko.dao.DatabaseConnection;
import com.kiosko.dao.ProductoDAO;
import com.kiosko.dao.ProductoDAOImpl;
import com.kiosko.model.Producto;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            DatabaseConnection.conectar();
            System.out.println("Conexion exitosa");
        } catch (Exception e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }

        Scanner teclado;
        teclado = new Scanner(System.in);
        System.out.println("Ingrese codigo de barra");
        String codigo_barra = teclado.nextLine();


        ProductoDAOImpl objeto = new ProductoDAOImpl();

        Producto producto = objeto.buscarPorCodigoBarra(codigo_barra);

        if (producto == null) {
            System.out.println("No hay productos con ese codigo barra");
        } else {
            System.out.println("Nombre: " + producto.getNombre() + " Precio: " + producto.getPrecio());
        }


        ArrayList<Producto> prod = objeto.listarTodos();

        for (Producto elemento : prod) {
            System.out.println("Nombre: " + elemento.getNombre() + " Precio: " + elemento.getPrecio() + " presentacion: " + elemento.getPresentacion());
        }

        System.out.println("Ingrese el codigo de barra para actualizar precio:");
        String cod = teclado.nextLine();
        System.out.println("Ingrese el nuevo precio");
        double nuev = teclado.nextDouble();

        objeto.actualizarPrecio(cod, nuev);
    }

}