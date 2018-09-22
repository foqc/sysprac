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
            sql.append("SELECT * FROM estadopractica where estado=? order by idestadopractica");
            ArrayList<Parametro> lstParam = new ArrayList<>();
            lstParam.add(new Parametro(1, true));
            ConjuntoResultado rs = AccesoDatos.ejecutarQuery(sql.toString(), lstParam);
            while (rs.next()) {
                cEstadoPractica obj = new cEstadoPractica();
                obj.setIdestadopractica(rs.getInt("idestadopractica"));
                obj.setNombre(rs.getString("nombre"));
                obj.setDescripcion(rs.getString("descripcion"));
                obj.setEstado(rs.getBoolean("estado"));
                lista.add(obj);
            }

        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
    
    public static cEstadoPractica obetenerPorId(int id) throws Exception {
        cEstadoPractica obj = new cEstadoPractica();
        StringBuilder sql = new StringBuilder();
        try {
            sql.append("SELECT * FROM estadopractica where idestadopractica=? order by idestadopractica");
            ArrayList<Parametro> lstParam = new ArrayList<>();
            lstParam.add(new Parametro(1, id));
            ConjuntoResultado rs = AccesoDatos.ejecutarQuery(sql.toString(), lstParam);
            while (rs.next()) {
                obj.setIdestadopractica(rs.getInt("idestadopractica"));
                obj.setNombre(rs.getString("nombre"));
                obj.setDescripcion(rs.getString("descripcion"));
                obj.setEstado(rs.getBoolean("estado"));
            }
        } catch (Exception e) {
            throw e;
        }
        return obj;
    }
}
