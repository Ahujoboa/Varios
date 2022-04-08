package com.clemen.Ejercicio.entities;


public class Edificio {

    private int pisos;
    private int plantas;

    private String [][] pisosPlantas;

    public Edificio(int pisos, int plantas){
        this.pisos = pisos;
        this.plantas = plantas;
        this.pisosPlantas = new String[pisos][plantas];
    }

    public void setVecino(int piso, int planta, String nombre){
        this.pisosPlantas[piso][planta] = nombre;
    }

    public String getVecino(int piso, int planta){
        return this.pisosPlantas[piso][planta];
    }

    public int getPisos() {
        return pisos;
    }

    public void setPisos(int pisos) {
        this.pisos = pisos;
    }

    public int getPlantas() {
        return plantas;
    }

    public void setPlantas(int plantas) {
        this.plantas = plantas;
    }

    public Edificio() {
    }

    public void verInquilinos() {
        for(int i = 0; i < this.pisos; i++){
            for(int j = 0; j < this.plantas; j++){
                System.out.println("Piso: " + i + " Planta: " + j + " Nombre: " + this.pisosPlantas[i][j]);
            }
        }
    }


    @Override
    public String toString() {
        return "Edificio{" +
                "pisos=" + pisos +
                ", plantas=" + plantas  +
                '}';
    }

    public void alquilarEdificio() {
        for(int i = 0; i < this.getPlantas(); i++){
            for(int j = 0; j < this.getPisos(); j++){
                this.setVecino(i, j, "vecino" + i + j);
            }
        }
    }
}

