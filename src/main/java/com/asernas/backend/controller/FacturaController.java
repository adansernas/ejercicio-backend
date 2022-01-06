package com.asernas.backend.controller;

import com.asernas.backend.api.ApiResponseBody;
import com.asernas.backend.model.Factura;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Adan Sernas - adansernas@gmail.com
 */
@CrossOrigin
@RestController
@Log4j2
public class FacturaController {

    @PostMapping(value = "/facturas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> guardarFactura(@RequestBody Factura factura) {
        ApiResponseBody responseBody = new ApiResponseBody();
        try {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<Factura>> violations = validator.validate(factura, Default.class);
            if (!violations.isEmpty()) {
                List<String> errors = violations.stream().map(violation -> violation.getMessage())
                        .collect(Collectors.toList());

                return new ResponseEntity<>(
                        responseBody.setMessage("Parámetros de entrada incorrectos").addErrors(errors),
                        HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            log.error(String.format("Error: %s", ex.getMessage()), ex);

            return new ResponseEntity<>(responseBody.setMessage("Ocurrio un error inesperado en la aplicación"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
