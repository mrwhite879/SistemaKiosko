package com.kiosko.model;

public class Venta {
    private long id;
    private String fecha_hora;
    private double monto_efectivo;
    private double monto_transferencia;
    private double total;

    public Venta() {
    }

    public Venta(long id, String fecha_hora, double monto_efectivo, double monto_transferencia, double total) {
        this.id = id;
        this.fecha_hora = fecha_hora;
        this.monto_efectivo = monto_efectivo;
        this.monto_transferencia = monto_transferencia;
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

    public double getMonto_efectivo() {
        return monto_efectivo;
    }

    public void setMonto_efectivo(double monto_efectivo) {
        this.monto_efectivo = monto_efectivo;
    }

    public double getMonto_transferencia() {
        return monto_transferencia;
    }

    public void setMonto_transferencia(double monto_transferencia) {
        this.monto_transferencia = monto_transferencia;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
