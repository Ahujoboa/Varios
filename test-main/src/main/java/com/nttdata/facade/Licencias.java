package com.nttdata.facade;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Licencias {
    private String dni;
    private String categoria;
    private String tipo;

    public String verDetalle() {
        return String.format("DNI: %s\n      Licencia: %s%s",
                dni,categoria,tipo);
    }
}
