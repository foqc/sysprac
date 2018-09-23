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
public class cPractica {

    private int idPractica;
    private String nombre;
    private String descripcion;
    private String empresa;
    private cEstadoPractica objEstadoPractica;
    private cUsuario objUsuario;
    private cTipoPractica objTipoPractica;
    private String codigoEscuela;

    public cPractica() {
    }

    public int getIdPractica() {
        return idPractica;
    }

    public void setIdPractica(int idPractica) {
        this.idPractica = idPractica;
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

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public cEstadoPractica getObjEstadoPractica() {
        return objEstadoPractica;
    }

    public void setObjEstadoPractica(cEstadoPractica objEstadoPractica) {
        this.objEstadoPractica = objEstadoPractica;
    }

    public cUsuario getObjUsuario() {
        return objUsuario;
    }

    public void setObjUsuario(cUsuario objUsuario) {
        this.objUsuario = objUsuario;
    }

    public cTipoPractica getObjTipoPractica() {
        return objTipoPractica;
    }

    public void setObjTipoPractica(cTipoPractica objTipoPractica) {
        this.objTipoPractica = objTipoPractica;
    }

    public String getCodigoEscuela() {
        return codigoEscuela;
    }

    public void setCodigoEscuela(String codigoEscuela) {
        this.codigoEscuela = codigoEscuela;
    }

}
