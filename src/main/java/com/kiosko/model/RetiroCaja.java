package com.kiosko.model;

public class RetiroCaja {
    private int id;
    private String fechaHora;
    private double monto;
    private String responsable;
    private String motivo;

    public RetiroCaja() {}

    public RetiroCaja(String fechaHora, double monto, String responsable, String motivo) {
        this.fechaHora = fechaHora;
        this.monto = monto;
        this.responsable = responsable;
        this.motivo = motivo;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFechaHora() { return fechaHora; }
    public void setFechaHora(String fechaHora) { this.fechaHora = fechaHora; }

    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }

    public String getResponsable() { return responsable; }
    public void setResponsable(String responsable) { this.responsable = responsable; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
}
