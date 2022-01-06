package com.asernas.backend.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Adan Sernas - adansernas@gmail.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Factura {

    @NotNull(message = "El parámetro Id Factura es requerido")
    private int idFactura;

    @NotEmpty(message = "El parámetro Folio Fiscal es requerido")
    private String folioFiscal;

}
