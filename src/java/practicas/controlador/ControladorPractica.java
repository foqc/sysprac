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
import practicas.modelo.dao.mNotificacion;
import practicas.modelo.dao.mPractica;
import practicas.modelo.dao.mTipoPractica;
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

    /**
     * Creates a new instance of ControladorPractica
     */
    public ControladorPractica() {

        objPractica = new cPractica();

    }

    @PostConstruct
    public void init() {
        try {
            cPractica obj = mPractica.obetenerPorIdUsuarioPorIdEstado(1, 1);
            if (obj != null) {
                objPractica = obj;
            } else {
                objPractica.setObjTipoPractica(new cTipoPractica());
            }
        } catch (Exception e) {
        }
    }

    public cPractica getObjPractica() {
        return objPractica;
    }

    public void setObjPractica(cPractica objPractica) {
        this.objPractica = objPractica;
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

    public void insertar() {
        try {
            objPractica.setObjUsuario(new cUsuario(1));
            objPractica.setObjEstadoPractica(new cEstadoPractica(1));
            objPractica.setObjTipoPractica(new cTipoPractica(1));
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
            objPractica.setObjEstadoPractica(new cEstadoPractica(2));
            mPractica.actualizar(objPractica);
            cNotificacion obj = new cNotificacion();
            obj.setMensaje("Mensaje Test 1");
            obj.setFechaGeneracion(new Date());
            obj.setObjUsuario(new cUsuario(2));
            obj.setObjPractica(objPractica);
            obj.setObjTipoNotificacion(new cTipoNotificacion(1));
            obj.setObjEstadoNotificacion(new cEstadoNotificacion(1));
            mNotificacion.insertarNotificacion(obj);

        } catch (Exception e) {
            Util.fatalMessage("Error (Try-Catch) (solicitar): ", e.getMessage());
        }
    }

}
