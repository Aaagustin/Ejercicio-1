package com.restorant.platos.model;

public class Plato {

    private Integer numeroPlato;
    private String nombre;
    private Double precio;
    private String descripcion;

    public Plato() {
    }

    public Plato(Integer numeroPlato, String nombre, Double precio, String descripcion) {
        this.numeroPlato = numeroPlato;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public Integer getNumeroPlato() {
        return numeroPlato;
    }

    public void setNumeroPlato(Integer numeroPlato) {
        this.numeroPlato = numeroPlato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
