/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.Image;
import java.lang.System.Logger.Level;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

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

    public List<Venta> listarVentas() {
        List<Venta> ventas = new ArrayList<>();

        try {
            String sentenciaSQL = "SELECT e.id_empleado,cl.id_cliente,c.id_coche,fecha_venta FROM venta v JOIN empleado e on e.id_empleado = v.id_empleado JOIN cliente cl on cl.id_cliente=v.id_cliente JOIN coche c on c.id_coche=v.id_coche;";
            PreparedStatement sentencia = null;
            ResultSet resultado = null;

            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                try {

                    Venta v = new Venta();
                    v.setId_venta(this.getIdVenta() + 1);
                    v.setId_empleado(resultado.getInt(1));
                    v.setId_cliente(resultado.getInt(2));
                    v.setId_coche(resultado.getInt(3));
                    v.setFecha_venta(resultado.getDate(4));
                    ventas.add(v);

                } catch (SQLException ex) {
                    System.getLogger(ConexionBD.class.getName()).log(Level.ERROR, (String) null, ex);
                }

            }
        } catch (SQLException ex) {
            System.getLogger(ConexionBD.class.getName()).log(Level.ERROR, (String) null, ex);
        }
        return ventas;
    }

    public List<Alquila> listarAlquileres() {
        List<Alquila> alquileres = new ArrayList<>();
        try {
            String sentenciaSQL = "SELECT e.id_empleado,cl.id_cliente,c.id_coche,fecha_alquiler,fecha_devolucion FROM alquila a JOIN empleado e on e.id_empleado = a.id_empleado JOIN cliente cl on cl.id_cliente=a.id_cliente JOIN coche c on c.id_coche=a.id_coche";

            PreparedStatement sentencia = null;
            ResultSet resultado = null;

            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                try {
                    Alquila a = new Alquila();
                    a.setId_alquiler(getIdAlquila() + 1);
                    a.setId_empleado(resultado.getInt(1));
                    a.setId_cliente(resultado.getInt(2));
                    a.setId_coche(resultado.getInt(3));
                    a.setFecha_alquiler(resultado.getDate(4));
                    a.setFecha_devolucion(resultado.getDate(5));
                    alquileres.add(a);

                } catch (SQLException ex) {
                    System.getLogger(ConexionBD.class.getName()).log(Level.ERROR, (String) null, ex);
                }

            }
        } catch (SQLException ex) {
            System.getLogger(ConexionBD.class.getName()).log(Level.ERROR, (String) null, ex);
        }
        return alquileres;
    }

    public List<Object[]> listarCoches() {
        List<Object[]> coches = new ArrayList<>();
        try {
            String sentenciaSQL = "SELECT c.imagen, c.modelo, c.matricula,c.color,c.disponibilidad,f.nombre,f.pais,c.precio FROM coche c JOIN fabrica f ON c.id_fabricacion=f.id_fabrica;";
            PreparedStatement sentencia = null;
            ResultSet resultado = null;

            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                coches.add(new Object[]{
                    resultado.getString(1),
                    resultado.getString(2),
                    resultado.getString(3),
                    resultado.getString(4),
                    resultado.getBoolean(5),
                    resultado.getString(6),
                    resultado.getString(7),
                    resultado.getFloat(8)

                });

            }
        } catch (SQLException ex) {
            System.getLogger(ConexionBD.class.getName()).log(Level.ERROR, (String) null, ex);
        }
        return coches;
    }

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

            int cambio=sentencia.executeUpdate();
            return cambio>=1;
            
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            return false;
        }

    }

    public boolean crearAlquiler(LocalDate a, LocalDate fechaDevolucion, int id_coche, int id_cliente, int id_empleado) {

        String sentenciaSql = "INSERT INTO ALQUILA\n"
                + "(fecha_alquiler,fecha_devolucion, id_coche, id_cliente, id_empleado)\n"
                + "VALUES\n"
                + "(?,?,?,?,?)";
        PreparedStatement sentencia = null;
        try {
            sentencia = conexion.prepareStatement(sentenciaSql);
            sentencia.setDate(1, Date.valueOf(a));
            sentencia.setDate(2, Date.valueOf(fechaDevolucion));
            sentencia.setInt(3, id_coche);
            sentencia.setInt(4, id_cliente);
            sentencia.setInt(5, id_empleado);

             int cambio=sentencia.executeUpdate();
            return cambio>=1;
        } catch (SQLException sqle) {
            return false;
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
            int cambio=sentencia.executeUpdate();
            return cambio>=1;
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

    public boolean crearCliente(String NIF, String nombre, String mail, String telefono) {
        String sentenciaSQL = "INSERT INTO CLIENTE (id_cliente,NIF,nombre,telefono,mail) VALUES (?,?,?,?,?)";
        PreparedStatement sentencia = null;
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setInt(1, getIdCliente() + 1);
            sentencia.setString(2, NIF);
            sentencia.setString(3, nombre);
            sentencia.setString(4, telefono);
            sentencia.setString(5, mail);
             int cambio=sentencia.executeUpdate();
            return cambio>=1;
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

    public String getNombreCliente(int id) {
        try {
            String sentenciaSQL = "SELECT nombre FROM cliente WHERE id_cliente=?;";
            PreparedStatement sentencia = null;
            ResultSet resultado = null;

            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setInt(1, id);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                try {
                    return resultado.getString(1);
                } catch (SQLException ex) {
                    System.getLogger(ConexionBD.class.getName()).log(Level.ERROR, (String) null, ex);
                }

            }
        } catch (SQLException ex) {
            System.getLogger(ConexionBD.class.getName()).log(Level.ERROR, (String) null, ex);
        }

        return "";
    }

    public String getNombreEmpleado(int id) {
        try {
            String sentenciaSQL = "SELECT nombre FROM empleado WHERE id_empleado=?;";
            PreparedStatement sentencia = null;
            ResultSet resultado = null;

            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setInt(1, id);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                try {
                    return resultado.getString(1);
                } catch (SQLException ex) {
                    System.getLogger(ConexionBD.class.getName()).log(Level.ERROR, (String) null, ex);
                }

            }
        } catch (SQLException ex) {
            System.getLogger(ConexionBD.class.getName()).log(Level.ERROR, (String) null, ex);
        }

        return "";

    }

    public String getMatricula(int id) {
        try {
            String sentenciaSQL = "SELECT matricula FROM coche WHERE id_coche=?;";
            PreparedStatement sentencia = null;
            ResultSet resultado = null;

            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setInt(1, id);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                try {
                    return resultado.getString(1);
                } catch (SQLException ex) {
                    System.getLogger(ConexionBD.class.getName()).log(Level.ERROR, (String) null, ex);
                }

            }
        } catch (SQLException ex) {
            System.getLogger(ConexionBD.class.getName()).log(Level.ERROR, (String) null, ex);
        }

        return "";

    }

    public void actualizarEstadoCocheVenta(int idCoche) {
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

    public void actualizarEstadoCocheDevolucion(int idCoche) {
        String sentenciaSql = "UPDATE coche SET disponibilidad=true WHERE id_coche=?;";
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
                if (resultado.getBoolean(1)) {
                    return true;
                }
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

    public boolean existeCliente(String nif) {
        String sentenciaSql = "SELECT NIF FROM cliente WHERE nif=?;";
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        try {
            sentencia = conexion.prepareStatement(sentenciaSql);
            sentencia.setString(1, nif);
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

    public int getIdCliente() {

        try {
            String sentenciaSQL = "SELECT COUNT(*) FROM CLIENTE;";
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

    public ImageIcon obtenerImagenPorModelo(String nombreImagen) {

        String ruta = "/resources/coches/" + nombreImagen;
        java.net.URL url = getClass().getResource(ruta);

        if (url == null) {
            return new ImageIcon(); 
        }

        ImageIcon icon = new ImageIcon(url);
        Image img = icon.getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH);

        return new ImageIcon(img);
    }

    public boolean cambiarContraseña(String password, String usuario) {
        String sentenciaSql = "UPDATE empleado SET contrasenha=?  WHERE usuario=?;";
        PreparedStatement sentencia = null;

        try {
            sentencia = conexion.prepareStatement(sentenciaSql);
            sentencia.setString(1, password);
            sentencia.setString(2, usuario);
             int cambio=sentencia.executeUpdate();
            return cambio>=1;

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

    public int getIdVenta(String matricula) {

        try {
            String sentenciaSQL = "select id_venta FROM venta v JOIN coche c on c.id_coche=v.id_coche where  c.matricula= ?;";
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

    public boolean borrarVenta(int id_venta) {
        String sentenciaSql = "DELETE FROM venta WHERE id_venta=?";
        PreparedStatement sentencia = null;

        try {
            sentencia = conexion.prepareStatement(sentenciaSql);
            sentencia.setInt(1, id_venta);
             int cambio=sentencia.executeUpdate();
            return cambio>=1;

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

    public int getIdAlquila(String matricula) {

        try {
            String sentenciaSQL = "select id_alquiler FROM alquila a JOIN coche c on c.id_coche=a.id_coche where  c.matricula= ?;";
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

    public boolean borrarAlquila(int id_Alquila) {
        String sentenciaSql = "DELETE FROM alquila WHERE id_alquiler=?";
        PreparedStatement sentencia = null;

        try {
            sentencia = conexion.prepareStatement(sentenciaSql);
            sentencia.setInt(1, id_Alquila);
             int cambio=sentencia.executeUpdate();
            return cambio>=1;

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
}
