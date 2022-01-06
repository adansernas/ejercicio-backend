package com.asernas.backend.controller;

import com.asernas.backend.api.ApiResponseBody;
import com.asernas.backend.service.ProductoServicioService;
import com.asernas.backend.service.RegimenFiscalService;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CatalogoController {

    @Autowired
    private RegimenFiscalService regimenFiscalService;

    @Autowired
    private ProductoServicioService productoServicioService;

    @GetMapping(value = "/catalogos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listarCatalogos() {
        ApiResponseBody responseBody = new ApiResponseBody();
        try {
            Map<String, Object> catalogos = new HashMap<>();
            catalogos.put("regimenFiscals", regimenFiscalService.listarRegimenFiscals());
            catalogos.put("productoServicios", productoServicioService.listarProductoServicios());

            return new ResponseEntity<>(catalogos, HttpStatus.OK);
        } catch (Exception ex) {
            log.error(String.format("Error: %s", ex.getMessage()), ex);

            return new ResponseEntity<>(responseBody.setMessage("Ocurrio un error inesperado en la aplicación"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
