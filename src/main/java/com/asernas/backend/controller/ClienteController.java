package com.asernas.backend.controller;

import com.asernas.backend.api.ApiResponseBody;
import com.asernas.backend.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Adan Sernas - adansernas@gmail.com
 */
@RestController
@Log4j2
public class ClienteController {

    @GetMapping(value = "/clients", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listarClientes() {
        ApiResponseBody responseBody = new ApiResponseBody();
        try {
            List<Cliente> clientes = new ArrayList<>();
            clientes.add(new Cliente(1, "Jose Juarez"));
            clientes.add(new Cliente(2, "Juan Ramirez"));
            clientes.add(new Cliente(3, "Alfredo Ruiz"));
            clientes.add(new Cliente(4, "Hugo Lopez"));
            clientes.add(new Cliente(5, "Jacobo Pacheco"));

            return new ResponseEntity<>(clientes, HttpStatus.OK);
        } catch (Exception ex) {
            log.error(String.format("Error: %s", ex.getMessage()), ex);

            return new ResponseEntity<>(responseBody.setMessage("Ocurrio un error inesperado en la aplicación"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
