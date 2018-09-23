/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas.modelo.entidad;

import java.util.Date;

/**
 *
 * @author Jhonathan
 */
public class cNotificacion {

    private int idnotificacion;
    private String mensaje;
    private Date fechaGeneracion;
    private cUsuario objUsuario;
    private cPractica objPractica;
    private cTipoNotificacion objTipoNotificacion;
    private cEstadoNotificacion objEstadoNotificacion;

    public cNotificacion() {
    }

    public int getIdnotificacion() {
        return idnotificacion;
    }

    public void setIdnotificacion(int idnotificacion) {
        this.idnotificacion = idnotificacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(Date fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public cUsuario getObjUsuario() {
        return objUsuario;
    }

    public void setObjUsuario(cUsuario objUsuario) {
        this.objUsuario = objUsuario;
    }

    public cPractica getObjPractica() {
        return objPractica;
    }

    public void setObjPractica(cPractica objPractica) {
        this.objPractica = objPractica;
    }

    public cTipoNotificacion getObjTipoNotificacion() {
        return objTipoNotificacion;
    }

    public void setObjTipoNotificacion(cTipoNotificacion objTipoNotificacion) {
        this.objTipoNotificacion = objTipoNotificacion;
    }

    public cEstadoNotificacion getObjEstadoNotificacion() {
        return objEstadoNotificacion;
    }

    public void setObjEstadoNotificacion(cEstadoNotificacion objEstadoNotificacion) {
        this.objEstadoNotificacion = objEstadoNotificacion;
    }
}
