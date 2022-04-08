package com.nttdata.facade;

public class LicenciasFacade {

    private Licencias licenciaA1;

    //hacems una funcion que nos haga por debajo implementaciones
    public LicenciasFacade(String dni) {
        licenciaA1 = new Licencias();
        licenciaA1.setDni(dni);
        licenciaA1.setCategoria("A");
        licenciaA1.setTipo("I");
    }

    public String verDetalle() {
        return licenciaA1.verDetalle();
    }
}
