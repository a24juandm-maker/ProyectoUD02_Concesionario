/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Alquileres;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import model.ConexionBD;
import view.Alquileres.NuevoAlquilerJDialog;


/**
 *
 * @author alumno
 */
public class NuevoAlquilerController {
    NuevoAlquilerJDialog view;
    ConexionBD model;
    
    public NuevoAlquilerController(NuevoAlquilerJDialog view, ConexionBD model) {
        this.view = view;
        this.model = model;
        //this.view.AceptarButtonActionListener(this.getNuevoAlquilerActionListener());
        //this.view.CancelarButtonActionListener(this.getCancelarActionListener());
    }
    
    /*private ActionListener getNuevoAlquilerActionListener(){
        ActionListener al = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                String nombreVendedor=view.getVendedor();
                String nombreCliente=view.getCliente();
                String matricula= view.getMatricula();
                LocalDate fechaAlquiler=view.getFechaAlquiler();
                LocalDate fechaDevolucion=view.getFechaDevolucion();
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
                 boolean alquiler=model.crearAlquiler(fechaAlquiler,fechaDevolucion, id_coche, id_Cliente, id_empleado);
                  if (alquiler) {
                      model.actualizarEstadoCoche(id_coche);
                    JOptionPane.showMessageDialog(view, "Alquiler creado con exito", "Alquiler creado con exito", 0);
                    view.dispose();
                } else {
                    JOptionPane.showMessageDialog(view, "Error en la creacion del alquiler", "Error en la creacion del alquiler", 0);

                }}
                
               
        }
    };
        return al;
    }**/
    
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
