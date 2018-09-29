/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas.modelo.dao;

import java.util.ArrayList;
import practicas.modelo.accesodatos.AccesoDatos;
import practicas.modelo.accesodatos.Parametro;
import practicas.modelo.entidad.cTutor;

/**
 *
 * @author Programador
 */
public class mTutor {

    public static boolean insertar(cTutor obj) throws Exception {
        boolean resp = false;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("insert into ");
            sql.append("tutor (idpractica,idusuario,estado) ");
            sql.append("values ( ?,?,?,?,?,?,?); ");

            ArrayList<Parametro> lstParam = new ArrayList<>();
            lstParam.add(new Parametro(1, obj.getIdPractica()));
            lstParam.add(new Parametro(2, obj.getIdUsuario()));
            lstParam.add(new Parametro(3, obj.isEstado()));
            resp = AccesoDatos.ejecutarComando(sql.toString(), lstParam);
        } catch (Exception e) {
            throw e;
        }
        return resp;
    }

}
