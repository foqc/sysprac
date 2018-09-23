/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import practicas.modelo.conexion.Ruta;
import practicas.modelo.conexion.mPropiedades;
import practicas.modelo.conexion.Conexion;
import java.net.URL;
import java.sql.SQLException;

/**
 *
 * @author Programador
 */
public class PruebaConexion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            boolean result = false;
            mPropiedades propiedades;

            System.out.println("escribir");
            URL ruta = new Ruta().getFilePropiedades();
            propiedades = new mPropiedades(ruta, "localhost", "5432", "practicasdb", "postgres", "10091992", "POSTGRES", "jdbc:postgresql", "org.postgresql.Driver", "jdbc:postgresql://192.168.1.147/practicasdb");
            propiedades.escribir();
            result = propiedades.leer();
            if (!result) {
                System.out.println("Error");
            } else {
                System.out.println("ruta: " + ruta);
                System.out.println("ip: " + propiedades.getIpHost());
                System.out.println("puerto: " + propiedades.getPuerto());
                System.out.println("base de datos: " + propiedades.getBasedatos());
                System.out.println("usuario: " + propiedades.getUsuario());
                System.out.println("contraseña: " + propiedades.getContrasena());
                System.out.println("gestor: " + propiedades.getGestor());
                System.out.println("cadena de conexion: " + propiedades.getCadenaConexion());
                System.out.println("driver: " + propiedades.getDriver());
                System.out.println("url: " + propiedades.getUrl());

            }

            System.out.println("conectarBD");
            Conexion instance = new Conexion(
                    propiedades.getUsuario(),//"postgres",
                    propiedades.getContrasena(),//"10091992",
                    propiedades.getUrl(),//"jdbc:postgresql://192.168.1.147:5432/juntaangahuanadb",
                    propiedades.getDriver());//"org.postgresql.Driver");

            result = instance.conectarBD();
            result=instance.desconectarBD();
            

            if (!result) {
                System.err.println("Error");
            }
        } catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            System.err.println(e.getMessage());
        }

    }

}
