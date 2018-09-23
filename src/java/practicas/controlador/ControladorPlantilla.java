/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas.controlador;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import practicas.modelo.entidad.cUsuario;

/**
 *
 * @author Programador
 */
@Named
@ViewScoped
public class ControladorPlantilla implements Serializable {

    public void verificarSesion() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            cUsuario us = (cUsuario) context.getExternalContext().getSessionMap().get("usuario");
            if (us == null) {
                context.getExternalContext().redirect("./../permisos.xhtml");
            }
        } catch (IOException e) {
            //log para guardar algun registro de un error 
        }
    }

}
