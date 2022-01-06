package com.asernas.backend.model;

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
public class Cliente {

    private int idCliente;
    private String nombreCliente;

}
