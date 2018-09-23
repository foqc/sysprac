package practicas.recursos;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import practicas.modelo.dao.mTipoPractica;
import practicas.modelo.entidad.cTipoPractica;

/**
 *
 * @author Tupac Amaruc Tisalema Poaquiza
 */
@ManagedBean
@RequestScoped
public class Items {

    private List<SelectItem> selectOneItems;

    /**
     * Creates a new instance of Items
     */
    public Items() {
    }

    //<editor-fold desc="Cargar TipoPractica">
    public List<SelectItem> getSelectOneItems() {
        try {
            this.selectOneItems = new ArrayList<>();
            List<cTipoPractica> lstTipoCuentaContable = mTipoPractica.obetenerTodosActivos();
            lstTipoCuentaContable.stream().map((obj) -> new SelectItem(obj.getIdTipoPractica(), obj.getNombre())).forEachOrdered((selectItem) -> {
                this.selectOneItems.add(selectItem);
            });
        } catch (Exception e) {
            System.err.println("Mensaje: " + e.getMessage());
        }
        return selectOneItems;
    }
    //</editor-fold>

}
