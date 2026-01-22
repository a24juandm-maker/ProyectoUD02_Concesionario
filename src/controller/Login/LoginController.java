/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.ConexionBD;

import view.MainJFrame;
import view.user.LoginJDialog;
import view.user.UserJDialog;

/**
 *
 * @author frana
 */
public class LoginController {
    MainJFrame parentView;
    LoginJDialog view;
    ConexionBD model;
    private String usuario;
    
    public LoginController(LoginJDialog view, ConexionBD model, MainJFrame parentView) {
        this.view = view;
        this.model=model;
        this.parentView=parentView;
        this.view.addCancelMenuItemListener(this.pressCancelButton());
        this.view.addRegistrarseMenuItemListener(this.pressRegistrarseButton());
        this.view.addLoginButtonItemListener(this.pressLoginButton());
        
    }
    public String getUsuario(){
        return usuario;
    }
    
    private ActionListener pressCancelButton() {
        
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                view.dispose();
            }
        };
        return al;
    }
     private ActionListener pressRegistrarseButton(){
        ActionListener al = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
               UserJDialog ud=new UserJDialog(view,true);
               RegistroController rc=new RegistroController(ud,model);
               ud.setVisible(true);
        }
    };
        return al;
    }
      private ActionListener pressLoginButton(){
        ActionListener al = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
              String user= view.getUsuario();
              usuario=user;
              String pass= view.getContraseña();
                if (user.isEmpty()||pass.isEmpty()) {
                    JOptionPane.showMessageDialog(view, "Introduzca ambos datos del formulario","Introduzca ambos datos del formulario", 0);
                    return;
                }
                boolean login=model.verificarUsuario(user, pass);
                if (login) {
                    parentView.LoginU(user);
                    view.dispose();
                    parentView.Login();
                   
                }
                else{
                 JOptionPane.showMessageDialog(view, "Datos incorrectos","Datos incorrectos", 0);
                    return;
                }
                
        }
    };
        return al;
    }
}
