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
    private int idpractica;
    private String nombre;
    private String descripcion;
    private String empresa;
    private int idestadopractica;
    private int idusuario;
    private int tipopractica;
    private int idplanificacion;
    private String codigoescuela;

    public cPractica() {
    }
    

    public cPractica(int idpractica, String nombre, String descripcion, String empresa, int idestadopractica, int idusuario, int tipopractica, int idplanificacion, String codigoescuela) {
        this.idpractica = idpractica;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.empresa = empresa;
        this.idestadopractica = idestadopractica;
        this.idusuario = idusuario;
        this.tipopractica = tipopractica;
        this.idplanificacion = idplanificacion;
        this.codigoescuela = codigoescuela;
    }

    public int getIdpractica() {
        return idpractica;
    }

    public void setIdpractica(int idpractica) {
        this.idpractica = idpractica;
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

    public int getIdestadopractica() {
        return idestadopractica;
    }

    public void setIdestadopractica(int idestadopractica) {
        this.idestadopractica = idestadopractica;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getTipopractica() {
        return tipopractica;
    }

    public void setTipopractica(int tipopractica) {
        this.tipopractica = tipopractica;
    }

    public int getIdplanificacion() {
        return idplanificacion;
    }

    public void setIdplanificacion(int idplanificacion) {
        this.idplanificacion = idplanificacion;
    }

    public String getCodigoescuela() {
        return codigoescuela;
    }

    public void setCodigoescuela(String codigoescuela) {
        this.codigoescuela = codigoescuela;
    }
       
}
