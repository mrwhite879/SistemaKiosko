package com.kiosko.model;

public class Venta {
    private long id;
    private String fecha_hora;
    private String medio_pago;
    private double total;

    public Venta() {
    }

    public Venta(long id, String fecha_hora, String medio_pago, double total) {
        this.id = id;
        this.fecha_hora = fecha_hora;
        this.medio_pago = medio_pago;
        this.total = total;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public String getMedio_pago() {
        return medio_pago;
    }

    public void setMedio_pago(String medio_pago) {
        this.medio_pago = medio_pago;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
