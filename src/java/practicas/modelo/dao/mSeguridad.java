/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas.modelo.dao;

import ec.edu.espoch.academico.carrera.Estudiante;
import ec.edu.espoch.academico.carrera.InfoCarrera;
import ec.edu.espoch.academico.carrera.InfoCarreraSoap;
import ec.edu.espoch.academico.seguridad.ArrayOfRolCarrera;
import ec.edu.espoch.academico.seguridad.Persona;
import ec.edu.espoch.academico.seguridad.RolCarrera;
import ec.edu.espoch.academico.seguridad.Seguridad;
import ec.edu.espoch.academico.seguridad.SeguridadSoap;
import java.util.List;

/**
 *
 * @author Programador
 */
public class mSeguridad {

    private static ArrayOfRolCarrera autenticarUsuarioCarrera(String login, String password) {
        ec.edu.espoch.academico.seguridad.Seguridad service = new ec.edu.espoch.academico.seguridad.Seguridad();
        ec.edu.espoch.academico.seguridad.SeguridadSoap port = service.getSeguridadSoap();
        return port.autenticarUsuarioCarrera(login, password);
    }

    public static List<RolCarrera> getRolUsuarioCarrera(String login) {
        try {
            Seguridad service = new Seguridad();
            SeguridadSoap port = service.getSeguridadSoap();
            return port.getRolUsuarioCarrera(login).getRolCarrera();
        } catch (Exception e) {
            throw e;
        }
    }

    private static Persona getUsuarioFacultad(java.lang.String login, java.lang.String password) {
        ec.edu.espoch.academico.seguridad.Seguridad service = new ec.edu.espoch.academico.seguridad.Seguridad();
        ec.edu.espoch.academico.seguridad.SeguridadSoap port = service.getSeguridadSoap();
        return port.getUsuarioFacultad(login, password);
    }

    public static Estudiante getDatosCompletosEstudiante(String strCedula) {
        try {
            InfoCarrera service = new ec.edu.espoch.academico.carrera.InfoCarrera();
            InfoCarreraSoap port = service.getInfoCarreraSoap();
            return port.getDatosCompletosEstudiante(strCedula);
        } catch (Exception e) {
            throw e;
        }
    }

}
