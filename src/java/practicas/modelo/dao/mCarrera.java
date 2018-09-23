/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas.modelo.dao;

import ec.edu.espoch.academico.carrera.Docente;
import ec.edu.espoch.academico.carrera.Estudiante;
import ec.edu.espoch.academico.carrera.InfoCarrera;
import ec.edu.espoch.academico.carrera.InfoCarreraSoap;
import ec.edu.espoch.academico.carrera.Persona;

/**
 *
 * @author Programador
 */
public class mCarrera {

    public static Estudiante getDatosCompletosEstudiante(String strCedula) {
        try {
            InfoCarrera service = new ec.edu.espoch.academico.carrera.InfoCarrera();
            InfoCarreraSoap port = service.getInfoCarreraSoap();
            return port.getDatosCompletosEstudiante(strCedula);
        } catch (Exception e) {
            throw e;
        }
    }

    public static Docente getDatosDocente(String codCarrera, String cedula) {

        try {
            ec.edu.espoch.academico.carrera.InfoCarrera service = new ec.edu.espoch.academico.carrera.InfoCarrera();
            ec.edu.espoch.academico.carrera.InfoCarreraSoap port = service.getInfoCarreraSoap();
            return port.getDatosDocente(codCarrera, cedula);
        } catch (Exception e) {
            throw e;
        }
    }

    private static Persona getDatosUsuarioCarrera(String codCarrera, String cedula) {
        ec.edu.espoch.academico.carrera.InfoCarrera service = new ec.edu.espoch.academico.carrera.InfoCarrera();
        ec.edu.espoch.academico.carrera.InfoCarreraSoap port = service.getInfoCarreraSoap();
        return port.getDatosUsuarioCarrera(codCarrera, cedula);
    }

}
