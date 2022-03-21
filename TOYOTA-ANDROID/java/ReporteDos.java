package com.example.proyecto;

public class ReporteDos {

    private int numSer,sumImp;
    private String nomCiudad,nomColonia;
    public ReporteDos(String nomCiudad, String nomColonia, int numSer, int sumImp) {
        this.nomCiudad=nomCiudad;
        this.nomColonia=nomColonia;
        this.numSer=numSer;
        this.sumImp=sumImp;
    }

    public int getNumSer() {
        return numSer;
    }

    public void setNumSer(int numSer) {
        this.numSer = numSer;
    }

    public int getSumImp() {
        return sumImp;
    }

    public void setSumImp(int sumImp) {
        this.sumImp = sumImp;
    }

    public String getNomCiudad() {
        return nomCiudad;
    }

    public void setNomCiudad(String nomCiudad) {
        this.nomCiudad = nomCiudad;
    }

    public String getNomColonia() {
        return nomColonia;
    }

    public void setNomColonia(String nomColonia) {
        this.nomColonia = nomColonia;
    }
}
