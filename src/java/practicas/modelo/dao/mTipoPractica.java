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
import practicas.modelo.entidad.cTipoPractica;

/**
 *
 * @author Programador
 */
public class mTipoPractica {

    public static List<cTipoPractica> obetenerTodosActivos() throws Exception {
        List lista = new ArrayList();
        StringBuilder sql = new StringBuilder();
        try {
            sql.append("select * ");
            sql.append("from tipopractica ");
            sql.append("where estado=? ");
            sql.append("order by nombre; ");
            ArrayList<Parametro> lstParam = new ArrayList<>();
            lstParam.add(new Parametro(1, true));
            ConjuntoResultado rs = AccesoDatos.ejecutarQuery(sql.toString(), lstParam);
            while (rs.next()) {
                cTipoPractica obj = new cTipoPractica();
                obj.setIdTipoPractica(rs.getInt("idtipopractica"));
                obj.setCodigo(rs.getString("codigo"));
                obj.setNombre(rs.getString("nombre"));
                obj.setEstado(rs.getBoolean("estado"));
                lista.add(obj);
            }

        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    public static List<cTipoPractica> obetenerTodos() throws Exception {
        List lista = new ArrayList();
        StringBuilder sql = new StringBuilder();
        try {
            sql.append("select * ");
            sql.append("from tipopractica ");
            sql.append("order by idtipopractica; ");
            ArrayList<Parametro> lstParam = new ArrayList<>();
            lstParam.add(new Parametro(1, true));
            ConjuntoResultado rs = AccesoDatos.ejecutarQuery(sql.toString(), lstParam);
            while (rs.next()) {
                cTipoPractica obj = new cTipoPractica();
                obj.setIdTipoPractica(rs.getInt("idtipopractica"));
                obj.setCodigo(rs.getString("codigo"));
                obj.setNombre(rs.getString("nombre"));
                obj.setEstado(rs.getBoolean("estado"));
                lista.add(obj);
            }

        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    public static cTipoPractica obetenerPorId(int id) throws Exception {
        cTipoPractica obj = new cTipoPractica();
        StringBuilder sql = new StringBuilder();
        try {
            sql.append("SELECT * FROM tipopractica where idtipopractica=? order by idtipopractica");
            ArrayList<Parametro> lstParam = new ArrayList<>();
            lstParam.add(new Parametro(1, id));
            ConjuntoResultado rs = AccesoDatos.ejecutarQuery(sql.toString(), lstParam);
            while (rs.next()) {
                obj.setIdTipoPractica(rs.getInt("idtipopractica"));
                obj.setNombre(rs.getString("nombre"));
                obj.setEstado(rs.getBoolean("estado"));
            }
        } catch (Exception e) {
            throw e;
        }
        return obj;
    }
}
