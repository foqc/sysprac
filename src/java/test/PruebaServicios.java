/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.List;
import practicas.modelo.dao.mNotificacion;
import practicas.modelo.dao.mTipoPractica;
import practicas.modelo.entidad.cNotificacion;
import practicas.modelo.entidad.cTipoNotificacion;
import practicas.modelo.entidad.cTipoPractica;
import practicas.modelo.entidad.cTipoUsuario;
import practicas.modelo.entidad.cUsuario;

/**
 *
 * @author Programador
 */
public class PruebaServicios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
       boolean resp =false;
        cNotificacion obj;
        try {
            cUsuario objU =new cUsuario();
            cTipoUsuario  objTU= new cTipoUsuario();
            objTU.setIdtipousuario(1);
            objTU.setNombre("Estudiante");
            objTU.setDescripcion("Estudiante");
            objTU.setEstado(true);
           
            
            objU.setIdusuario(1);
            objU.setNombre("Luis");
            objU.setCedula("123456789-0");
            objU.setObjTipoUsuario(objTU);
            
            
            cTipoNotificacion objTipoNotificacion = new cTipoNotificacion();
            objTipoNotificacion.setIdtiponotificacion(1);
            objTipoNotificacion.setNombre("SolicitudPractica");
            
            obj=new cNotificacion();
            obj.setIdnotificacion(1);
            obj.setObjUsuario(objU);
            obj.setObjTipoNotificacion(objTipoNotificacion);
            
            resp= mNotificacion.insertarNotificacion(obj);
            
            
        } catch (Exception e) {
            throw e;
        }
        System.out.println(resp);
    }

}
