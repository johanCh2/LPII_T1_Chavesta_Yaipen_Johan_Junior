package com.example.modelos;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Entity
public class CompraIns {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nro_compra;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "id_proveedor", nullable = false)
    private Proveedor proveedor;

    @Column(nullable = false)
    private BigDecimal total;

    public CompraIns() {}

    public CompraIns(Proveedor proveedor, BigDecimal total) {
        this.proveedor = proveedor;
        this.total = total;
    }

    // Getters y setters
    public int getNro_compra() {
        return nro_compra;
    }

    public void setNro_compra(int nro_compra) {
        this.nro_compra = nro_compra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
