/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author frana
 */
public class Coche {
     private int idCoche;
    private String matricula;
    private String color;
    private int anho;
    private String modelo;
    private int idFabricacion;
    private boolean disponibilidad;
    private float precio;
    private String imagen; 

    public Coche() {
    }

    public Coche(int idCoche, String matricula, String color, int anho, String modelo, int idFabricacion, boolean disponibilidad, float precio, String imagen) {
        this.idCoche = idCoche;
        this.matricula = matricula;
        this.color = color;
        this.anho = anho;
        this.modelo = modelo;
        this.idFabricacion = idFabricacion;
        this.disponibilidad = disponibilidad;
        this.precio = precio;
        this.imagen = imagen;
    }

    public int getIdCoche() {
        return idCoche;
    }

    public void setIdCoche(int idCoche) {
        this.idCoche = idCoche;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAnho() {
        return anho;
    }

    public void setAnho(int anho) {
        this.anho = anho;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getIdFabricacion() {
        return idFabricacion;
    }

    public void setIdFabricacion(int idFabricacion) {
        this.idFabricacion = idFabricacion;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
}
