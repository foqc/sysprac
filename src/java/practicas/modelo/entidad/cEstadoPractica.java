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

    private int idEstadoPractica;
    private String codigo;
    private String nombre;
    private boolean estado;

    public cEstadoPractica ()
    {
    }
    public cEstadoPractica(int idEstadoPractica) {
        this.idEstadoPractica = idEstadoPractica;
    }

    public int getIdEstadoPractica() {
        return idEstadoPractica;
    }

    public void setIdEstadoPractica(int idEstadoPractica) {
        this.idEstadoPractica = idEstadoPractica;
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
