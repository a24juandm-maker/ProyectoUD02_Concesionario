/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Coches;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import javax.swing.ImageIcon;
import model.ConexionBD;
import model.Venta;
import view.Coches.TablaCochesJDialog;

/**
 *
 * @author alumno
 */
public class CochesController {

    private final TablaCochesJDialog view;
    private final ConexionBD model;

    public CochesController(TablaCochesJDialog view, ConexionBD model) {
        this.view = view;
        this.model = model;
        updateTableView();
        this.view.CancelarCochesButtonActionListener(this.getCancelarActionListener());
    }

    public void updateTableView() {
        view.clearTable();
        List<Object[]> coches = model.listarCoches();
        for (Object[] c : coches) {
            if ((Boolean) c[4]) {
              Vector row = new Vector();
            String nombreImagen=(String) c[0];
            ImageIcon icon=model.obtenerImagenPorModelo(nombreImagen);
           
            row.add(icon);
            row.add(c[1]);
            row.add(c[2]);
            row.add(c[3]);
            row.add(c[4]);
            row.add(c[5]);
            row.add(c[6]);
            row.add(c[7]+"0 €");
            

            view.addRowTable(row);
        }
          
        }
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
