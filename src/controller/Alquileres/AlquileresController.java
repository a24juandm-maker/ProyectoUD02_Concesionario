/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Alquileres;

import controller.Alquileres.NuevoAlquilerController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import model.Alquila;
import model.ConexionBD;

import view.Alquileres.NuevoAlquilerJDialog;
import view.Alquileres.TablaAlquileresJDialog;

/**
 *
 * @author alumno
 */
public class AlquileresController {

    private final TablaAlquileresJDialog view;
    private final ConexionBD model;

    public AlquileresController(TablaAlquileresJDialog view, ConexionBD model) {
        this.view = view;
        this.model = model;
        this.view.addNuevoAlquilerMenuItemListener(this.getNuevoAlquilerActionListener());
        this.view.addCancelarAlquilerMenuItemListener(this.getCancelarActionListener());
        this.view.addBorrarButtonMenuItemListener(this.getBorrarActionListener());
        updateTableView();
    }

    private ActionListener getNuevoAlquilerActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                NuevoAlquilerJDialog na = new NuevoAlquilerJDialog(view, true);
                NuevoAlquilerController tvc = new NuevoAlquilerController(na, model, AlquileresController.this);
                na.setVisible(true);
            }
        };
        return al;
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

    public void updateTableView() {
        view.clearTable();
        List<Alquila> alquileres = model.listarAlquileres();
        for (Alquila a : alquileres) {
            Vector row = new Vector();
            row.add(model.getNombreEmpleado(a.getId_empleado()));
            row.add(model.getNombreCliente(a.getId_cliente()));
            row.add(model.getMatricula(a.getId_coche()));
            row.add(a.getFecha_alquiler());
            row.add(a.getFecha_devolucion());

            view.addRowTable(row);
        }
    }

    private ActionListener getBorrarActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String matricula=view.getSelectedItem();
               int idAlquila=model.getIdAlquila(matricula);
               int id_coche=model.obtenerIDCoche(matricula);
               boolean alquila=model.borrarAlquila(idAlquila);
                if (alquila) {
                    JOptionPane.showMessageDialog(view, "Alquiler borrado con exito", "Alquiler borrado con exito", 1);
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
