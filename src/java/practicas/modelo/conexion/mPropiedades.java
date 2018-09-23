package practicas.modelo.conexion;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Properties;

/**
 *
 * @author Tupac Amaruc Tisalema Poaquiza
 */
public class mPropiedades extends cPropiedades {

    public mPropiedades(URL ruta, String ipHost, String puerto, String baseDatos, String usuario, String contrasena, String gestor, String cadenaConexion, String driver, String url) throws IOException {
        setRuta(ruta);
        setIpHost(ipHost);
        setPuerto(puerto);
        setBasedatos(baseDatos);
        setUsuario(usuario);
        setContrasena(contrasena);
        setGestor(gestor);
        setCadenaConexion(cadenaConexion);
        setDriver(driver);
        setUrl(url);
    }

    public mPropiedades(URL ruta) throws IOException {
        setRuta(ruta);
        leer();
    }

    public boolean escribir() throws FileNotFoundException, IOException {
        boolean respuesta = false;
        Properties propiedades = new Properties();
        OutputStream salida = new FileOutputStream(getRuta().getPath());
        try {
            // asignamos los valores a las propiedades
            propiedades.setProperty("iphost", getIpHost());
            propiedades.setProperty("puerto", getPuerto());
            propiedades.setProperty("namedb", getBasedatos());
            propiedades.setProperty("usuario", getUsuario());
            propiedades.setProperty("contrasena", getContrasena());
            propiedades.setProperty("gestor", getGestor());
            propiedades.setProperty("cadenaconexion", getCadenaConexion());
            propiedades.setProperty("url", getUrl());
            propiedades.setProperty("driver", getDriver());
            // guardamos el archivo de propiedades en la carpeta de aplicación
            propiedades.store(salida, null);
            respuesta = true;
        } catch (IOException io) {
            throw io;
        } finally {
            if (salida != null) {
                try {
                    salida.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return respuesta;
    }

    public boolean leer() throws IOException {
        boolean respuesta = false;
        try {
            Properties props = new Properties();
            try (InputStream in = ruta.openStream()) {
                props.load(in);
                setIpHost(props.getProperty("iphost"));
                setPuerto(props.getProperty("puerto"));
                setBasedatos(props.getProperty("namedb"));
                setUsuario(props.getProperty("usuario"));
                setContrasena(props.getProperty("contrasena"));
                setGestor(props.getProperty("gestor"));
                setCadenaConexion(props.getProperty("cadenaconexion"));
                setDriver(props.getProperty("driver"));
                setUrl(props.getProperty("url"));
                in.close();
                respuesta = true;
            }
        } catch (IOException e) {
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Localización: " + e.getLocalizedMessage());
            throw e;
        }
        return respuesta;
    }
}
