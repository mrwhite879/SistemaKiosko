package com.kiosko.model;

public class Producto {
    private int id;
    private String nombre;
    private String codigo_barra;
    private String presentacion;
    private double precio;

    public Producto() {
    }

    public Producto(int id, String nombre, String codigo_barra, String presentacion, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.codigo_barra = codigo_barra;
        this.presentacion = presentacion;
        this.precio = precio;
    }

    public Producto(String nombre, String codigo_barra, String presentacion, double precio) {
        this.nombre = nombre;
        this.codigo_barra = codigo_barra;
        this.presentacion = presentacion;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo_barra() {
        return codigo_barra;
    }

    public void setCodigo_barra(String codigo_barra) {
        this.codigo_barra = codigo_barra;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
