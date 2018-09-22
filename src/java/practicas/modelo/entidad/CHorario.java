/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas.modelo.entidad;

import java.sql.Time;

/**
 *
 * @author Jhonathan
 */
public class CHorario {
    private int idhorario;
    private String dia;
    private Time horainicio;
    private Time horafin;
    private int idplanificacion;

    public CHorario(int idhorario, String dia, Time horainicio, Time horafin, int idplanificacion) {
        this.idhorario = idhorario;
        this.dia = dia;
        this.horainicio = horainicio;
        this.horafin = horafin;
        this.idplanificacion = idplanificacion;
    }

    public int getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(int idhorario) {
        this.idhorario = idhorario;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Time getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(Time horainicio) {
        this.horainicio = horainicio;
    }

    public Time getHorafin() {
        return horafin;
    }

    public void setHorafin(Time horafin) {
        this.horafin = horafin;
    }

    public int getIdplanificacion() {
        return idplanificacion;
    }

    public void setIdplanificacion(int idplanificacion) {
        this.idplanificacion = idplanificacion;
    }
    
    
}
