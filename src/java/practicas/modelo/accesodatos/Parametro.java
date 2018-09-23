package practicas.modelo.accesodatos;

public class Parametro {

    //<editor-fold desc="Atributos">
    private Integer posicion;
    private Object valor; //el Object almacena datos de cualquier tipo de dato
    private Integer tipo;

    private Object[] valorArray;
    //</editor-fold>

    //<editor-fold desc="Constructores">
    public Parametro(Integer posicion, Object valor, Integer tipo) {
        this.posicion = posicion;
        this.valor = valor;
        this.tipo = tipo;
    }

    public Parametro(Integer posicion, Integer tipo, Object[] valorArray) {
        this.posicion = posicion;
        this.tipo = tipo;
        this.valorArray = valorArray;
    }

    public Parametro(Integer posicion, Object[] valorArray) {
        this.posicion = posicion;
        this.valorArray = valorArray;
    }

    public Parametro(Integer posicion, Object valor) {
        this.posicion = posicion;
        this.valor = valor;
    }

    public Integer getPosicion() {
        return posicion;
    }

    public void setPosicion(Integer posicion) {
        this.posicion = posicion;
    }
//</editor-fold>

    //<editor-fold desc="Getters and Setters">
    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public Object[] getValorArray() {
        return valorArray;
    }

    public void setValorArray(Object[] valorArray) {
        this.valorArray = valorArray;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
    //</editor-fold>

}
