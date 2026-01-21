/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Ventas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import model.ConexionBD;
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
        this.view.addCancelarVentaMenuItemListener(this.getCancelarActionListener());
    }
     private ActionListener getNuevaVentaActionListener(){
        ActionListener al = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
               NuevaVentaJDialog nv=new NuevaVentaJDialog(view,true);
               NuevaVentaController tvc=new NuevaVentaController(nv,model);
               nv.setVisible(true);
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
