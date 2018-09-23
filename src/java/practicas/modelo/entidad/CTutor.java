/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas.modelo.entidad;

/**
 *
 * @author Jhonathan
 */
public class CTutor {
    private int idtutor;
    private int idpractica;
    private boolean  estado;

    public CTutor(int idtutor, int idpractica, boolean estado) {
        this.idtutor = idtutor;
        this.idpractica = idpractica;
        this.estado = estado;
    }

    public int getIdtutor() {
        return idtutor;
    }

    public void setIdtutor(int idtutor) {
        this.idtutor = idtutor;
    }

    public int getIdpractica() {
        return idpractica;
    }

    public void setIdpractica(int idpractica) {
        this.idpractica = idpractica;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
            
    
}
