package practicas.modelo.accesodatos;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tupac Amaruc Tisalema Poaquiza
 */
public class ConjuntoResultado {

    //<editor-fold desc="Atributos">
    private String[] cabecera;
    private ArrayList<Object[]> datos;
    private int indCol;
    private int indFil;
    private int tamCol;
    private int tamFil;
    //</editor-fold>

    //<editor-fold desc="Constructor">
    public ConjuntoResultado() throws SQLException, Exception {
        this.indCol = -1;
        this.indFil = -1;
        this.tamCol = 0;
        this.tamFil = 0;

    }
    //</editor-fold>

    //<editor-fold desc="Getters and Setters">
    public String[] getCabecera() {
        return cabecera;
    }

    public void setCabecera(String[] cabecera) {
        this.cabecera = cabecera;
    }

    public ArrayList<Object[]> getdatos() {
        return datos;
    }

    public void setdatos(ArrayList<Object[]> datos) {
        this.datos = datos;
    }

    public int getIndCol() {
        return indCol;
    }

    public void setIndCol(int indCol) {
        this.indCol = indCol;
    }

    public int getIndFil() {
        return indFil;
    }

    public void setIndFil(int indFil) {
        this.indFil = indFil;
    }

    public int getTamCol() {
        return tamCol;
    }

    public void setTamCol(int tamCol) {
        this.tamCol = tamCol;
    }

    public int getTamFil() {
        return tamFil;
    }

    public void setTamFil(int tamFil) {
        this.tamFil = tamFil;
    }
    //</editor-fold>

    //<editor-fold desc="Fill->ResultSet">
    public void Fill(ResultSet rs) throws SQLException, Exception {

        try {
            ResultSetMetaData metaData = rs.getMetaData();
            tamCol = metaData.getColumnCount();
            cabecera = new String[getTamCol()];
            for (int i = 1; i <= getTamCol(); i++) {
                cabecera[i - 1] = metaData.getColumnName(i);
            }
            datos = new ArrayList<>();  //Ojo -> Si no funciona revisar esta parte
            try {
                //Ingreso de los datos en el ConjuntoResultados
                while (rs.next()) {
                    Object[] fila;
                    fila = new Object[getTamCol()];
                    for (int i = 1; i <= getTamCol(); i++) {
                        fila[i - 1] = rs.getObject(i);
                    }
                    datos.add(fila);
                    tamFil += 1;
                }
            } catch (Exception ex) {
                System.err.println("Mensaje: " + ex.getMessage());
                System.err.println("Localización: " + ex.getLocalizedMessage());
                throw ex;
            }
        } catch (SQLException e) {
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Localización: " + e.getLocalizedMessage());
            throw e;
        } catch (Exception ex) {
            System.err.println("Mensaje: " + ex.getMessage());
            System.err.println("Localización: " + ex.getLocalizedMessage());
            throw ex;
        }

    }
    //</editor-fold>

    //<editor-fold desc="Next">
    public boolean next() {
        boolean res = false;
        indFil += 1;
        if (indFil < getTamFil()) {
            res = true;
        }
        return res;
    }
    //</editor-fold>

    //<editor-fold desc="Parámetro de entrada es un int"> 
    //<editor-fold desc="Devuelve int">
    public int getInt(int nCol) throws Exception {
        try {
            int val = Integer.parseInt(this.datos.get(indFil)[nCol].toString());
            return val;
        } catch (NumberFormatException e) {
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Localización: " + e.getLocalizedMessage());
            throw e;
        }
    }
    //</editor-fold>

    //<editor-fold desc="Devuelve String">
    public String getString(int nCol) throws Exception {
        try {
            String val = this.datos.get(indFil)[nCol].toString();
            return val;
        } catch (Exception e) {
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Localización: " + e.getLocalizedMessage());
            throw e;
        }
    }
    //</editor-fold>

    //<editor-fold desc="Devuelve Boolean">
    public boolean getBoolean(int nCol) throws Exception {
        try {
            boolean val = (Boolean) (this.datos.get(indFil)[nCol]);
            return val;
        } catch (Exception e) {
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Localización: " + e.getLocalizedMessage());
            throw e;
        }
    }
    //</editor-fold>

    //<editor-fold desc="Devuelve Time">
    public Time getTime(int nCol) throws Exception {
        try {
            Time val = (Time) (this.datos.get(indFil)[nCol]);
            return val;
        } catch (Exception e) {
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Localización: " + e.getLocalizedMessage());
            throw e;
        }
    }
    //</editor-fold>

    //<editor-fold desc="Devuelve TimeStamp">
    public Timestamp getTimeStamp(int nCol) throws Exception {
        try {
            Timestamp val = (Timestamp) (this.datos.get(indFil)[nCol]);
            return val;
        } catch (Exception e) {
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Localización: " + e.getLocalizedMessage());
            throw e;
        }
    }
    //</editor-fold>

    //<editor-fold desc="Devuelve Date">
    public Date getDate(int nCol) throws Exception {
        try {
            Date val = (Date) (this.datos.get(indFil)[nCol]);
            return val;
        } catch (Exception e) {
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Localización: " + e.getLocalizedMessage());
            throw e;
        }
    }
    //</editor-fold>

    //<editor-fold desc="Devuelve Double">
    public double getDouble(int nCol) throws Exception {
        try {
            double val = (Double) this.datos.get(indFil)[nCol];
            return val;
        } catch (Exception e) {
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Localización: " + e.getLocalizedMessage());
            throw e;
        }
    }
    //</editor-fold>

