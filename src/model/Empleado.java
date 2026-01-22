/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author alumno
 */
public class Empleado {
    
    //NIF, nombre, usuario, contrasenha, salario, mail, telefono, puesto, direccion
    private int id_empleado;
    private String NIF;
    private String nombre;
    private String usuario;
    private String contrasenha;
    private String salario;
    private String mail;
    private String telefono;
    private String puesto;
    private String direccion;

    public Empleado(int id_empleado,String NIF, String nombre, String usuario, String contrasenha, String salario, String mail, String telefono, String puesto, String direccion) {
        this.id_empleado=id_empleado;
        this.NIF = NIF;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasenha = contrasenha;
        this.salario = salario;
        this.mail = mail;
        this.telefono = telefono;
        this.puesto = puesto;
        this.direccion = direccion;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}
