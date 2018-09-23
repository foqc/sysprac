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
public class cEstadoPractica {
    private int idestadopractica;
    private String nombre;
    private String descripcion;
    private boolean estado;

    public cEstadoPractica(int idestadopractica, String nombre, String descripcion, boolean estado) {
        this.idestadopractica = idestadopractica;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public cEstadoPractica() {
    }

    public int getIdestadopractica() {
        return idestadopractica;
    }

    public void setIdestadopractica(int idestadopractica) {
        this.idestadopractica = idestadopractica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}
