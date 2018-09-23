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
import practicas.modelo.dao.mNotificacion;
import practicas.modelo.entidad.cNotificacion;
import practicas.recursos.Util;

/**
 *
 * @author Programador
 */
@ManagedBean
@ViewScoped
public class ControladorNotificacion implements Serializable {

    private List<cNotificacion> lstNotifPorUsuario;

    /**
     * Creates a new instance of ControladorNotificacion
     */
    public ControladorNotificacion() {
    }

    @PostConstruct
    public void init() {
        cargarNotificacionesPorIdUsuario(3);
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

}
