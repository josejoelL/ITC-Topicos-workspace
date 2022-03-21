package com.example.proyecto;

public class Auto {
    private  String placa;
    private  String marca;
    private  String modelo;
    private  int year;
    private  int claveCliente;

    public Auto(String placa, String marca, String modelo, int year, int claveCliente) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.year = year;
        this.claveCliente = claveCliente;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getClaveCliente() {
        return claveCliente;
    }

    public void setClaveCliente(int claveCliente) {
        this.claveCliente = claveCliente;
    }
}
