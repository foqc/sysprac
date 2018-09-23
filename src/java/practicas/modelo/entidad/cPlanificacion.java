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
public class cPlanificacion {
   private int idplanificacion;
   private Date fechainicio;
   private Date fechafin;
   private int totalhoras;

    public cPlanificacion(int idplanificacion, Date fechainicio, Date fechafin, int totalhoras) {
        this.idplanificacion = idplanificacion;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.totalhoras = totalhoras;
    }

    public int getIdplanificacion() {
        return idplanificacion;
    }

    public void setIdplanificacion(int idplanificacion) {
        this.idplanificacion = idplanificacion;
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
   
    
    
}
