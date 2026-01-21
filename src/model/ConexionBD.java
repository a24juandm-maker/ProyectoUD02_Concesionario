/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.lang.System.Logger.Level;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

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

    public List<Object> listarVentas() {
        List<Object> ventas = new ArrayList();
        try {
            String sentenciaSQL = "SELECT e.nombre,cl.nombre,c.matricula,c.modelo,fecha_venta FROM venta v \n"
                    + "JOIN empleado e on e.id_empleado = v.id_empleado \n"
                    + "JOIN cliente cl on cl.id_cliente=v.id_cliente\n"
                    + "JOIN coche c on c.id_coche=v.id_coche;";
            PreparedStatement sentencia = null;
            ResultSet resultado = null;

            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                try {
                    System.out.println("-----------------------------");
                    ventas.add(resultado.getString(1));
                    ventas.add(resultado.getString(2));
                    ventas.add(resultado.getString(3));
                    ventas.add(resultado.getString(4));
                    ventas.add(resultado.getString(5));
                    System.out.println("-----------------------------");
                } catch (SQLException ex) {
                    System.getLogger(ConexionBD.class.getName()).log(Level.ERROR, (String) null, ex);
                }

            }
        } catch (SQLException ex) {
            System.getLogger(ConexionBD.class.getName()).log(Level.ERROR, (String) null, ex);
        }
        return ventas;
    }

    public void listarAlquileres() {
        try {
            String sentenciaSQL = "SELECT e.nombre,cl.nombre,c.matricula,fecha_alquiler,fecha_devolucion FROM alquila a JOIN empleado e on e.id_empleado = a.id_empleado JOIN cliente cl on cl.id_cliente=a.id_cliente JOIN coche c on c.id_coche=a.id_coche";

            PreparedStatement sentencia = null;
            ResultSet resultado = null;

            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                try {
                    System.out.println("-----------------------------");
                    System.out.println("Nombre vendedor->" + resultado.getString(1));
                    System.out.println("Nombre cliente->" + resultado.getString(2));
                    System.out.println("Matricula->" + resultado.getString(3));
                    System.out.println("Modelo->" + resultado.getString(4));
                    System.out.println("Fecha->" + resultado.getString(5));
                    System.out.println("Fecha devoulcion->" + resultado.getString(5));
                    System.out.println("-----------------------------");
                } catch (SQLException ex) {
                    System.getLogger(ConexionBD.class.getName()).log(Level.ERROR, (String) null, ex);
                }

            }
        } catch (SQLException ex) {
            System.getLogger(ConexionBD.class.getName()).log(Level.ERROR, (String) null, ex);
        }

    }

    public void listarCoches() {
        try {
            String sentenciaSQL = "SELECT c.imagen, c.modelo, c.matricula,c.color,c.disponibilidad,f.nombre,f.pais,c.precio FROM coche c JOIN fabrica f ON c.id_fabricacion=f.id_fabrica;";
            PreparedStatement sentencia = null;
            ResultSet resultado = null;

            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                try {
                    System.out.println("-----------------------------");
                    System.out.println("Imagen->" + resultado.getString(1));
                    System.out.println("Modelo->" + resultado.getString(2));
                    System.out.println("Matricula->" + resultado.getString(3));
                    System.out.println("Color->" + resultado.getString(4));
                    System.out.println("Disponibilidad->" + resultado.getString(5));
                    System.out.println("Nombre->" + resultado.getString(6));
                    System.out.println("Pais->" + resultado.getString(7));
                    System.out.println("Precio->" + resultado.getString(8));
                    System.out.println("-----------------------------");
                } catch (SQLException ex) {
                    System.getLogger(ConexionBD.class.getName()).log(Level.ERROR, (String) null, ex);
                }

            }
        } catch (SQLException ex) {
            System.getLogger(ConexionBD.class.getName()).log(Level.ERROR, (String) null, ex);
        }
    }
