/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas.controlador;

import javax.inject.Named;
import javax.enterprise.context.ConversationScoped;
import java.io.Serializable;

/**
 *
 * @author Programador
 */
@Named(value = "controladorUsuario")
@ConversationScoped
public class ControladorUsuario implements Serializable {

    /**
     * Creates a new instance of controladorUsuario
     */
    public ControladorUsuario() {
    }

}
