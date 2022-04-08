package com.clemen.Ejercicio.service;

import com.clemen.Ejercicio.entities.Edificio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceEdificio {

    @Autowired
    private Edificio edificio;

    public ServiceEdificio() {
    }

    /* public ServiceEdificio() {
        edificio = new Edificio(10,10);
    }*/

    public void alquilarPiso(int x, int y, String nombre) {
        edificio.setVecino(x, y, nombre);
    }

    public void listarInquilinos(Edificio edificio) {
        edificio.verInquilinos();
    }

    public Edificio getEdificio() {
        return this.edificio;
    }

    public void rellenarEdificio(Edificio edificio){
        edificio.alquilarEdificio();
    }


}
