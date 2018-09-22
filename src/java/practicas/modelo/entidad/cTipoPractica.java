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
public class cTipoPractica {

    private int idtipopractica;
    private String nombre;
    private boolean estado;

    public cTipoPractica(int idtipopractica, String nombre, boolean estado) {
        this.idtipopractica = idtipopractica;
        this.nombre = nombre;
        this.estado = estado;
    }

    public cTipoPractica() {
    }

    public int getIdtipopractica() {
        return idtipopractica;
    }

    public void setIdtipopractica(int idtipopractica) {
        this.idtipopractica = idtipopractica;
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
