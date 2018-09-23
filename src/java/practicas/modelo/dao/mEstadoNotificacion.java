/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas.modelo.dao;

import java.util.ArrayList;
import practicas.modelo.accesodatos.AccesoDatos;
import practicas.modelo.accesodatos.ConjuntoResultado;
import practicas.modelo.accesodatos.Parametro;
import practicas.modelo.entidad.cEstadoNotificacion;

/**
 *
 * @author Jhonathan
 */
public class mEstadoNotificacion {

    public static cEstadoNotificacion obtenerporId(int idestadonotificacion) throws Exception {
        cEstadoNotificacion obj = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM estadonotificacion where idestadonotificacion=? order by idestadonotificacion");
        ArrayList<Parametro> lstParam = new ArrayList<>();
        lstParam.add(new Parametro(1, idestadonotificacion));
        ConjuntoResultado rs = AccesoDatos.ejecutarQuery(sql.toString(), lstParam);
        try {
            while (rs.next()) {
                obj = new cEstadoNotificacion();
                obj.setIdEstadoNotificacion(rs.getInt("idestadonotificacion"));
                obj.setNombre(rs.getString("nombre"));
                obj.setEstado(rs.getBoolean("estado"));
            }
        } catch (Exception e) {
            throw e;
        }
        return obj;
    }
}
