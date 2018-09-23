/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.List;
import practicas.modelo.dao.mTipoPractica;
import practicas.modelo.entidad.cTipoPractica;

/**
 *
 * @author Programador
 */
public class PruebaServicios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
       
        try {
            List<cTipoPractica> lst = mTipoPractica.obetenerTodos();
            for (cTipoPractica obj : lst) {
                System.out.println("Nombre: " + obj.getNombre());
            }
        } catch (Exception e) {
            throw e;
        }
      
    }

}
