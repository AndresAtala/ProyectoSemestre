package com.gestionEmpresa.model;


public class Construccion {
    private String tipoConstruccion;
    private String construccionesAdicionales;
    private int cantidadProductos;
    private double presupuesto;

    public Construccion(String tipoConstruccion, String construccionesAdicionales, int cantidadProductos, double presupuesto) {
        this.tipoConstruccion = tipoConstruccion;
        this.construccionesAdicionales = construccionesAdicionales;
        this.cantidadProductos = cantidadProductos;
        this.presupuesto = presupuesto;
    }

    public String getTipoConstruccion() {
        return tipoConstruccion;
    }

    public void setTipoConstruccion(String tipoConstruccion) {
        this.tipoConstruccion = tipoConstruccion;
    }

    public String getConstruccionesAdicionales() {
        return construccionesAdicionales;
    }

    public void setConstruccionesAdicionales(String construccionesAdicionales) {
        this.construccionesAdicionales = construccionesAdicionales;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }
    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

}

