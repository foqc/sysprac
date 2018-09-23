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

    private int idPlanificacion;
    private Date fechaInicio;
    private Date fechaFin;
    private int totalHoras;
    private cPractica objPractica;

    public cPlanificacion() {
    }

    public int getIdPlanificacion() {
        return idPlanificacion;
    }

    public void setIdPlanificacion(int idPlanificacion) {
        this.idPlanificacion = idPlanificacion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getTotalHoras() {
        return totalHoras;
    }

    public void setTotalHoras(int totalHoras) {
        this.totalHoras = totalHoras;
    }

    public cPractica getObjPractica() {
        return objPractica;
    }

    public void setObjPractica(cPractica objPractica) {
        this.objPractica = objPractica;
    }

}
