package com.example.modelos;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_proveedor;

    @Column(nullable = false)
    private String razon_social;

    @Column(nullable = false)
    private String direccion;
    
    @OneToMany(mappedBy = "proveedor")
    private List<CompraIns> compras;

    public Proveedor() {}

    public Proveedor(String razon_social, String direccion) {
        this.razon_social = razon_social;
        this.direccion = direccion;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<CompraIns> getCompras() {
        return compras;
    }

    public void setCompras(List<CompraIns> compras) {
        this.compras = compras;
    }
}
