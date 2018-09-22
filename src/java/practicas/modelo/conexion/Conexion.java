package practicas.modelo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 *
 * @author Tupac Amaruc Tisalema Poaquiza
 */
public class Conexion extends cPropiedades {

    private DataSource dataSource = null;
    private Connection cnx;

    public Conexion(String usuario, String contrasena, String url, String driver) {
        setUsuario(usuario);
        setContrasena(contrasena);
        setUrl(url);
        setDriver(driver);
    }

    public Connection getCnx() {
        return cnx;
    }

    public void setCnx(Connection cnx) {
        this.cnx = cnx;
    }

    //<editor-fold desc="Conectar">
    public boolean conectarBD() throws InstantiationException, ClassNotFoundException, SQLException, IllegalAccessException {
        //jdbc:postgresql://localhost:5432/optimus
        //jdbc:sqlserver://localhost:1433/prueba
        try {
            Class.forName(getDriver()).newInstance();
            cnx = DriverManager.getConnection(getUrl(), getUsuario(), getContrasena());
            //    cnx = dataSource.getConnection();
            cnx.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            cnx.setAutoCommit(false); //se deshabilita el modo de confirmación automática
            return true;

        } catch (SQLException ex) {
            System.err.println("Mensaje: " + ex.getMessage());
            System.err.println("Localización: " + ex.getLocalizedMessage());
            throw ex;
        }
    }
    //</editor-fold>

    //<editor-fold desc="Confitmar -> Commit">
    public boolean confrimar() throws SQLException {
        try {
            cnx.commit();
            return true;
        } catch (SQLException ex) {
            System.err.println("Mensaje: " + ex.getMessage());
            System.err.println("Localización: " + ex.getLocalizedMessage());
            throw ex;
        }
    }
    //</editor-fold>

    //<editor-fold desc="Deshacer -> Rollback">
    public boolean deshacer() throws SQLException {
        try {
            cnx.rollback();      // Retrotraer la transacción
            return true;
        } catch (SQLException ex) {
            System.err.println("Mensaje: " + ex.getMessage());
            System.err.println("Localización: " + ex.getLocalizedMessage());
            throw ex;
        }
    }
    //</editor-fold>

    //<editor-fold desc="Desconectar">
    public boolean desconectarBD() throws SQLException {
        try {
            cnx.close();
            return true;
        } catch (SQLException ex) {
            System.err.println("Mensaje: " + ex.getMessage());
            System.err.println("Localización: " + ex.getLocalizedMessage());
            throw ex;
        }
    }
    //</editor-fold>

    //<editor-fold desc="Verifica si se Cerraó la Conexión">
    public boolean conexionCerrada() throws SQLException {
        try {
            return cnx.isClosed();
        } catch (SQLException ex) {
            System.err.println("Mensaje: " + ex.getMessage());
            System.err.println("Localización: " + ex.getLocalizedMessage());
            throw ex;
        }
    }
    //</editor-fold>
}
