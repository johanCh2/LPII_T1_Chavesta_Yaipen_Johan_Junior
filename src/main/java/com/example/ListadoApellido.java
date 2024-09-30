package com.example;

import conexion.Conexion; 
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListadoApellido extends JFrame {

    private JTable comprasTable;
    private DefaultTableModel tableModel;

    public ListadoApellido() {
        
        setTitle("Listado de Compras - Fábrica de Calzado");
        setLayout(new BorderLayout());

        tableModel = new DefaultTableModel();
        comprasTable = new JTable(tableModel);
        
        tableModel.addColumn("Nro Compra");
        tableModel.addColumn("Fecha");
        tableModel.addColumn("Nombre del Producto");
        tableModel.addColumn("Nro Proveedor");
        tableModel.addColumn("Total");

        cargarDatosDeCompras();

        JScrollPane scrollPane = new JScrollPane(comprasTable);
        add(scrollPane, BorderLayout.CENTER);

        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private void cargarDatosDeCompras() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.conectar();
            String sql = "SELECT ci.nro_compra, ci.fecha, i.descripcion AS nombre_producto, ci.id_proveedor, ci.total " +
                         "FROM compra_ins ci " +
                         "JOIN detalleins di ON ci.nro_compra = di.nro_compra " +
                         "JOIN insumos i ON di.id_insumo = i.id_insumo";

            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int nroCompra = rs.getInt("nro_compra");
                String fecha = rs.getString("fecha");
                String nombreProducto = rs.getString("nombre_producto");
                int nroProveedor = rs.getInt("id_proveedor");
                double total = rs.getDouble("total");

                tableModel.addRow(new Object[]{nroCompra, fecha, nombreProducto, nroProveedor, total});
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new ListadoApellido();
    }
}
