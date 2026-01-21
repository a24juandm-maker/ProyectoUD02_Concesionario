/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Coches;

import model.ConexionBD;
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
        //this.view.addCancelarCochesMenuItemListener(this.getCancelarActionListener());
    }

    
}
