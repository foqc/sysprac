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

    public static List<cNotificacion> obetenerTodosPorIdUsuario(int idnotificacion) throws Exception {
        List lista = new ArrayList();
        StringBuilder sql = new StringBuilder();
        try {
            sql.append("SELECT * FROM notificacion where idnotificacion=? order by idnotificacion");
            ArrayList<Parametro> lstParam = new ArrayList<>();
            lstParam.add(new Parametro(1, idnotificacion));
            ConjuntoResultado rs = AccesoDatos.ejecutarQuery(sql.toString(), lstParam);
            while (rs.next()) {
                cNotificacion obj = new cNotificacion();
                obj.setIdnotificacion(rs.getInt("idnotificacion"));
                obj.setMensaje(rs.getString("mensaje"));
                obj.setFechaGeneracion(rs.getDate("fechageneracion"));
                obj.setObjUsuario(mUsuario.usuarioObtenerId(rs.getInt("idusuario")));
                obj.setObjPractica(mPractica.obetenerPorId(rs.getInt("idpractica")));
                obj.setObjTipoNotificacion(mTipoNotificacion.obtenerporId(rs.getInt("idtiponotificacion")));
                obj.setObjEstadoNotificacion(mEstadoNotificacion.obtenerporId(rs.getInt("idestadonotificacion")));
                lista.add(obj);
            }

        } catch (Exception e) {
                throw e;
        }
        return lista;
    }
    
    public static boolean insertarNotificacion(cNotificacion objNotificacion) throws Exception {
        boolean resp = false;
        StringBuilder sql = new StringBuilder();
        try{
            sql.append("INSERT INTO notificacion (idusuario,idpractica,idtiponotificacion,idestadonotificacion,mensaje,fechageneracion) VALUES (?,?,?,?,?,?)");
            ArrayList<Parametro> lstParam = new ArrayList<>();
            lstParam.add(new Parametro(1, objNotificacion.getIdnotificacion()));
            lstParam.add(new Parametro(2, objNotificacion.getObjUsuario().getIdusuario()));
            lstParam.add(new Parametro(3, objNotificacion.getObjPractica().getIdPractica()));
            lstParam.add(new Parametro(4, objNotificacion.getObjTipoNotificacion().getIdtiponotificacion()));
            lstParam.add(new Parametro(5, objNotificacion.getObjEstadoNotificacion().getIdestadonotificacion()));
            lstParam.add(new Parametro(6, objNotificacion.getMensaje()));
            lstParam.add(new Parametro(7, objNotificacion.getFechaGeneracion()));
            if(AccesoDatos.ejecutarComando(sql.toString(), lstParam))
            {
                resp=true;
            }else
            {
                resp=false;
            }
        }catch(Exception e)
        {
            throw e;
        }
        
        return resp;
        
    }

    
}
