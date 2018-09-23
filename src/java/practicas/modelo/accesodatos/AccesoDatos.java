package practicas.modelo.accesodatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import practicas.modelo.conexion.Conexion;
import practicas.modelo.conexion.Ruta;
import practicas.modelo.conexion.mPropiedades;

/**
 *
 * @author Tupac Amaruc Tisalema Poaquiza
 */
public class AccesoDatos {

//<editor-fold desc="PostgreSQL SERVER">    
    //<editor-fold desc="Ejecutar ejecutarQuery(String query)">
    public static ConjuntoResultado ejecutarQuery(String query) throws Exception {
        ConjuntoResultado objRes = null;
        ResultSet rs = null;
        PreparedStatement ptrs = null;
        try {
            Ruta objRuta = new Ruta();
            mPropiedades objProp = new mPropiedades(objRuta.getFilePropiedades()); //Lee propiedades para la conexión
            Conexion objConexion = new Conexion(
                    objProp.getUsuario(),
                    objProp.getContrasena(),
                    objProp.getUrl(),
                    objProp.getDriver()
            );
            try {
                objConexion.conectarBD();
                ptrs = objConexion.getCnx().prepareStatement(query); //Precompilo una sentencia SQL
                rs = ptrs.executeQuery();  //Ejecuto la sentencia SQL y obtengo el registro buscado
                objConexion.confrimar();
                objRes = new ConjuntoResultado();
                objRes.Fill(rs);
                rs.close();
                ptrs.close();
            } catch (SQLException e) {
                objConexion.deshacer();
                throw e;
            } finally {
                try {
                    //Verifico si la conexión no está cerrada
                    if (!objConexion.conexionCerrada()) {
                        objConexion.desconectarBD();
                    }
                } catch (SQLException ex) {
                    System.err.println("Mensaje: " + ex.getMessage());
                    System.err.println("Localización: " + ex.getLocalizedMessage());
                    throw ex;
                }
            }
        } catch (Exception e) {
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Localización: " + e.getLocalizedMessage());
        }
        return objRes;
    }
    //</editor-fold>

