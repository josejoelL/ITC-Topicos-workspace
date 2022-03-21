package com.example.proyecto;

public class ReporteTres {


   private int claveCliente;
   private String placa,nombre;

    public ReporteTres( String placa,int claveCliente,String nombre) {
        this.claveCliente = claveCliente;
        this.placa = placa;
        this.nombre=nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getClaveCliente() {
        return claveCliente;
    }

    public void setClaveCliente(int claveCliente) {
        this.claveCliente = claveCliente;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
