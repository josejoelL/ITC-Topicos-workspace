package com.example.proyecto;

public class ReporteUno {
    private String placa,nombre;
   private int numSer,sumInt;

    public ReporteUno(String placa, String nombre, int numSer, int sumInt) {
        this.placa = placa;
        this.nombre = nombre;
        this.numSer = numSer;
        this.sumInt = sumInt;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumSer() {
        return numSer;
    }

    public void setNumSer(int numSer) {
        this.numSer = numSer;
    }

    public int getSumInt() {
        return sumInt;
    }

    public void setSumInt(int sumInt) {
        this.sumInt = sumInt;
    }
}
