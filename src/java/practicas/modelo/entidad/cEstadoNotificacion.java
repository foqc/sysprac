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
    private int idestadonotificacion;
    private String nombre;
    private boolean estado;

    public cEstadoNotificacion(int idestadonotificacion, String nombre, boolean estado) {
        this.idestadonotificacion = idestadonotificacion;
        this.nombre = nombre;
        this.estado = estado;
    }

    public int getIdestadonotificacion() {
        return idestadonotificacion;
    }

    public void setIdestadonotificacion(int idestadonotificacion) {
        this.idestadonotificacion = idestadonotificacion;
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
