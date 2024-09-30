package com.example.modelos;

import java.io.Serializable;
import java.util.Objects;

public class DetalleInsId implements Serializable {
    
    private int nroCompra;
    private int idInsumo;

    public DetalleInsId(){}
    public DetalleInsId(int nroCompra, int idInsumo) {
        this.nroCompra = nroCompra;
        this.idInsumo = idInsumo;
    }

    // Getters y setters
    public int getNroCompra() {
        return nroCompra;
    }

    public void setNroCompra(int nroCompra) {
        this.nroCompra = nroCompra;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetalleInsId that = (DetalleInsId) o;
        return nroCompra == that.nroCompra && idInsumo == that.idInsumo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nroCompra, idInsumo);
    }
}
