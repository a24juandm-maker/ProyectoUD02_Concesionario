/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Ventas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JOptionPane;
import model.ConexionBD;
import model.Venta;
import view.MainJFrame;
import view.Ventas.NuevaVentaJDialog;
import view.user.LoginJDialog;

/**
 *
 * @author frana
 */
public class NuevaVentaController {
     
    NuevaVentaJDialog view;
    ConexionBD model;

    public NuevaVentaController(NuevaVentaJDialog view, ConexionBD model) {
        this.view = view;
        this.model = model;
        this.view.AceptarButtonActionListener(this.getNuevaVentaActionListener());
        this.view.CancelarButtonActionListener(this.getCancelarActionListener());
    }
    
     private ActionListener getNuevaVentaActionListener(){
        ActionListener al = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                String nombreVendedor=view.getVendedor();
                String nombreCliente=view.getCliente();
                String matricula= view.getMatricula();
                LocalDate fechaventa=view.getFechaVenta();
                if ((nombreVendedor.isEmpty()||nombreCliente.isEmpty()||matricula.isEmpty())) {
                    JOptionPane.showMessageDialog(view, "Introduzca todos los datos", "Introduzca todos los datos", 0);
                    return;
                }
                int id_Cliente=model.obtenerIDCliente(nombreCliente);
                int id_empleado=model.obtenerIDEmpleado(nombreVendedor);
                int id_coche=model.obtenerIDCoche(matricula);
                boolean disponibilidad=model.disponibilidadCoche(id_coche);
                if (!disponibilidad) {
                     JOptionPane.showMessageDialog(view, "El coche no esta disponible", "El coche no esta disponible", 0);
                    view.dispose();
                    
                }
                else{
                 boolean venta=model.crearVenta(fechaventa, id_coche, id_Cliente, id_empleado);
                  if (venta) {
                      model.actualizarEstadoCoche(id_coche);
                    JOptionPane.showMessageDialog(view, "Venta creada con exito", "Venta creada con exito", 0);
                    view.dispose();
                } else {
                    JOptionPane.showMessageDialog(view, "Error en la creacion de la venta", "Error en la creacion de la venta", 0);

                }}
                
               
        }
    };
        return al;
    }
     private ActionListener getCancelarActionListener(){
        ActionListener al = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
              view.dispose();
        }
    };
        return al;
    }
    
    
}
