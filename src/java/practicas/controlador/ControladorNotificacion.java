/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas.controlador;

import javax.inject.Named;
import javax.enterprise.context.ConversationScoped;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Programador
 */
@ManagedBean
@ViewScoped
public class ControladorNotificacion implements Serializable {

    /**
     * Creates a new instance of ControladorNotificacion
     */
    public ControladorNotificacion() {
    }

}
