/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Alquileres;

import controller.Alquileres.NuevoAlquilerController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    }
     private ActionListener getNuevoAlquilerActionListener(){
        ActionListener al = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
               NuevoAlquilerJDialog na=new NuevoAlquilerJDialog(view,true);
               NuevoAlquilerController tvc=new NuevoAlquilerController(na,model);
               na.setVisible(true);
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