    //<editor-fold desc="Devuelve Char">
    public char getChar(int nCol) throws Exception {
        try {
            char val = (char) this.datos.get(indFil)[nCol];
            return val;
        } catch (Exception e) {
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Localización: " + e.getLocalizedMessage());
            throw e;
        }
    }
    //</editor-fold>

    //<editor-fold desc="Devuelve BigDecimal">
    public BigDecimal getBigDecimal(int nCol) throws Exception {
        try {
            BigDecimal val = (BigDecimal) this.datos.get(indFil)[nCol];
            return val;
        } catch (Exception e) {
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Localización: " + e.getLocalizedMessage());
            throw e;
        }
    }
    //</editor-fold>

    public short getShort(int nCol) throws Exception {
        try {
            return new Short(this.datos.get(indFil)[nCol].toString());
        } catch (NumberFormatException e) {
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Localización: " + e.getLocalizedMessage());
            throw e;
        }
    }

    public byte[] getBytes(int nCol) throws Exception {
        try {
            return toBytes(this.datos.get(indFil)[nCol]);
        } catch (IOException e) {
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Localización: " + e.getLocalizedMessage());
            throw e;
        }
    }

    public long getLong(int nCol) throws Exception {
        try {
            return (Long) (this.datos.get(indFil)[nCol]);
        } catch (Exception e) {
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Localización: " + e.getLocalizedMessage());
            throw e;
        }
    }

    public Object getObject(int nCol) throws Exception {
        try {
            return this.datos.get(indFil)[nCol];
        } catch (Exception e) {
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Localización: " + e.getLocalizedMessage());
            throw e;
        }

    }
    //</editor-fold>

    //<editor-fold desc="Parámetro de entrada es un String"> 
    public String getString(String nomCol) throws Exception {
        try {
            int col = Find(nomCol);
            return this.datos.get(indFil)[col].toString();
        } catch (Exception e) {
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Localización: " + e.getLocalizedMessage());
            throw e;
        }
    }

    public short getShort(String nomCol) throws Exception {
        try {
            return new Short(this.datos.get(indFil)[Find(nomCol)].toString());
        } catch (Exception e) {
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Localización: " + e.getLocalizedMessage());
            throw e;
        }
    }

    public byte[] getBytes(String nomCol) throws Exception {
        try {
            return toBytes(this.datos.get(indFil)[Find(nomCol)]);
        } catch (Exception e) {
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Localización: " + e.getLocalizedMessage());
            throw e;
        }
    }

    public int getInt(String nomCol) throws Exception {
        try {
            return Integer.parseInt(this.datos.get(indFil)[Find(nomCol)].toString());
        } catch (Exception e) {
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Localización: " + e.getLocalizedMessage());
            throw e;
        }
    }

    public long getLong(String nomCol) throws Exception {
        try {
            return (Long) (this.datos.get(indFil)[Find(nomCol)]);
        } catch (Exception e) {
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Localización: " + e.getLocalizedMessage());
            throw e;
        }
    }

    public double getDouble(String nomCol) throws Exception {
        try {
            return (Double) (this.datos.get(indFil)[Find(nomCol)]);
        } catch (Exception e) {
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Localización: " + e.getLocalizedMessage());
            throw e;
        }
    }

    public char getChar(String nomCol) throws Exception {
        try {
            return (char) (this.datos.get(indFil)[Find(nomCol)]);
        } catch (Exception e) {
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Localizacion: " + e.getLocalizedMessage());
            throw e;
        }

    }

    public Date getDate(String nomCol) throws Exception {
        try {
            return (Date) (this.datos.get(indFil)[Find(nomCol)]);
        } catch (Exception e) {
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Localización: " + e.getLocalizedMessage());
            throw e;
        }
    }

    public java.sql.Time getTime(String nomCol) throws Exception {
        try {
            return (java.sql.Time) (this.datos.get(indFil)[Find(nomCol)]);
        } catch (Exception e) {
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Localización: " + e.getLocalizedMessage());
            throw e;
        }
    }

    public java.sql.Timestamp getTimeStamp(String nomCol) throws Exception {
        try {
            return (java.sql.Timestamp) (this.datos.get(indFil)[Find(nomCol)]);
        } catch (Exception e) {
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Localización: " + e.getLocalizedMessage());
            throw e;
        }
    }

    public boolean getBoolean(String nomCol) throws Exception {
        try {
            return (Boolean) (this.datos.get(indFil)[Find(nomCol)]);
        } catch (Exception e) {
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Localización: " + e.getLocalizedMessage());
            throw e;
        }
    }

    public Object getObject(String nomCol) throws Exception {
        try {
            int col = Find(nomCol);
            return this.datos.get(indFil)[col];
        } catch (Exception e) {
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Localización: " + e.getLocalizedMessage());
            throw e;
        }
    }

    private static byte[] toBytes(Object obj) throws java.io.IOException {
        ObjectOutputStream os = null;
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream(5000);
        os = new ObjectOutputStream(new BufferedOutputStream(byteStream));
        os.flush();
        os.writeObject(obj);
        os.flush();
        byte[] sendBuf = byteStream.toByteArray();
        os.close();
        return sendBuf;

    }
    //</editor-fold>

    //Metodo para encontrar la columna segun el nombre
    private int Find(String nomCol) throws Exception {
        nomCol = nomCol.toLowerCase();
        int index = -1;
        indCol = 0;
        while ((index < 0) && (indCol < getTamCol())) {
            if (cabecera[indCol].toLowerCase().equals(nomCol)) {
                index = indCol;
            }
            indCol += 1;
        }
        if (index < 0) {
            throw new Exception("No existe la columna " + nomCol);
        }
        return index;
    }
}
