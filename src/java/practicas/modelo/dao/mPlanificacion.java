/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas.modelo.dao;

import java.util.ArrayList;
import practicas.modelo.accesodatos.AccesoDatos;
import practicas.modelo.accesodatos.Parametro;
import practicas.modelo.entidad.cPlanificacion;

/**
 *
 * @author Programador
 */
public class mPlanificacion {

    public static boolean insertar(cPlanificacion obj) throws Exception {
        boolean resp = false;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("");
            ArrayList<Parametro> lstParam = new ArrayList<>();
            lstParam.add(new Parametro(1, obj.getFechaInicio()));
            lstParam.add(new Parametro(2, obj.getFechaFin()));
            lstParam.add(new Parametro(3, obj.getTotalHoras()));
            lstParam.add(new Parametro(4, obj.getObjPractica().getIdPractica()));
            resp = AccesoDatos.ejecutarComando(sql.toString(), lstParam);
        } catch (Exception e) {
            throw e;
        }
        return resp;
    }
}
