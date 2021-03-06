/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas.controlador;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import practicas.modelo.dao.mNotificacion;
import practicas.modelo.dao.mPractica;
import practicas.modelo.dao.mTipoPractica;
import practicas.modelo.dao.mUsuario;
import practicas.modelo.entidad.cEstadoNotificacion;
import practicas.modelo.entidad.cEstadoPractica;
import practicas.modelo.entidad.cNotificacion;
import practicas.modelo.entidad.cPractica;
import practicas.modelo.entidad.cTipoNotificacion;
import practicas.modelo.entidad.cTipoPractica;
import practicas.modelo.entidad.cUsuario;
import practicas.recursos.Util;

/**
 *
 * @author Programador
 */
@ManagedBean
@ViewScoped
public class ControladorPractica implements Serializable {

    private cPractica objPractica;
    private List<cPractica> lstPracticasSolicitadas;
    private cPractica selObjPractica;
    private final cUsuario us = (cUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");

    /**
     * Creates a new instance of ControladorPractica
     */
    public ControladorPractica() {
        objPractica = new cPractica();

    }

    @PostConstruct
    public void init() {
        objPractica.setObjTipoPractica(new cTipoPractica());
        try {
            cPractica obj = mPractica.obetenerPorIdUsuarioPorIdEstado(1, 1);
            if (obj != null) {
                objPractica = obj;
            } else {
                objPractica.setObjTipoPractica(new cTipoPractica());
            }
            cargarPracticasSolicitadas();
        } catch (Exception e) {
        }
    }

    public cPractica getObjPractica() {
        return objPractica;
    }

    public void setObjPractica(cPractica objPractica) {
        this.objPractica = objPractica;
    }

    public cPractica getSelObjPractica() {
        return selObjPractica;
    }

    public void setSelObjPractica(cPractica selObjPractica) {
        this.selObjPractica = selObjPractica;
    }

    public void obtenerTodosActivos() {
        try {
            List<cTipoPractica> lst = mTipoPractica.obetenerTodosActivos();
            lst.forEach((obj) -> {
                System.out.println("Nombre: " + obj.getNombre());
            });
        } catch (Exception e) {
        }
    }

    public List<cPractica> getLstPracticasSolicitadas() {
        return lstPracticasSolicitadas;
    }

    public void setLstPracticasSolicitadas(List<cPractica> lstPracticasSolicitadas) {
        this.lstPracticasSolicitadas = lstPracticasSolicitadas;
    }

    public void insertar() {
        try {
            objPractica.setObjUsuario(new cUsuario(1));
            objPractica.setObjEstadoPractica(new cEstadoPractica(1));
            objPractica.setCodigoEscuela("eis");
            if (mPractica.insertar(objPractica)) {
                Util.infoMessage("Aviso: ", "Datos guardados correctamente");
            } else {
                Util.errorMessage("Error: ", "Datos no guardados");
            }
        } catch (Exception e) {
            Util.fatalMessage("Error (Try-Catch) (insertar): ", e.getMessage());
        }
    }

    public void solicitar() {
        try {
            objPractica = mPractica.obetenerPorIdUsuarioPorIdEstado(1, 1);
            objPractica.setObjEstadoPractica(new cEstadoPractica(2)); //2=Solicitada
            mPractica.actualizar(objPractica);
            cNotificacion obj = new cNotificacion();

            //Para director
            StringBuilder me = new StringBuilder();
            me.append("Estimado director, el estudiante ");
            me.append(us.getNombre());
            me.append(" solicita la aprobación de sus practicas, ");
            me.append(objPractica.getObjTipoPractica().getNombre());
            me.append(", denominado ");
            me.append(objPractica.getNombre());
            me.append(".");

            obj.setMensaje(me.toString());
            obj.setFechaGeneracion(new Date());
            obj.setObjUsuario(mUsuario.obtenerPorIdTipoUsuario(3)); //3=Director
            obj.setObjPractica(objPractica);
            obj.setObjTipoNotificacion(new cTipoNotificacion(2)); //2=Informativa
            obj.setObjEstadoNotificacion(new cEstadoNotificacion(1));
            if (mNotificacion.insertarNotificacion(obj)) {
                Util.infoMessage("Aviso: ", "Solicitud generada correctamente");
            } else {
                Util.errorMessage("Error: ", "Solicitud no generada");
            }

        } catch (Exception e) {
            Util.fatalMessage("Error (Try-Catch) (solicitar): ", e.getMessage());
        }
    }

    public void asinarASelObjPractica(cPractica obj) {
        this.selObjPractica = obj;
    }

    public void asignar(cUsuario objUserAsignado) {
        
        try {
            selObjPractica.setObjEstadoPractica(new cEstadoPractica(3)); //3=Asignado
            mPractica.actualizar(selObjPractica);
            cNotificacion obj = new cNotificacion();
            //Para docente
            StringBuilder me = new StringBuilder();
            me.append("Estimado docente ");
            me.append(objUserAsignado.getNombre());
            me.append(" usted ha sido asignaddo como tutor de la practica preprofesional, ");
            me.append(selObjPractica.getObjTipoPractica().getNombre());
            me.append(", denominado ");
            me.append(selObjPractica.getNombre());
            me.append(" perteneciente al Sr. estudiante ");
            me.append(selObjPractica.getObjUsuario().getNombre());
            me.append(".");
            obj.setMensaje(me.toString());
            obj.setFechaGeneracion(new Date());
            obj.setObjUsuario(objUserAsignado);
            obj.setObjPractica(selObjPractica);
            obj.setObjTipoNotificacion(new cTipoNotificacion(2)); //2=Informativo
            obj.setObjEstadoNotificacion(new cEstadoNotificacion(1)); //1=No Visto
            mNotificacion.insertarNotificacion(obj);

            //Para estudiante
            me = new StringBuilder();
            me.append("Estimad@ estudiante ");
            me.append(selObjPractica.getObjUsuario().getNombre());
            me.append(", el tutor asignado para su práctica preprofesional, ");
            me.append(selObjPractica.getObjTipoPractica().getNombre());
            me.append(", denominado ");
            me.append(selObjPractica.getNombre());
            me.append(" es el docente ");
            me.append(objUserAsignado.getNombre());
            me.append(".");
            obj.setMensaje(me.toString());
            obj.setFechaGeneracion(new Date());
            obj.setObjUsuario(selObjPractica.getObjUsuario());
            obj.setObjPractica(selObjPractica);
            obj.setObjTipoNotificacion(new cTipoNotificacion(2)); //2=Informativo
            obj.setObjEstadoNotificacion(new cEstadoNotificacion(1)); //1=No Visto
            mNotificacion.insertarNotificacion(obj);

        } catch (Exception e) {
            Util.fatalMessage("Error (Try-Catch) (asignar): ", e.getMessage());
        }
        
    }

    public void aprobar() {
        try {
            selObjPractica.setObjEstadoPractica(new cEstadoPractica(3)); //3=Asignado
            mPractica.actualizar(selObjPractica);
            cNotificacion obj = new cNotificacion();
            //Para Estudiante
            StringBuilder me = new StringBuilder();
            me.append("Estimado estudiante, su socilitud de práctica preprofesional, ");
            me.append(selObjPractica.getObjTipoPractica().getNombre());
            me.append(", denominado ");
            me.append(selObjPractica.getNombre());
            me.append(" a sido aprobada.  ");

            obj.setMensaje(me.toString());
            obj.setFechaGeneracion(new Date());
            obj.setObjUsuario(new cUsuario(2));
            obj.setObjPractica(selObjPractica);
            obj.setObjTipoNotificacion(new cTipoNotificacion(2)); //2=Informativo
            obj.setObjEstadoNotificacion(new cEstadoNotificacion(1)); //1=No Visto
            mNotificacion.insertarNotificacion(obj);

        } catch (Exception e) {
            Util.fatalMessage("Error (Try-Catch) (asignar): ", e.getMessage());
        }
    }

    public void cargarPracticasSolicitadas() {
        try {
            lstPracticasSolicitadas = mPractica.obetenerListaPorIdEstado(2); // 1=Solicitada
        } catch (Exception e) {
            Util.fatalMessage("Error (Try-Catch) (cargarPracticasSolicitadas): ", e.getMessage());
        }
    }
}
