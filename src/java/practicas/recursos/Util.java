/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas.recursos;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.jboss.weld.context.RequestContext;

/**
 *
 * @author Usuario
 */
@ManagedBean
@SessionScoped
public class Util {

    /**
     * Creates a new instance of Util
     */
    public Util() {
    }

    public static void infoMessage(String msg, String showDetail) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, showDetail);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
    }

    public static void warnMessage(String msg, String showDetail) {
        if (msg != null) {
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, msg, showDetail);
            FacesContext.getCurrentInstance().addMessage(msg, facesMsg);
        }
    }

    public static void errorMessage(String msg, String showDetail) {
        FacesMessage facesMeg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, showDetail);
        FacesContext.getCurrentInstance().addMessage(msg, facesMeg);

    }

    public static void fatalMessage(String msg, String showDetail) {
        FacesMessage facesMeg = new FacesMessage(FacesMessage.SEVERITY_FATAL, msg, showDetail);
        FacesContext.getCurrentInstance().addMessage(msg, facesMeg);

    }
}
