/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas.controlador;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import practicas.modelo.dao.mPractica;
import practicas.modelo.dao.mTipoPractica;
import practicas.modelo.entidad.cEstadoPractica;
import practicas.modelo.entidad.cPractica;
import practicas.modelo.entidad.cTipoPractica;
import practicas.modelo.entidad.cUsuario;
import practicas.recursos.Util;

/**
 *
 * @author Programador
 */
@Named
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
        objPractica.setObjTipoPractica(new cTipoPractica());
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
            for (cTipoPractica obj : lst) {
                System.out.println("Nombre: " + obj.getNombre());
            }
        } catch (Exception e) {
        }
    }

    public void insertar() {
        try {
            objPractica.setObjUsuario(new cUsuario());
            objPractica.setObjEstadoPractica(new cEstadoPractica(1));
            objPractica.setObjTipoPractica(new cTipoPractica(1));
            objPractica.setCodigoEscuela("eis");
            if (mPractica.insertar(objPractica)) {
                Util.infoMessage("Aviso: ", "Datos guardados correctamente");
            } else {
                Util.errorMessage("Error: ", "Datos no guardados");
            }
        } catch (Exception e) {
            Util.fatalMessage("Error (Try-Catch) (usuarioInsertar): ", e.getMessage());
        }
    }
}
