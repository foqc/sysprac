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
            sql.append("SELECT * FROM tipopractica where estado=? order by idetipopractica");
            ArrayList<Parametro> lstParam = new ArrayList<>();
            lstParam.add(new Parametro(1, true));
            ConjuntoResultado rs = AccesoDatos.ejecutarQuery(sql.toString(), lstParam);
            while (rs.next()) {
                cTipoPractica obj = new cTipoPractica();
                obj.setIdtipopractica(rs.getInt("idetipopractica"));
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
            sql.append("SELECT * FROM tipopractica where idetipopractica=? order by idetipopractica");
            ArrayList<Parametro> lstParam = new ArrayList<>();
            lstParam.add(new Parametro(1, id));
            ConjuntoResultado rs = AccesoDatos.ejecutarQuery(sql.toString(), lstParam);
            while (rs.next()) {
                obj.setIdtipopractica(rs.getInt("idetipopractica"));
                obj.setNombre(rs.getString("nombre"));
                obj.setEstado(rs.getBoolean("estado"));
            }
        } catch (Exception e) {
            throw e;
        }
        return obj;
    }
}
