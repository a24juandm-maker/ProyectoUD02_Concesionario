/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proxecto02;

import proxecto02.Controller.ConexionBD;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Proxecto02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ConexionBD cbd= new ConexionBD();
        cbd.abrirConexion();
            Scanner sc= new Scanner (System.in);
            System.out.println("Usuario");
            String usuario=sc.next();
            System.out.println("Contraseña");
            String passwd=sc.next();
            System.out.println(cbd.verificarUsuario(usuario, passwd));
            
            
           /* cbd.listarVentas();
            System.out.println("");
            cbd.listarAlquileres();*/
        
    }
    
}
