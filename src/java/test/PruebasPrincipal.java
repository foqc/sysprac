/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import ec.edu.espoch.academico.seguridad.ArrayOfRolCarrera;
import ec.edu.espoch.academico.seguridad.RolCarrera;
import java.util.List;
import practicas.controlador.ControladorPractica;
import practicas.modelo.dao.mEstadoPractica;
import practicas.modelo.dao.mSeguridad;
import practicas.modelo.dao.mTipoNotificacion;
import practicas.modelo.dao.mTipoPractica;
import practicas.modelo.entidad.cEstadoPractica;
import practicas.modelo.entidad.cTipoPractica;

/**
 *
 * @author Programador
 */
public class PruebasPrincipal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayOfRolCarrera dato = mSeguridad.getRolUsuarioCarrera("180482433-0");

        for (RolCarrera item : dato.getRolCarrera()) {
            System.err.println("Nombre Rol: " + item.getNombreRol());
        }
    }

}
