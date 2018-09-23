package practicas.modelo.conexion;

import java.net.URL;

/**
 *
 * @author Tupac Amaruc Tisalema Poaquiza
 */
public class Ruta {

    private final String dbPropiedades = "/practicas/modelo/conexion/dbpropiedades.properties";

    public URL getFilePropiedades() {
        return getClass().getResource(dbPropiedades);
    }
}
