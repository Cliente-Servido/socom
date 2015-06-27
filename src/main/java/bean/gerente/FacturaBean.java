package bean.gerente;

import DAO.FacturaDao;
import DAO.FacturaImplements;
import Pojo.Facturas;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Wolverine20
 */
@ManagedBean
@ViewScoped
public class FacturaBean implements Serializable {

   Facturas factura;
    List<Facturas> facturas;

    FacturaDao linkDAO;
    
    @PostConstruct
    public void init() {
        factura = new Facturas();
        linkDAO= new FacturaImplements();
        
    }
    
    public void insertar(){
        
        linkDAO.insertarFactura(factura);
        factura= new Facturas();
    }
    public void modificar(){
        linkDAO.modificarFactura(factura);
        factura= new Facturas();
    }
    public void eliminar(){
        linkDAO.eliminarFactura(factura);
        factura= new Facturas();
    }
    public Facturas getFactura() {
        return factura;
    }

    public void setFactura(Facturas factura) {
        this.factura = factura;
    }

    public List<Facturas> getFacturas() {
        facturas=linkDAO.mostrarFacturas();
        
        return facturas;
    }
    

    public void setFacturas(List<Facturas> facturas) {
        this.facturas = facturas;
    }
    
    
}
