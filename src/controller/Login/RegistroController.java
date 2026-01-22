/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.ConexionBD;
import view.user.UserJDialog;

/**
 *
 * @author frana
 */
public class RegistroController {

    UserJDialog view;
    ConexionBD model;

    public RegistroController(UserJDialog view, ConexionBD model) {
        this.view = view;
        this.model = model;
        this.view.addActionListenerCancelarButton(this.getCancelActionListener());
        this.view.addActionListenerSaveButton(this.getSaveActionListener());
    }

    private ActionListener getSaveActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String usuario = view.getUsuario();
                String nombre = view.getNombre();
                String contraseña = view.getContraseña();
                String nif = view.getNIF();
                if (usuario.isEmpty() || nombre.isEmpty() || nif.isEmpty() || contraseña.isEmpty()) {
                    JOptionPane.showMessageDialog(view, "Introduzca ambos datos del formulario", "Introduzca ambos datos del formulario", 0);
                    return;
                }
                boolean correcto = model.crearEmpleado(nombre, nif, usuario, contraseña);
                if (correcto) {
                   JOptionPane.showMessageDialog(view, "Usuario creado con exito", "Usuario creado con exito", 1);
                    
                } else {
                    JOptionPane.showMessageDialog(view, "Usuario ya existente", "Usuario ya existente", 0);

                }
                view.dispose();
            }
        };
        return al;
    }

    public ActionListener getCancelActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        };
        return al;
    }
}
