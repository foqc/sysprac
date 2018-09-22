package practicas.modelo.accesodatos;

import java.util.ArrayList;

/**
 *
 * @author Tupac Amaruc Tisalema Poaquiza
 */
public class Query {

    private String sql;
    private ArrayList<Parametro> lstParam;

    public Query() {
    }

    public Query(String sql, ArrayList<Parametro> lstParam) {
        this.sql = sql;
        this.lstParam = lstParam;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public ArrayList<Parametro> getLstParam() {
        return lstParam;
    }

    public void setLstParam(ArrayList<Parametro> lstParam) {
        this.lstParam = lstParam;
    }

}
