/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import model.ConexionBD;
import view.NuevoCliente.NuevoClienteJDialog;

/**
 *
 * @author frana
 */
public class ClienteController {

    ConexionBD model;
    NuevoClienteJDialog view;

    public ClienteController(NuevoClienteJDialog view, ConexionBD model) {
        this.model = model;
        this.view = view;
        this.view.addNuevoClienteItemListener(this.crearClienteButton());
        this.view.addCancelarMenuItemListener(this.getCancelarActionListener());
    }

    public ActionListener crearClienteButton() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String nombreCliente = view.getNombre();
                String Nif = view.getNif();
                String mail = view.getMail();
                String telefono = view.getTelefono();
                if ((Nif.isEmpty() || nombreCliente.isEmpty() || mail.isEmpty() || telefono.isEmpty())) {
                    JOptionPane.showMessageDialog(view, "Introduzca todos los datos", "Introduzca todos los datos", 0);
                    return;
                }
                if (model.existeCliente(Nif)) {
                    JOptionPane.showMessageDialog(view, "Usuario ya existente", "Usuario ya existente", 0);

                } else {
                    boolean cliente = model.crearCliente(Nif, nombreCliente, mail, telefono);
                    if (cliente) {
                        JOptionPane.showMessageDialog(view, "Cliente creado con exito", "Cliente creado con exito", 1);
                        view.dispose();
                    } else {
                        JOptionPane.showMessageDialog(view, "Error en la creacion del cliente", "Error en la creacion del cliente", 0);

                    }

                }
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
