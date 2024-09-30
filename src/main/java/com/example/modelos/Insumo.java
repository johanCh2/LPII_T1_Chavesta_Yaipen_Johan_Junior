package com.example.modelos;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Insumo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_insumo;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private double precio;

    @Column(nullable = false)
    private int stock_actual;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FrecuenciaCompra frecuencia_compra;

    @OneToMany(mappedBy = "insumo")
    private List<DetalleIns> detalles;

    public Insumo() {}

    public Insumo(String descripcion, double precio, int stock_actual, FrecuenciaCompra frecuencia_compra) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock_actual = stock_actual;
        this.frecuencia_compra = frecuencia_compra;
    }

    public int getId_insumo() {
        return id_insumo;
    }

    public void setId_insumo(int id_insumo) {
        this.id_insumo = id_insumo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock_actual() {
        return stock_actual;
    }

    public void setStock_actual(int stock_actual) {
        this.stock_actual = stock_actual;
    }

    public FrecuenciaCompra getFrecuencia_compra() {
        return frecuencia_compra;
    }

    public void setFrecuencia_compra(FrecuenciaCompra frecuencia_compra) {
        this.frecuencia_compra = frecuencia_compra;
    }

    public List<DetalleIns> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleIns> detalles) {
        this.detalles = detalles;
    }
}
