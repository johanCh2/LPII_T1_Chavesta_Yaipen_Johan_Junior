package com.example;

import conexion.Conexion; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistroApellido extends JFrame {
    private JTextField idProveedorField;
    private JTextField idInsumoField;
    private JTextField cantidadField;
    private JTextField totalField;
    private JButton registrarButton;

    public RegistroApellido() {
        setTitle("Registro de Compras - Fábrica de Calzado");
        setLayout(new GridLayout(5, 2));

        JLabel idProveedorLabel = new JLabel("ID Proveedor:");
        idProveedorField = new JTextField();
        
        JLabel idInsumoLabel = new JLabel("ID Insumo:");
        idInsumoField = new JTextField();
        
        JLabel cantidadLabel = new JLabel("Cantidad:");
        cantidadField = new JTextField();
        
        JLabel totalLabel = new JLabel("Total:");
        totalField = new JTextField();
        
        registrarButton = new JButton("Registrar Compra");

        
        add(idProveedorLabel);
        add(idProveedorField);
        add(idInsumoLabel);
        add(idInsumoField);
        add(cantidadLabel);
        add(cantidadField);
        add(totalLabel);
        add(totalField);
        add(new JLabel()); 
        add(registrarButton);

       
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarCompra();
            }
        });

        
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    
    private void registrarCompra() {
        String idProveedor = idProveedorField.getText();
        String total = totalField.getText();
        String idInsumo = idInsumoField.getText();
        String cantidad = cantidadField.getText();
        
        if (idProveedor.isEmpty() || total.isEmpty() || idInsumo.isEmpty() || cantidad.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos deben estar completos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Connection conn = null;
        PreparedStatement psCompra = null;
        PreparedStatement psDetalle = null;

        try {
            
            conn = Conexion.conectar();

           
            String sqlCompra = "INSERT INTO compra_ins (id_proveedor, total) VALUES (?, ?)";
            psCompra = conn.prepareStatement(sqlCompra, PreparedStatement.RETURN_GENERATED_KEYS);
            psCompra.setInt(1, Integer.parseInt(idProveedor));
            psCompra.setDouble(2, Double.parseDouble(total));
            psCompra.executeUpdate();

           
            ResultSet generatedKeys = psCompra.getGeneratedKeys();
            int nroCompra = 0;
            if (generatedKeys.next()) {
                nroCompra = generatedKeys.getInt(1);
            }


            String sqlDetalle = "INSERT INTO detalleins (nro_compra, id_insumo, cantidad) VALUES (?, ?, ?)";
            psDetalle = conn.prepareStatement(sqlDetalle);
            psDetalle.setInt(1, nroCompra);
            psDetalle.setInt(2, Integer.parseInt(idInsumo));
            psDetalle.setInt(3, Integer.parseInt(cantidad));
            psDetalle.executeUpdate();

     
            JOptionPane.showMessageDialog(this, "Compra registrada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al registrar la compra", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (psCompra != null) psCompra.close();
                if (psDetalle != null) psDetalle.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new RegistroApellido();
    }
}
