/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.Alquileres.AlquileresController;
import controller.Coches.CochesController;
import controller.Login.LoginController;
import controller.Ventas.VentasController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.ConexionBD;
import view.Alquileres.TablaAlquileresJDialog;
import view.Coches.TablaCochesJDialog;

import view.MainJFrame;
import view.Ventas.TablaVentasJDialog;
import view.user.LoginJDialog;

/**
 *
 * @author dam2_alu05@inf.ald
 */
public class FrontController {

    private MainJFrame view;
    private ConexionBD model;
    
   

    public FrontController(MainJFrame view, ConexionBD model) {
        this.view = view;
        this.model = model;
        
        this.view.addcochesJJMenuItemListener(this.getCochesActionListener());
        this.view.addAlquilerJMenuItemListener(this.getAlquileresActionListener());
        this.view.addVentasMenuItemListener(this.getVentasActionListener());
        this.view.addLoginMenuItemListener(this.getLoginActionListener());
        this.view.addEditMenuItemListener(this.getNewPassActionListener());
    }

    private ActionListener getVentasActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                TablaVentasJDialog tv = new TablaVentasJDialog(view, true);
                VentasController vc = new VentasController(tv, model);
                tv.setVisible(true);

            }
        };
        return al;
    }

    private ActionListener getAlquileresActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                TablaAlquileresJDialog ta = new TablaAlquileresJDialog(view, true);
                AlquileresController vc = new AlquileresController(ta, model);
                ta.setVisible(true);

            }
        };
        return al;
    }

    private ActionListener getCochesActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                TablaCochesJDialog tc = new TablaCochesJDialog(view, true);
                CochesController cc = new CochesController(tc, model);
                tc.setVisible(true);

            }
        };
        return al;
    }

    private ActionListener getLoginActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                LoginJDialog ld = new LoginJDialog(view, true);
                LoginController lc = new LoginController(ld, model, view);
                ld.setVisible(true);
            }
        };
        return al;

    }
    private ActionListener getNewPassActionListener(){
    
    ActionListener al= new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            String newPass=view.getNuevaContraseña();
            String usuario=view.getUsuario();
            boolean cambio=model.cambiarContraseña(newPass,usuario);
            if (cambio) {
                JOptionPane.showMessageDialog(view, "Contraseña cambiada con exito", "Contraseña cambiada con exito", 1);
            }
            else{
            JOptionPane.showMessageDialog(view, "Error en el cambio de contraseña", "Error en el cambio de contraseña", 0);
            }
        }
    };
    return al;
    }
}
