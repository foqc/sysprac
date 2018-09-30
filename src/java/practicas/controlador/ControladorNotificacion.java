/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import practicas.modelo.dao.mNotificacion;
import practicas.modelo.entidad.cNotificacion;
import practicas.modelo.entidad.cUsuario;
import practicas.recursos.Util;

/**
 *
 * @author Programador
 */
@ManagedBean
@ViewScoped
public class ControladorNotificacion implements Serializable {

    private List<cNotificacion> lstNotifPorUsuario;
    private final cUsuario us = (cUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");

    /**
     * Creates a new instance of ControladorNotificacion
     */
    public ControladorNotificacion() {
        lstNotifPorUsuario = new ArrayList<>();
    }

    public cUsuario getUs() {
        return us;
    }

    @PostConstruct
    public void init() {
        System.out.println("sdfsadfasdfasdfsdf: " + us.getIdusuario());
        cargarNotificacionesPorIdUsuario(us.getIdusuario());
    }

    public List<cNotificacion> getLstNotifPorUsuario() {
        return lstNotifPorUsuario;
    }

    public void setLstNotifPorUsuario(List<cNotificacion> lstNotifPorUsuario) {
        this.lstNotifPorUsuario = lstNotifPorUsuario;
    }

    public void cargarNotificacionesPorIdUsuario(int idUsuario) {
        try {
            lstNotifPorUsuario = mNotificacion.obetenerTodosPorIdUsuario(idUsuario); // 
        } catch (Exception e) {
            Util.fatalMessage("Error (Try-Catch) (cargarNotificacionesPorIdUsuario): ", e.getMessage());
        }
    }

    public void actualizarEstado(int idNotificacion) {
        try {
            if (mNotificacion.actualizarEstadoPorId(idNotificacion, 2)) {
                Util.infoMessage("Aviso", "Actualizado correctamente");
            }
        } catch (Exception e) {
            Util.fatalMessage("Error (Try-Catch) (actualizarEstado): ", e.getMessage());
        }

    }
}
