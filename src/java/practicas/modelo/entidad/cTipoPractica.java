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

    private int idTipoPractica;
    private String codigo;
    private String nombre;
    private boolean estado;

    public cTipoPractica() {
    }

    public int getIdTipoPractica() {
        return idTipoPractica;
    }

    public void setIdTipoPractica(int idTipoPractica) {
        this.idTipoPractica = idTipoPractica;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
