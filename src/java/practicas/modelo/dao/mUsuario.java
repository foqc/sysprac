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
import practicas.modelo.entidad.cUsuario;

/**
 *
 * @author Jhonathan
 */
public class mUsuario {

    public static cUsuario usuarioIniciarSesion(String cedula) throws Exception {
        cUsuario obj = null;
        String sql;
        try {
            sql = "SELECT * FROM usuario WHERE cedula=?";
            ArrayList<Parametro> lstParam = new ArrayList<>();
            lstParam.add(new Parametro(1, cedula));
            ConjuntoResultado rs = AccesoDatos.ejecutarQuery(sql, lstParam);
            while (rs.next()) {
                obj = new cUsuario();
                obj.setIdusuario(rs.getInt("idusuario"));
                obj.setCedula(rs.getString("cedula"));
                obj.setNombre(rs.getString("nombre"));
                obj.setObjTipoUsuario(mTipoUsuario.obetenerPorId(rs.getInt("idtipousuario")));
                obj.setEstado(rs.getBoolean("estado"));
            }
        } catch (Exception e) {
            throw e;
        }
        return obj;
    }

    public static List<cUsuario> usuarioObtenerTodos() throws Exception {
        List lista = new ArrayList();
        String sql;
        try {
            sql = "SELECT * FROM usuario";
            ConjuntoResultado rs = AccesoDatos.ejecutarQuery(sql);
            while (rs.next()) {
                cUsuario obj = new cUsuario();
                obj.setIdusuario(rs.getInt("idusuario"));
                obj.setCedula(rs.getString("cedula"));
                obj.setNombre(rs.getString("nombre"));
                obj.setObjTipoUsuario(mTipoUsuario.obetenerPorId(rs.getInt("idtipousuario")));
                obj.setEstado(rs.getBoolean("estado"));
                lista.add(obj);

            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    public static cUsuario usuarioObtenerId(int idusuario) throws Exception {
        cUsuario obj = null;

        String sql;
        try {
            sql = "SELECT * FROM usuario WHERE idusuario=?";
            ArrayList<Parametro> lstParam = new ArrayList<>();
            lstParam.add(new Parametro(1, idusuario));
            ConjuntoResultado rs = AccesoDatos.ejecutarQuery(sql, lstParam);
            while (rs.next()) {
                obj = new cUsuario();
                obj.setIdusuario(rs.getInt("idusuario"));
                obj.setCedula(rs.getString("cedula"));
                obj.setNombre(rs.getString("nombre"));
                obj.setObjTipoUsuario(mTipoUsuario.obetenerPorId(rs.getInt("idtipousuario")));
                obj.setEstado(rs.getBoolean("estado"));

            }
        } catch (Exception e) {
            throw e;
        }
        return obj;

    }

    public static List<cUsuario> obtenerListaPorIdTipoUsuario(int idTipoUsuario) throws Exception {
        List<cUsuario> lst = null;
        StringBuilder sql = new StringBuilder();
        try {
            sql.append("select * ");
            sql.append("from usuario ");
            sql.append("where idtipousuario=? ");
            ArrayList<Parametro> lstParam = new ArrayList<>();
            lstParam.add(new Parametro(1, idTipoUsuario));
            ConjuntoResultado rs = AccesoDatos.ejecutarQuery(sql.toString(), lstParam);
            lst = new ArrayList<>();
            while (rs.next()) {
                cUsuario obj = new cUsuario();
                obj.setIdusuario(rs.getInt("idusuario"));
                obj.setCedula(rs.getString("cedula"));
                obj.setNombre(rs.getString("nombre"));
                obj.setObjTipoUsuario(mTipoUsuario.obetenerPorId(rs.getInt("idtipousuario")));
                obj.setEstado(rs.getBoolean("estado"));
                lst.add(obj);
            }
        } catch (Exception e) {
            throw e;
        }
        return lst;

    }

}
