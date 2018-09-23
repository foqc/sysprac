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
import practicas.modelo.entidad.cPractica;

/**
 *
 * @author Programador
 */
public class mPractica {

    public static cPractica obetenerPorId(int id) throws Exception {
        cPractica obj = new cPractica();
        StringBuilder sql = new StringBuilder();
        try {
            sql.append("SELECT * FROM tipopractica where idetipopractica=? order by idetipopractica");
            ArrayList<Parametro> lstParam = new ArrayList<>();
            lstParam.add(new Parametro(1, id));
            ConjuntoResultado rs = AccesoDatos.ejecutarQuery(sql.toString(), lstParam);
            while (rs.next()) {
                obj.setIdPractica(rs.getInt("idetipopractica"));
                obj.setNombre(rs.getString("nombre"));
                obj.setDescripcion(rs.getString("descripcion"));
            }
        } catch (Exception e) {
            throw e;
        }
        return obj;
    }

    public static boolean insertar(cPractica obj) throws Exception {
        boolean resp = false;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("insert into ");
            sql.append("practica (nombre,descripcion,empresa,idestadopractica,idusuario,idtipopractica,codigoescuela) ");
            sql.append("values ( ?,?,?,?,?,?,?); ");

            ArrayList<Parametro> lstParam = new ArrayList<>();
            lstParam.add(new Parametro(1, obj.getNombre()));
            lstParam.add(new Parametro(2, obj.getDescripcion()));
            lstParam.add(new Parametro(3, obj.getEmpresa()));
            lstParam.add(new Parametro(4, obj.getObjEstadoPractica().getIdEstadoPractica()));
            lstParam.add(new Parametro(5, obj.getObjUsuario().getIdusuario()));
            lstParam.add(new Parametro(6, obj.getObjTipoPractica().getIdTipoPractica()));
            lstParam.add(new Parametro(7, obj.getCodigoEscuela()));
            resp = AccesoDatos.ejecutarComando(sql.toString(), lstParam);
        } catch (Exception e) {
            throw e;
        }
        return resp;
    }

    public static boolean actualizar(cPractica obj) throws Exception {
        boolean resp = false;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("update practica set  ");
            sql.append("nombre=?,descripcion=?,empresa=?,idestadopractica=?,idusuario=?,idtipopractica=?,codigoescuela=? ");
            sql.append("where idpractica=?; ");

            ArrayList<Parametro> lstParam = new ArrayList<>();
            lstParam.add(new Parametro(1, obj.getNombre()));
            lstParam.add(new Parametro(2, obj.getDescripcion()));
            lstParam.add(new Parametro(3, obj.getEmpresa()));
            lstParam.add(new Parametro(4, obj.getObjEstadoPractica().getIdEstadoPractica()));
            lstParam.add(new Parametro(5, obj.getObjUsuario().getIdusuario()));
            lstParam.add(new Parametro(6, obj.getObjTipoPractica().getIdTipoPractica()));
            lstParam.add(new Parametro(7, obj.getCodigoEscuela()));
            lstParam.add(new Parametro(8, obj.getIdPractica()));
            resp = AccesoDatos.ejecutarComando(sql.toString(), lstParam);
        } catch (Exception e) {
            throw e;
        }
        return resp;
    }

    public static cPractica obetenerPorIdUsuarioPorIdEstado(int idUsuario, int idEstado) throws Exception {
        cPractica obj = new cPractica();
        StringBuilder sql = new StringBuilder();
        try {
            sql.append("select * ");
            sql.append("from practica ");
            sql.append("where idUsuario=? ");
            sql.append("and idestadosolicitado=?; ");
            ArrayList<Parametro> lstParam = new ArrayList<>();
            lstParam.add(new Parametro(1, idUsuario));
            lstParam.add(new Parametro(2, idEstado));
            ConjuntoResultado rs = AccesoDatos.ejecutarQuery(sql.toString(), lstParam);
            while (rs.next()) {
                obj.setIdPractica(rs.getInt("idetipopractica"));
                obj.setNombre(rs.getString("nombre"));
                obj.setDescripcion(rs.getString("descripcion"));
            }
        } catch (Exception e) {
            throw e;
        }
        return obj;
    }
}
