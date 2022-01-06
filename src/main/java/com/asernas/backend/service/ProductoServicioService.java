package com.asernas.backend.service;

import com.asernas.backend.model.ProductoServicio;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adan Sernas - adansernas@gmail.com
 */
@Service
public class ProductoServicioService {

    public List<ProductoServicio> listarProductoServicios() {
        List<ProductoServicio> productoServicios = new ArrayList<>();

        productoServicios.add(new ProductoServicio(1, "Guata de algodón"));
        productoServicios.add(new ProductoServicio(2, "Oxígeno"));
        productoServicios.add(new ProductoServicio(3, "Alcoholes o sus sustitutos"));
        productoServicios.add(new ProductoServicio(4, "Papel de monitoreo o calcado o registro médico"));
        productoServicios.add(new ProductoServicio(5, "Toallas de papel"));

        return productoServicios;
    }
}
