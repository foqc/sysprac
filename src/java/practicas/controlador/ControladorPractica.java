/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas.controlador;

import javax.inject.Named;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import practicas.modelo.dao.mPractica;
import practicas.modelo.entidad.cPractica;
import practicas.modelo.entidad.cTipoPractica;

/**
 *
 * @author Programador
 */
@ManagedBean
@RequestScoped
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

    public void insertar() {
        try {
            if (mPractica.insertar(objPractica)) {
                

            } else {
            }
        } catch (Exception e) {
        }
    }
    
    
    
}
