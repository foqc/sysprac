/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas.modelo.entidad;

import java.sql.Date;

/**
 *
 * @author Jhonathan
 */
public class CActividad {
    private int idactividad;
    private String numero;
    private String descripcion;
    private Date fechainicio;
    private Date fechafin;
    private int totalhoras;
    private int idplanificacion;

    public CActividad(int idactividad, String numero, String descripcion, Date fechainicio, Date fechafin, int totalhoras, int idplanificacion) {
        this.idactividad = idactividad;
        this.numero = numero;
        this.descripcion = descripcion;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.totalhoras = totalhoras;
        this.idplanificacion = idplanificacion;
    }

    public int getIdactividad() {
        return idactividad;
    }

    public void setIdactividad(int idactividad) {
        this.idactividad = idactividad;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public int getTotalhoras() {
        return totalhoras;
    }

    public void setTotalhoras(int totalhoras) {
        this.totalhoras = totalhoras;
    }

    public int getIdplanificacion() {
        return idplanificacion;
    }

    public void setIdplanificacion(int idplanificacion) {
        this.idplanificacion = idplanificacion;
    }
    
    
    
    
}
