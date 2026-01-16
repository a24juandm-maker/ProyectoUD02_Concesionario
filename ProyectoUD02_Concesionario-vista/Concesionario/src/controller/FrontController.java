/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Datos;
import view.MainJFrame;

/**
 *
 * @author dam2_alu05@inf.ald
 */
public class FrontController {
    private MainJFrame view;
    private Datos model;
    
    
    
    public FrontController(MainJFrame view,Datos model){
        this.view=view;
        this.model=model;
    }
}
