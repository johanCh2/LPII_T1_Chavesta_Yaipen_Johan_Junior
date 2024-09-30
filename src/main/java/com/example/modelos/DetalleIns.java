package com.example.modelos;

import javax.persistence.*;

@Entity
public class DetalleIns {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_detalle;

    @ManyToOne
    @JoinColumn(name = "nro_compra", nullable = false)
    private CompraIns compraIns;

    @ManyToOne
    @JoinColumn(name = "id_insumo", nullable = false)
    private Insumo insumo;

    @Column(nullable = false)
    private int cantidad;

    public DetalleIns() {}

    public DetalleIns(CompraIns compraIns, Insumo insumo, int cantidad) {
        this.compraIns = compraIns;
        this.insumo = insumo;
        this.cantidad = cantidad;
    }

    // Getters y setters
    public int getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }

    public CompraIns getCompraIns() {
        return compraIns;
    }

    public void setCompraIns(CompraIns compraIns) {
        this.compraIns = compraIns;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
