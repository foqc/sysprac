/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas.modelo.dao;

import ec.edu.espoch.academico.general.ArrayOfEscuelaEntidad;
import ec.edu.espoch.academico.general.EscuelaEntidad;
import ec.edu.espoch.academico.general.InfoGeneral;
import ec.edu.espoch.academico.general.InfoGeneralSoap;
import java.util.List;

/**
 *
 * @author Programador
 */
public class mGeneral {

    public static List<EscuelaEntidad> getEscuelaEntidad() {
        InfoGeneral service = new InfoGeneral();
        InfoGeneralSoap port;
        try {
            port = service.getInfoGeneralSoap();
        } catch (Exception e) {
            throw e;
        }
        return port.getEscuelaEntidad().getEscuelaEntidad();
    }
}
