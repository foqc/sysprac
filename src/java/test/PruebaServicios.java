/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import ec.edu.espoch.academico.carrera.Docente;
import ec.edu.espoch.academico.carrera.Estudiante;
import ec.edu.espoch.academico.general.EscuelaEntidad;
import ec.edu.espoch.academico.seguridad.RolCarrera;
import java.util.List;
import practicas.modelo.dao.mCarrera;
import practicas.modelo.dao.mGeneral;
import practicas.modelo.dao.mNotificacion;
import practicas.modelo.dao.mSeguridad;
import practicas.modelo.dao.mTipoPractica;
import practicas.modelo.entidad.cNotificacion;
import practicas.modelo.entidad.cTipoNotificacion;
import practicas.modelo.entidad.cTipoPractica;
import practicas.modelo.entidad.cTipoUsuario;
import practicas.modelo.entidad.cUsuario;

/**
 *
 * @author Programador
 */
public class PruebaServicios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        /*
        List<EscuelaEntidad> lst = mGeneral.getEscuelaEntidad();
        for (EscuelaEntidad item : lst) {
            System.out.println("Carrera: " + item.getCarrera());
        }
         */
        List<RolCarrera> lstRolCarrera = mSeguridad.getRolUsuarioCarrera("180482433-0");
        for (RolCarrera item : lstRolCarrera) {
            System.out.println("CodigoCarrera: " + item.getCodigoCarrera());
            System.out.println("NombreRol: " + item.getNombreRol());
        }
        System.out.println("Estudiantes **********************************");
        Estudiante e = mCarrera.getDatosCompletosEstudiante("180482433-0");
        System.out.println(e.getCedula() + " - " + e.getNombres() + " " + e.getApellidos());

        e = mCarrera.getDatosCompletosEstudiante("020180907-6");
        System.out.println(e.getCedula() + " - " + e.getNombres() + " " + e.getApellidos());

        //  e = mCarrera.getDatosCompletosEstudiante("020180907-6");
        //System.out.println(e.getCedula() + " - " + e.getNombres() + " " + e.getApellidos());
        //CodigoCarrera: EIS
        System.out.println("Docentes **********************************");
        Docente d = mCarrera.getDatosDocente("EIS", "060218509-2");
        System.out.println(d.getCedula() + " - " + d.getNombre() + " " + d.getApellidos());

        d = mCarrera.getDatosDocente("EIS", "060206164-0");
        System.out.println(d.getCedula() + " - " + d.getNombre() + " " + d.getApellidos());

        d = mCarrera.getDatosDocente("EIS", "060190508-6");
        System.out.println(d.getCedula() + " - " + d.getNombre() + " " + d.getApellidos());

        d = mCarrera.getDatosDocente("EIS", "060238695-5");
        System.out.println(d.getCedula() + " - " + d.getNombre() + " " + d.getApellidos());
    }

}
