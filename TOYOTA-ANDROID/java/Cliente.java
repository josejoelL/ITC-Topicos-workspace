package com.example.proyecto;

public class Cliente {
    private  int claveCliente;
    private   String nombre;
    private   String nombreCiudad;
    private   String nombreEdo;
    private  String nombreColonia;

    public Cliente(int claveCliente, String nombre, String nombreCiudad, String nombreEdo, String nombreColonia) {
        this.claveCliente = claveCliente;
        this.nombre = nombre;
        this.nombreCiudad = nombreCiudad;
        this.nombreEdo = nombreEdo;
        this.nombreColonia = nombreColonia;
    }

    public int getClaveCliente() {
        return claveCliente;
    }

    public void setClaveCliente(int claveCliente) {
        this.claveCliente = claveCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public String getNombreEdo() {
        return nombreEdo;
    }

    public void setNombreEdo(String nombreEdo) {
        this.nombreEdo = nombreEdo;
    }

    public String getNombreColona() {
        return nombreColonia;
    }

    public void setNombreColona(String nombreColona) {
        this.nombreColonia = nombreColona;
    }
}
