/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import controller.FrontController;
import model.Datos;
import view.MainJFrame;


/**
 *
 * @author dam2_alu05@inf.ald
 */
public class Main {
    public static void main(String[] args) {
        MainJFrame mainview = new MainJFrame();
        Datos model = new Datos();
        FrontController fc= new FrontController(mainview,model);
        mainview.setVisible(true);
    }
}
