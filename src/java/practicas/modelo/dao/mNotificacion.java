/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas.modelo.dao;

import java.util.ArrayList;
import java.util.List;
import practicas.modelo.accesodatos.AccesoDatos;
import practicas.modelo.accesodatos.ConjuntoResultado;
import practicas.modelo.accesodatos.Parametro;
import practicas.modelo.entidad.cNotificacion;

/**
 *
 * @author Jhonathan
 */
public class mNotificacion {

    public static List<cNotificacion> obetenerTodosPorIdUsuario(int idUsuario) throws Exception {
        List lista = new ArrayList();
        StringBuilder sql = new StringBuilder();
        try {
            sql.append("SELECT * FROM tipopractica where estado=? order by idetipopractica");
            ArrayList<Parametro> lstParam = new ArrayList<>();
            lstParam.add(new Parametro(1, idUsuario));
            ConjuntoResultado rs = AccesoDatos.ejecutarQuery(sql.toString(), lstParam);
            while (rs.next()) {
                cNotificacion obj = new cNotificacion();
                obj.setIdnotificacion(rs.getInt("idnotificacion"));
                obj.setMensaje(rs.getString("mensaje"));
                obj.setFechaGeneracion(rs.getDate("fechageneracio"));
                obj.setObjUsuario(mUsuario.usuarioObtenerId(rs.getInt("idusuario")));
                obj.setObjPractica(mPractica.obetenerPorId(rs.getInt("idpractica")));
                lista.add(obj);
            }

        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    
}
