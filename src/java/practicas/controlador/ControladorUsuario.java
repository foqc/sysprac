/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas.controlador;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import practicas.modelo.dao.mUsuario;
import practicas.modelo.entidad.cPractica;
import practicas.modelo.entidad.cUsuario;
import practicas.recursos.Util;

/**
 *
 * @author Programador
 */
@ManagedBean
@ViewScoped
public class ControladorUsuario implements Serializable {

    private List<cUsuario> lstDocentes;
    private final cUsuario us = (cUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");

    /**
     * Creates a new instance of controladorUsuario
     */
    public ControladorUsuario() {
    }

    @PostConstruct
    public void init() {
        cargarDocentes();

    }

    public List<cUsuario> getLstDocentes() {
        return lstDocentes;
    }

    public void setLstDocentes(List<cUsuario> lstDocentes) {
        this.lstDocentes = lstDocentes;
    }

    public cUsuario getUs() {
        return us;
    }

    public void cargarDocentes() {
        try {
            try {
                lstDocentes = mUsuario.obtenerListaPorIdTipoUsuario(2); // 2=Docente
            } catch (Exception e) {
                Util.fatalMessage("Error (Try-Catch) (cargarDocentes): ", e.getMessage());
            }
        } catch (Exception e) {
        }
    }

}
