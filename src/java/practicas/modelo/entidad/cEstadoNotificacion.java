/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas.modelo.entidad;

/**
 *
 * @author Jhonathan
 */
public class cEstadoNotificacion {

    private int idEstadoNotificacion;
    private String nombre;
    private boolean estado;

    public cEstadoNotificacion() {
    }

    public cEstadoNotificacion(int idEstadoNotificacion) {
        this.idEstadoNotificacion = idEstadoNotificacion;
    }

    public int getIdEstadoNotificacion() {
        return idEstadoNotificacion;
    }

    public void setIdEstadoNotificacion(int idEstadoNotificacion) {
        this.idEstadoNotificacion = idEstadoNotificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
