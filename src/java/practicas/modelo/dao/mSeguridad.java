/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas.modelo.dao;

import ec.edu.espoch.academico.seguridad.ArrayOfRolCarrera;
import ec.edu.espoch.academico.seguridad.Persona;

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

    public static ArrayOfRolCarrera getRolUsuarioCarrera(String login) {
        ec.edu.espoch.academico.seguridad.Seguridad service = new ec.edu.espoch.academico.seguridad.Seguridad();
        ec.edu.espoch.academico.seguridad.SeguridadSoap port = service.getSeguridadSoap();
        return port.getRolUsuarioCarrera(login);
    }

    private static Persona getUsuarioFacultad(java.lang.String login, java.lang.String password) {
        ec.edu.espoch.academico.seguridad.Seguridad service = new ec.edu.espoch.academico.seguridad.Seguridad();
        ec.edu.espoch.academico.seguridad.SeguridadSoap port = service.getSeguridadSoap();
        return port.getUsuarioFacultad(login, password);
    }

}
