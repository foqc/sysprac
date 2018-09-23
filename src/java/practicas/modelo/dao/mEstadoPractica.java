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
import practicas.modelo.entidad.cEstadoPractica;

/**
 *
 * @author Programador
 */
public class mEstadoPractica {

    public static List<cEstadoPractica> obetenerTodosActivos() throws Exception {
        List lista = new ArrayList();
        StringBuilder sql = new StringBuilder();
        try {
            sql.append("select * ");
            sql.append("from estadopractica ");
            sql.append("where estado=? ");
            sql.append("order by nombre; ");
            ArrayList<Parametro> lstParam = new ArrayList<>();
            lstParam.add(new Parametro(1, true));
            ConjuntoResultado rs = AccesoDatos.ejecutarQuery(sql.toString(), lstParam);
            while (rs.next()) {
                cEstadoPractica obj = new cEstadoPractica();
                obj.setIdEstadoPractica(rs.getInt("idestadopractica"));
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

    public static cEstadoPractica obetenerPorId(int id) throws Exception {
        cEstadoPractica obj = null;
        StringBuilder sql = new StringBuilder();
        try {
            sql.append("SELECT * FROM estadopractica where idestadopractica=? order by idestadopractica");
            ArrayList<Parametro> lstParam = new ArrayList<>();
            lstParam.add(new Parametro(1, id));
            ConjuntoResultado rs = AccesoDatos.ejecutarQuery(sql.toString(), lstParam);
            while (rs.next()) {
                obj = new cEstadoPractica();
                obj.setIdEstadoPractica(rs.getInt("idestadopractica"));
                obj.setCodigo(rs.getString("codigo"));
                obj.setNombre(rs.getString("nombre"));
                obj.setEstado(rs.getBoolean("estado"));
            }
        } catch (Exception e) {
            throw e;
        }
        return obj;
    }
}
