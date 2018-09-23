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
public class cUsuario {
    private int idusuario;
    private String cedula;
    private String nombre;
    private boolean estado;
    cTipoUsuario objTipoUsuario;

    public cTipoUsuario getObjTipoUsuario() {
        return objTipoUsuario;
    }

    public void setObjTipoUsuario(cTipoUsuario objTipoUsuario) {
        this.objTipoUsuario = objTipoUsuario;
    }
    
    public cUsuario()
    {   }


    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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