//Hay que cambiarlo

    public boolean crearVenta(LocalDate fecha, int id_coche, int id_comprador, int id_venta) {

        String sentenciaSql = "INSERT INTO VENTA\n"
                + "(fecha_venta, id_coche, id_cliente, id_empleado)\n"
                + "VALUES\n"
                + "(?,?,?,?)";
        PreparedStatement sentencia = null;
        try {
            sentencia = conexion.prepareStatement(sentenciaSql);
            sentencia.setDate(1, Date.valueOf(fecha));
            sentencia.setInt(2, id_coche);
            sentencia.setInt(3, id_comprador);
            sentencia.setInt(4, id_venta);

            sentencia.executeUpdate();
            return true;
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            return false;
        }
        

    }

    public void crearAlquiler(Alquila a) {

        String sentenciaSql = "INSERT INTO ALQUILA\n"
                + "(fecha_alquiler,fecha_devolucion, id_coche, id_cliente, id_empleado)\n"
                + "VALUES\n"
                + "(?,?,?,?,?)";
        PreparedStatement sentencia = null;
        try {
            sentencia = conexion.prepareStatement(sentenciaSql);
            sentencia.setDate(1, (Date) a.getFecha_alquiler());
            sentencia.setDate(2, (Date) a.getFecha_devolucion());
            sentencia.setInt(3, a.getId_coche());
            sentencia.setInt(4, a.getId_cliente());
            sentencia.setInt(5, a.getId_empleado());

            sentencia.executeUpdate();
        } catch (SQLException sqle) {
        }

    }

    public boolean verificarUsuario(String user, String pass) {

        String sentenciaSQL = "SELECT usuario,contrasenha FROM empleado WHERE usuario=? AND contrasenha=?";
        try {
            PreparedStatement sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setString(1, user);
            sentencia.setString(2, pass);

            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {

                String usuario = resultado.getString(1);
                String password = resultado.getString(2);
                if (usuario.equals(user) && password.equals(pass)) {
                    return true;
                }

            }
        } catch (SQLException ex) {
            System.getLogger(ConexionBD.class.getName()).log(Level.ERROR, (String) null, ex);
        }
        return false;

    }

    public boolean crearEmpleado(String nombre, String nif, String usuario, String pass) {
        String sentenciaSQL = "INSERT INTO EMPLEADO (NIF,nombre,usuario,contrasenha) VALUES (?,?,?,?)";
        PreparedStatement sentencia = null;
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setString(1, nif);
            sentencia.setString(2, nombre);
            sentencia.setString(3, usuario);
            sentencia.setString(4, pass);
            sentencia.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.getLogger(ConexionBD.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } finally {
            if (sentencia != null) {
                try {
                    sentencia.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public int obtenerIDEmpleado(String nombre) {
        try {
            String sentenciaSQL = "SELECT id_empleado FROM empleado where nombre=?;";
            PreparedStatement sentencia = null;
            ResultSet resultado = null;

            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setString(1, nombre);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                try {
                    return resultado.getInt(1);
                } catch (SQLException ex) {
                    System.getLogger(ConexionBD.class.getName()).log(Level.ERROR, (String) null, ex);
                }

            }
        } catch (SQLException ex) {
            System.getLogger(ConexionBD.class.getName()).log(Level.ERROR, (String) null, ex);
        }
        return 0;
    }

    public int obtenerIDCliente(String nombre) {
        try {
            String sentenciaSQL = "SELECT id_cliente FROM cliente where nombre=?;";
            PreparedStatement sentencia = null;
            ResultSet resultado = null;

            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setString(1, nombre);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                try {
                    return resultado.getInt(1);
                } catch (SQLException ex) {
                    System.getLogger(ConexionBD.class.getName()).log(Level.ERROR, (String) null, ex);
                }

            }
        } catch (SQLException ex) {
            System.getLogger(ConexionBD.class.getName()).log(Level.ERROR, (String) null, ex);
        }
        return 0;
    }

    public int obtenerIDCoche(String matricula) {
        try {
            String sentenciaSQL = "SELECT id_coche FROM coche where matricula=?;";
            PreparedStatement sentencia = null;
            ResultSet resultado = null;

            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setString(1, matricula);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                try {
                    return resultado.getInt(1);
                } catch (SQLException ex) {
                    System.getLogger(ConexionBD.class.getName()).log(Level.ERROR, (String) null, ex);
                }

            }
        } catch (SQLException ex) {
            System.getLogger(ConexionBD.class.getName()).log(Level.ERROR, (String) null, ex);
        }
        return 0;
    }

    public int getIdVenta() {
        try {
            String sentenciaSQL = "SELECT COUNT(*) FROM VENTA;";
            PreparedStatement sentencia = null;
            ResultSet resultado = null;

            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                try {

                    return resultado.getInt(1);

                } catch (SQLException ex) {
                    System.getLogger(ConexionBD.class.getName()).log(Level.ERROR, (String) null, ex);
                }

            }
        } catch (SQLException ex) {
            System.getLogger(ConexionBD.class.getName()).log(Level.ERROR, (String) null, ex);
        }
        return 0;
    }

    public int getIdAlquila() {
        try {
            String sentenciaSQL = "SELECT COUNT(*) FROM ALQUILA;";
            PreparedStatement sentencia = null;
            ResultSet resultado = null;

            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                try {

                    return resultado.getInt(1);

                } catch (SQLException ex) {
                    System.getLogger(ConexionBD.class.getName()).log(Level.ERROR, (String) null, ex);
                }

            }
        } catch (SQLException ex) {
            System.getLogger(ConexionBD.class.getName()).log(Level.ERROR, (String) null, ex);
        }
        return 0;
    }

    public void actualizarEstadoCoche(int idCoche) {
String sentenciaSql = "UPDATE coche SET disponibilidad=false WHERE id_coche=?;";
        PreparedStatement sentencia = null;
        
        try {
            sentencia = conexion.prepareStatement(sentenciaSql);
            sentencia.setInt(1, idCoche);
             sentencia.executeUpdate();
            
        } catch (SQLException ex) {
            System.getLogger(ConexionBD.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } finally {
            if (sentencia != null) {
                try {
                    sentencia.close();
                    
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }

            }

        }
        
    }
    
    public boolean disponibilidadCoche(int idCoche) {

        String sentenciaSql = "SELECT disponibilidad FROM coche WHERE id_coche=?;";
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        try {
            sentencia = conexion.prepareStatement(sentenciaSql);
            sentencia.setInt(1, idCoche);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                return true;
            }
        } catch (SQLException ex) {
            System.getLogger(ConexionBD.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } finally {
            if (sentencia != null) {
                try {
                    sentencia.close();
                    resultado.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }

            }

        }
        return false;
    }

}
