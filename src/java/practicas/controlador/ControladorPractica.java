/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas.controlador;

import javax.inject.Named;
import javax.enterprise.context.ConversationScoped;
import java.io.Serializable;
import practicas.modelo.entidad.cPractica;

/**
 *
 * @author Programador
 */
@Named(value = "controladorPractica")
@ConversationScoped
public class ControladorPractica implements Serializable {

    private cPractica objPractica;

    /**
     * Creates a new instance of ControladorPractica
     */
    public ControladorPractica() {
    }

    public void insertar() {
        try {
            
        } catch (Exception e) {
        }
    }
}