    //<editor-fold desc="Ejecutar ejecutarQuery(String query, ArrayList<Parametro> param)">
        public static ConjuntoResultado ejecutarQuery(String query, ArrayList<Parametro> param) throws Exception {
        long inicio = System.currentTimeMillis();
        double tiempo;

        ConjuntoResultado objRes = new ConjuntoResultado();
        ResultSet rs = null;
        PreparedStatement ptrs = null;
        try {
            Ruta objRuta = new Ruta();
            mPropiedades objProp = new mPropiedades(objRuta.getFilePropiedades()); //Lee propiedades para la conexión
            Conexion objConexion = new Conexion(
                    objProp.getUsuario(),
                    objProp.getContrasena(),
                    objProp.getUrl(),
                    objProp.getDriver());
            try {
                objConexion.conectarBD(); //

                ptrs = objConexion.getCnx().prepareStatement(query); //Precompilo una sentencia SQL
                for (Parametro param1 : param) {
                    if (param1.getTipo() != null && param1.getTipo() == 2) { //Si el tipo es igual a 2, significa que es Array.
                        ptrs.setArray(param1.getPosicion(), objConexion.getCnx().createArrayOf("varchar", param1.getValorArray()));
                    } else {
                        ptrs.setObject(param1.getPosicion(), param1.getValor());
                    }
                }
                rs = ptrs.executeQuery();  //Ejecuto la sentencia SQL y obtengo el registro buscado
                objConexion.confrimar(); //commit
                objRes.Fill(rs);
                rs.close();
                ptrs.close();
            } catch (SQLException e) {
                if (objConexion.getCnx() != null) {
                    objConexion.deshacer(); //rollback
                }
                throw e;
            } finally {
                try {
                    //Verifico si la conexión no está cerrada
                    if (objConexion.getCnx() != null) {
                        if (!objConexion.conexionCerrada()) {
                            objConexion.desconectarBD();
                        }
                    }
                } catch (SQLException ex) {
                    System.err.println("Mensaje: " + ex.getMessage());
                    System.err.println("Localización: " + ex.getLocalizedMessage());
                    throw ex;
                }
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Localización: " + e.getLocalizedMessage());
        }

        long fin = System.currentTimeMillis();
        tiempo = (double) ((fin - inicio));
        System.out.println("Tiempo de AccesoDatos ejecutarQuery : " + tiempo + " milisegundos");
        tiempo = (double) ((fin - inicio) / 1000);
        System.out.println("Tiempo de AccesoDatos ejecutarQuery: " + tiempo + " segundos");

        return objRes;
    }
    //</editor-fold>

    //<editor-fold desc="Ejecutar ejecutarComando(String query, ArrayList<Parametro> param)">
    //Solo devuelve true o false
    public static Boolean ejecutarComando(String query, ArrayList<Parametro> param) throws Exception {
        Boolean respuesta = false;
        PreparedStatement ptrs = null;
        try {
            Ruta objRuta = new Ruta();
            mPropiedades objProp = new mPropiedades(objRuta.getFilePropiedades()); //Lee propiedades para la conexión
            Conexion objConexion = new Conexion(
                    objProp.getUsuario(),
                    objProp.getContrasena(),
                    objProp.getUrl(),
                    objProp.getDriver());
            try {
                objConexion.conectarBD(); //

                ptrs = objConexion.getCnx().prepareStatement(query); //Precompilo una sentencia SQL
                for (Parametro param1 : param) {
                    if (param1.getTipo() != null && param1.getTipo() == 2) { //Si el tipo es igual a 2, significa que es Array.
                        ptrs.setArray(param1.getPosicion(), objConexion.getCnx().createArrayOf("varchar", param1.getValorArray()));
                    } else {
                        ptrs.setObject(param1.getPosicion(), param1.getValor());
                    }
                }
                //Ejecuto la sentencia SQL sin obtener registros
                int i = ptrs.executeUpdate();
                if (i > 0) {
                    respuesta = true;
                }
                objConexion.confrimar(); //commit
                ptrs.close();
            } catch (SQLException e) {
                objConexion.deshacer(); //rollback
                throw e;
            } finally {
                try {
                    //Verifico si la conexión no está cerrada
                    if (!objConexion.conexionCerrada()) {
                        objConexion.desconectarBD();
                    }
                } catch (SQLException ex) {
                    System.err.println("Mensaje: " + ex.getMessage());
                    System.err.println("Localización: " + ex.getLocalizedMessage());
                    throw ex;
                }
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Localización: " + e.getLocalizedMessage());
        }
        return respuesta;
    }

    public static Boolean ejecutarComando(List<Query> lstQuery) throws Exception {
        Boolean respuesta = false;
        PreparedStatement ptrs = null;
        try {
            Ruta objRuta = new Ruta();
            mPropiedades objProp = new mPropiedades(objRuta.getFilePropiedades()); //Lee propiedades para la conexión
            Conexion objConexion = new Conexion(
                    objProp.getUsuario(),
                    objProp.getContrasena(),
                    objProp.getUrl(),
                    objProp.getDriver());
            try {
                objConexion.conectarBD(); //
                int i = 0;
                for (Query query : lstQuery) {
                    ptrs = objConexion.getCnx().prepareStatement(query.getSql()); //Precompilo una sentencia SQL
                    for (Parametro param : query.getLstParam()) {
                        if (param.getTipo() != null && param.getTipo() == 2) { //Si el tipo es igual a 2, significa que es Array.
                            ptrs.setArray(param.getPosicion(), objConexion.getCnx().createArrayOf("varchar", param.getValorArray()));
                        } else {
                            ptrs.setObject(param.getPosicion(), param.getValor());
                        }
                    }
                    //Ejecuto la sentencia SQL sin obtener registros
                    i = ptrs.executeUpdate();
                }
                if (i > 0) {
                    respuesta = true;
                    objConexion.confrimar(); //commit
                }

                if (ptrs != null) {
                    ptrs.close();
                }
            } catch (SQLException e) {
                objConexion.deshacer(); //rollback
                throw e;
            } finally {
                try {
                    //Verifico si la conexión no está cerrada
                    if (!objConexion.conexionCerrada()) {
                        objConexion.desconectarBD();
                    }
                } catch (SQLException ex) {
                    System.err.println("Mensaje: " + ex.getMessage());
                    throw ex;
                }
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Mensaje: " + e.getMessage());
            throw e;
        }
        return respuesta;
    }

    //</editor-fold>
    //<editor-fold desc="Ejecutar ejecutarComando(String query)">
    //Solo devueleve true o false
    public static Boolean ejecutarComando(String query) throws Exception {
        Boolean respuesta = false;
        PreparedStatement ptrs = null;
        try {
            Ruta objRuta = new Ruta();
            mPropiedades objProp = new mPropiedades(objRuta.getFilePropiedades()); //Lee propiedades para la conexión
            Conexion objConexion = new Conexion(
                    objProp.getUsuario(),
                    objProp.getContrasena(),
                    objProp.getUrl(),
                    objProp.getDriver());
            try {
                objConexion.conectarBD(); //
                ptrs = objConexion.getCnx().prepareStatement(query); //Precompilo una sentencia SQL
                //Ejecuto la sentencia SQL sin obtener registros
                int i = ptrs.executeUpdate();
                if (i > 0) {
                    respuesta = true;
                }
                objConexion.confrimar(); //commit
                ptrs.close();
            } catch (SQLException e) {
                objConexion.deshacer(); //rollback
                throw e;
            } finally {
                try {
                    //Verifico si la conexión no está cerrada
                    if (!objConexion.conexionCerrada()) {
                        objConexion.desconectarBD();
                    }
                } catch (SQLException ex) {
                    System.err.println("Mensaje: " + ex.getMessage());
                    System.err.println("Localización: " + ex.getLocalizedMessage());
                    throw ex;
                }
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Localización: " + e.getLocalizedMessage());
        }
        return respuesta;
    }

    //</editor-fold>
//</editor-fold>
//Revisar para SQLServer -> No Probado
//<editor-fold desc="SQLSERVER">    
    //<editor-fold desc="Ejecutar procedimientos SQLSERVER con parámetros">
    public static ConjuntoResultado ejecutarProcedure(String query, ArrayList<Parametro> param) throws Exception {
        ConjuntoResultado objRes = new ConjuntoResultado();
        ResultSet rs = null;
        PreparedStatement ptrs = null;
        try {
            Ruta objRuta = new Ruta();
            mPropiedades objProp = new mPropiedades(objRuta.getFilePropiedades()); //Lee propiedades para la conexión
            Conexion objConexion = new Conexion(
                    objProp.getUsuario(),
                    objProp.getContrasena(),
                    objProp.getUrl(),
                    objProp.getDriver());
            try {
                objConexion.conectarBD(); //

                ptrs = objConexion.getCnx().prepareStatement(query); //Precompilo una sentencia SQL
                for (Parametro param1 : param) {
                    if (param1.getTipo() != null && param1.getTipo() == 2) { //Si el tipo es igual a 2, significa que es Array.
                        ptrs.setArray(param1.getPosicion(), objConexion.getCnx().createArrayOf("varchar", param1.getValorArray()));
                    } else {
                        ptrs.setObject(param1.getPosicion(), param1.getValor());
                    }
                }

                boolean results = ptrs.execute();
                if (results) {
                    rs = ptrs.getResultSet();
                } else {
                    int cont = ptrs.getUpdateCount();
                    results = ptrs.getMoreResults();
                    if (results) {
                        rs = ptrs.getResultSet();
                    }
                }
                //rs = ptrs.executeQuery();  //Ejecuto la sentencia SQL y obtengo el registro buscado
                objConexion.confrimar(); //commit
                objRes.Fill(rs);
                rs.close();
                ptrs.close();
            } catch (SQLException e) {
                objConexion.deshacer(); //rollback
                throw e;
            } finally {
                try {
                    //Verifico si la conexión no está cerrada
                    if (!objConexion.conexionCerrada()) {
                        objConexion.desconectarBD();
                    }
                } catch (SQLException ex) {
                    System.err.println("Mensaje: " + ex.getMessage());
                    System.err.println("Localización: " + ex.getLocalizedMessage());
                    throw ex;
                }
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Localización: " + e.getLocalizedMessage());
        }
        return objRes;
    }
    //</editor-fold>

//</editor-fold>
}
