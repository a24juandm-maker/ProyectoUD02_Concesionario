/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Ventas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import model.ConexionBD;
import model.Venta;
import view.Ventas.NuevaVentaJDialog;

import view.Ventas.TablaVentasJDialog;

/**
 *
 * @author dam2_alu05@inf.ald
 */
public class VentasController {

    private final TablaVentasJDialog view;
    private final ConexionBD model;

    public VentasController(TablaVentasJDialog view, ConexionBD model) {
        this.view = view;
        this.model = model;
        this.view.addNuevaVentaMenuItemListener(this.getNuevaVentaActionListener());
        this.view.addCancelarMenuItemListener(this.getCancelarActionListener());
        this.view.addBorrarButtonMenuItemListener(this.getBorrarActionListener());
        this.updateTableView();
    }

    private ActionListener getNuevaVentaActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                NuevaVentaJDialog nv = new NuevaVentaJDialog(view, true);
                NuevaVentaController tvc = new NuevaVentaController(nv, model, VentasController.this);
                nv.setVisible(true);
            }
        };
        return al;
    }

    public void updateTableView() {
        view.clearTable();
        List<Venta> ventas = model.listarVentas();
        for (Venta v : ventas) {
            Vector row = new Vector();
            row.add(model.getNombreEmpleado(v.getId_empleado()));
            row.add(model.getNombreCliente(v.getId_cliente()));
            row.add(model.getMatricula(v.getId_coche()));
            row.add(v.getFecha_venta());

            view.addRowTable(row);
        }
    }

    private ActionListener getCancelarActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                view.dispose();
            }
        };
        return al;
    }

    private ActionListener getBorrarActionListener() {

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String matricula=view.getSelectedItem();
               int idVenta=model.getIdVenta(matricula);
               int id_coche=model.obtenerIDCoche(matricula);
               boolean venta=model.borrarVenta(idVenta);
                if (venta) {
                     JOptionPane.showMessageDialog(view, "Venta borrada con exito", "Venta borrada con exito", 1);
                     model.actualizarEstadoCocheDevolucion(id_coche);
                     updateTableView();
                }
                else{
                 JOptionPane.showMessageDialog(view, "No se pudo borrar", "No se pudo borrar", 0);
                }
            }
        };
        return al;
    }

}
