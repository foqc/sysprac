/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas.modelo.accesodatos;

import java.util.List;

/**
 *
 * @author Programador
 */
public class CrearComando {

    public static String insert(String esquema, String tabla, List<String> lstCampos) {

        long inicio = System.nanoTime();
        double tiempo;

        StringBuilder sql = new StringBuilder();
        int i = 0;
        int n = lstCampos.size();
        try {
            sql.append("INSERT INTO ");
            sql.append(esquema);
            sql.append(".");
            sql.append(tabla);
            sql.append("(");
            for (String campo : lstCampos) {
                if ((n - 1) == i) {
                    sql.append(campo);
                } else {
                    sql.append(campo);
                    sql.append(",");
                }
                i++;
            }
            sql.append(") ");
            sql.append("VALUES ");
            sql.append("( ");

            for (i = 0; i < n; i++) {
                if ((n - 1) == i) {
                    sql.append("?");
                } else {
                    sql.append("?");
                    sql.append(", ");
                }
            }
            sql.append(") ");
        } catch (Exception e) {
            System.err.println("Error en CrearComando -> insert: " + e.getMessage());
            throw e;
        }
        long fin = System.nanoTime();
        tiempo = (double) ((fin - inicio));
        System.out.println("Tiempo de CrearComando insert : " + tiempo + " nanosegundos");
        return sql.toString();
    }

    public static String update(String esquema, String tabla, List<String> lstCampos) {

        long inicio = System.nanoTime();
        double tiempo;

        StringBuilder sql = new StringBuilder();
        int i = 0;
        int n = lstCampos.size();
        try {
            sql.append("UPDATE ");
            sql.append(esquema);
            sql.append(".");
            sql.append(tabla);
            sql.append(" SET ");
            for (String campo : lstCampos) {
                if ((n - 1) == i) {
                    sql.append(" WHERE ");
                    sql.append(campo);
                    sql.append("=");
                    sql.append("?");
                } else {
                    if ((n - 2) == i) {
                        sql.append(campo);
                        sql.append("=");
                        sql.append("? ");
                    } else {
                        sql.append(campo);
                        sql.append("=");
                        sql.append("?, ");
                    }
                }
                i++;
            }

        } catch (Exception e) {
            System.err.println("Error en CrearComando -> update: " + e.getMessage());
            throw e;
        }
        long fin = System.nanoTime();
        tiempo = (double) ((fin - inicio));
        System.out.println("Tiempo de CrearComando -> update : " + tiempo + " nanosegundos");
        return sql.toString();
    }
}
