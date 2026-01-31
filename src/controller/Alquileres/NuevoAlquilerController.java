/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Alquileres;

import controller.Cliente.ClienteController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JOptionPane;
import model.ConexionBD;
import view.Alquileres.NuevoAlquilerJDialog;
import view.NuevoCliente.NuevoClienteJDialog;

/**
 *
 * @author alumno
 */
public class NuevoAlquilerController {

    NuevoAlquilerJDialog view;
    ConexionBD model;
    AlquileresController ac;

    public NuevoAlquilerController(NuevoAlquilerJDialog view, ConexionBD model, AlquileresController ac) {
        this.view = view;
        this.model = model;
        this.ac = ac;
        this.view.addNuevoAlquilerMenuItemListener(this.getNuevoAlquilerActionListener());
        this.view.addCancelarVentaMenuItemListener(this.getCancelarActionListener());
        this.view.addNuevoClienteMenuItemListener(this.getNuevoClienteActionListener());
    }

    private ActionListener getNuevoAlquilerActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                String nombreVendedor = view.getVendedor();
                String nombreCliente = view.getCliente();
                String matricula = view.getMatricula();
                LocalDate fechaAlquiler = view.getFechaAlquiler();
                LocalDate fechaDevolucion = view.getFechaDevolucion();
                if ((nombreVendedor.isEmpty() || nombreCliente.isEmpty() || matricula.isEmpty())) {
                    JOptionPane.showMessageDialog(view, "Introduzca todos los datos", "Introduzca todos los datos", 0);
                    return;
                }
                int id_Cliente = model.obtenerIDCliente(nombreCliente);
                int id_empleado = model.obtenerIDEmpleado(nombreVendedor);
                int id_coche = model.obtenerIDCoche(matricula);
                boolean disponibilidad = model.disponibilidadCoche(id_coche);
                if (!disponibilidad) {
                    JOptionPane.showMessageDialog(view, "El coche no esta disponible", "El coche no esta disponible", 0);
                    view.dispose();

                } else {
                    boolean alquiler = model.crearAlquiler(fechaAlquiler, fechaDevolucion, id_coche, id_Cliente, id_empleado);
                    if (alquiler) {
                        model.actualizarEstadoCocheVenta(id_coche);
                        ac.updateTableView();
                        JOptionPane.showMessageDialog(view, "Alquiler creado con exito", "Alquiler creado con exito", 1);
                        view.dispose();
                    } else {
                        JOptionPane.showMessageDialog(view, "Error en la creacion del alquiler", "Error en la creacion del alquiler", 0);

                    }
                }

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

    private ActionListener getNuevoClienteActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NuevoClienteJDialog nc = new NuevoClienteJDialog(view, true);
                ClienteController cc = new ClienteController(nc, model);
                nc.setVisible(true);

            }
        };
        return al;
    }

}
