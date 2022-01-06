package com.asernas.backend.service;

import com.asernas.backend.model.RegimenFiscal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adan Sernas - adansernas@gmail.com
 */
@Service
public class RegimenFiscalService {

    public List<RegimenFiscal> listarRegimenFiscals() {
        List<RegimenFiscal> regimenFiscals = new ArrayList<>();

        regimenFiscals.add(new RegimenFiscal(1, "Sueldos y Salarios e Ingresos Asimilados a Salarios"));
        regimenFiscals.add(new RegimenFiscal(2, "Arrendamiento"));
        regimenFiscals.add(new RegimenFiscal(3, "Personas Físicas con Actividades Empresariales y Profesionales"));
        regimenFiscals.add(new RegimenFiscal(4, "Incorporación Fiscal"));
        regimenFiscals.add(new RegimenFiscal(5, "General de Ley Personas Morales"));

        return regimenFiscals;
    }

}
