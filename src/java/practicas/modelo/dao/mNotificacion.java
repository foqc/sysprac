/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas.modelo.dao;

import java.sql.Timestamp;
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
        List<cNotificacion> lst = null;
        StringBuilder sql = new StringBuilder();
        try {
            sql.append("SELECT * FROM notificacion ");
            sql.append("where idusuario=? ");
            sql.append("order by fechageneracion desc; ");
            ArrayList<Parametro> lstParam = new ArrayList<>();
            lstParam.add(new Parametro(1, idUsuario));
            ConjuntoResultado rs = AccesoDatos.ejecutarQuery(sql.toString(), lstParam);
            lst = new ArrayList<>();
            while (rs.next()) {
                cNotificacion obj = new cNotificacion();
                obj.setIdnotificacion(rs.getInt("idnotificacion"));
                obj.setMensaje(rs.getString("mensaje"));
                obj.setFechaGeneracion(rs.getTimeStamp("fechageneracion"));
                obj.setObjUsuario(mUsuario.usuarioObtenerId(rs.getInt("idusuario")));
                obj.setObjPractica(mPractica.obetenerPorId(rs.getInt("idpractica")));
                obj.setObjTipoNotificacion(mTipoNotificacion.obtenerporId(rs.getInt("idtiponotificacion")));
                obj.setObjEstadoNotificacion(mEstadoNotificacion.obtenerporId(rs.getInt("idestadonotificacion")));
                lst.add(obj);
            }

        } catch (Exception e) {
            throw e;
        }
        return lst;
    }

    public static boolean insertarNotificacion(cNotificacion objNotificacion) throws Exception {
        boolean resp = false;
        StringBuilder sql = new StringBuilder();
        try {
            sql.append("INSERT INTO notificacion ");
            sql.append("(mensaje,fechageneracion,idusuario,idpractica,idtiponotificacion,idestadonotificacion) ");
            sql.append("VALUES (?,?,?,?,?,?) ");
            ArrayList<Parametro> lstParam = new ArrayList<>();
            lstParam.add(new Parametro(1, objNotificacion.getMensaje()));
            lstParam.add(new Parametro(2, new Timestamp(objNotificacion.getFechaGeneracion().getTime())));
            lstParam.add(new Parametro(3, objNotificacion.getObjUsuario().getIdusuario()));
            lstParam.add(new Parametro(4, objNotificacion.getObjPractica().getIdPractica()));
            lstParam.add(new Parametro(5, objNotificacion.getObjTipoNotificacion().getIdTipoNotificacion()));
            lstParam.add(new Parametro(6, objNotificacion.getObjEstadoNotificacion().getIdEstadoNotificacion()));
            resp = AccesoDatos.ejecutarComando(sql.toString(), lstParam);
        } catch (Exception e) {
            throw e;
        }

        return resp;

    }

}
