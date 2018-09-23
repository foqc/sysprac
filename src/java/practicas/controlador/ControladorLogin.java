/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas.controlador;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import practicas.modelo.dao.mUsuario;
import practicas.modelo.entidad.cUsuario;
import practicas.recursos.Util;

/**
 *
 * @author Programador
 */
@ManagedBean
@ViewScoped
public class ControladorLogin implements Serializable {

    private cUsuario objUsuario;

    /**
     * Creates a new instance of ControladorLogin
     */
    public ControladorLogin() {
    }

    public cUsuario getObjUsuario() {
        return objUsuario;
    }

    public void setObjUsuario(cUsuario objUsuario) {
        this.objUsuario = objUsuario;
    }

    public String iniciarSesion() {
        String redireccion = null;
        try {
            cUsuario us = mUsuario.usuarioIniciarSesion(objUsuario.getCedula());
            if (us != null) {
                //Almacenar en la sesion de JSF
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
                switch (us.getObjTipoUsuario().getIdtipousuario()) {
                    case 1:
                        redireccion = "_estudiante/dashboard?faces-redirect=true";
                        break;
                    case 2:
                        redireccion = "_docente/dashboard?faces-redirect=true";
                        break;
                    case 3:
                        redireccion = "_docente/dashboard?faces-redirect=true";
                        break;
                    default:
                        break;
                }

            } else {
                Util.warnMessage("Aviso", "Credenciales Incorrectas");
            }
        } catch (Exception e) {
            Util.fatalMessage("Fatal: ", "Error: " + e.getMessage() + " || " + e.getCause());
        }
        return redireccion;
    }

//<editor-fold desc="Cerrar Sesión">
    public void cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
    //</editor-fold>

}
