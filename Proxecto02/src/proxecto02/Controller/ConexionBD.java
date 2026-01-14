/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proxecto02.Controller;


import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.*;

/**
 *
 * @author alumno
 */
public class ConexionBD {
    private Connection conexion;
       public ConexionBD() {
    }

    public void abrirConexion() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/proxecto02";
        conexion = DriverManager.getConnection(url, "root", "abc123.");
    }
      public void cerrarConexion() {
        
        try {
            if (conexion != null && !conexion.isClosed()) {
                try {
                    conexion.close();
                } catch (SQLException ex) {
                    System.getLogger(ConexionBD.class.getName()).log(Level.ERROR, (String) null, ex);
                }
            }
        } catch (SQLException ex) {
            System.getLogger(ConexionBD.class.getName()).log(Level.ERROR, (String) null, ex);
        }
        
    }
      public void listarVentas() {
        try {
            String sentenciaSQL = "SELECT e.nombre,cl.nombre,c.matricula,c.modelo,fecha_venta FROM venta v \n" +
"JOIN empleado e on e.id_empleado = v.id_empleado \n" +
"JOIN cliente cl on cl.id_cliente=v.id_cliente\n" +
"JOIN coche c on c.id_coche=v.id_coche;";
            PreparedStatement sentencia = null;
            ResultSet resultado = null;
            
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                try {
                    System.out.println("-----------------------------");
                    System.out.println("Nombre vendedor->" + resultado.getString(1));
                    System.out.println("Nombre cliente->" + resultado.getString(2));
                    System.out.println("Modelo->" + resultado.getString(3));
                    System.out.println("Matricula->" + resultado.getString(4));
                    System.out.println("Fecha->" + resultado.getString(5));
                    System.out.println("-----------------------------");
                } catch (SQLException ex) {
                    System.getLogger(ConexionBD.class.getName()).log(Level.ERROR, (String) null, ex);
                }
                
                
                
                
            }
        } catch (SQLException ex) {
            System.getLogger(ConexionBD.class.getName()).log(Level.ERROR, (String) null, ex);
        }

        }
      public void listarAlquileres() {
        try {
            String sentenciaSQL = "SELECT e.nombre,cl.nombre,c.matricula,c.imagen,fecha_alquiler,fecha_devolucion FROM alquila a JOIN empleado e on e.id_empleado = a.id_empleado JOIN cliente cl on cl.id_cliente=a.id_cliente JOIN coche c on c.id_coche=a.id_coche";

            PreparedStatement sentencia = null;
            ResultSet resultado = null;
            
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                try {
                    System.out.println("-----------------------------");
                    System.out.println("Nombre vendedor->" + resultado.getString(1));
                    System.out.println("Nombre cliente->" + resultado.getString(2));
                    System.out.println("Modelo->" + resultado.getString(3));
                    System.out.println("Matricula->" + resultado.getString(4));
                    System.out.println("Fecha->" + resultado.getString(5));
                    System.out.println("Fecha devolcion->" + resultado.getString(5));
                    System.out.println("-----------------------------");
                } catch (SQLException ex) {
                    System.getLogger(ConexionBD.class.getName()).log(Level.ERROR, (String) null, ex);
                }
                
                
                
                
            }
        } catch (SQLException ex) {
            System.getLogger(ConexionBD.class.getName()).log(Level.ERROR, (String) null, ex);
        }

        }
      public boolean verificarUsuario (String user,String pass){
          String usuario = null;
          String contra = null;
        try {
            String sentenciaSQL = "SELECT usuario, contrasenha FROM empleado;";
            PreparedStatement sentencia = null;
            ResultSet resultado = null;
            
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                try {
                    
                     usuario=  resultado.getString(1);
                     contra=  resultado.getString(2);
         
                } catch (SQLException ex) {
                    System.getLogger(ConexionBD.class.getName()).log(Level.ERROR, (String) null, ex);
                }
                
                
                
                
            }
        } catch (SQLException ex) {
            System.getLogger(ConexionBD.class.getName()).log(Level.ERROR, (String) null, ex);
        }
          if (usuario.equals(user)&&contra.equals(pass)) {
              return true;
          }
          else {
              return false;
          }
      }

    }

    
    

