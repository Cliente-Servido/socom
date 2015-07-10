package bean.gerente;

import DAO.FacturaDao;
import DAO.FacturaImplements;
import DAO.PaqueteDao;
import DAO.PaqueteImplements;
import DAO.RutaDao;
import DAO.SucursalesDAO;
import Pojo.Empleados;
import Pojo.Facturas;
import Pojo.Paquetes;
import Pojo.Usuarios;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Wolverine20
 */
@ManagedBean
@ViewScoped
public class FacturaBean implements Serializable {
    Paquetes paquete;

    public Paquetes getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquetes paquete) {
        this.paquete = paquete;
    }
    Facturas factura;
    List<Facturas> facturas;
    List<Paquetes> paquetes;
    int idPaquete;
    PaqueteDao linkDaoP;
    String fecha;
    RutaDao linkDaoR;
    SucursalesDAO linkDaoS;
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    

    public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    public List<Paquetes> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(List<Paquetes> paquetes) {
        this.paquetes = paquetes;
    }

  

    public void setIdPaquetes(Integer idPaquete) {
        this.idPaquete = idPaquete;
    }
    
    
    
    FacturaDao linkDAO;
    
    @PostConstruct
    public void init() {
        paquete=new Paquetes();
        factura = new Facturas();
        linkDAO= new FacturaImplements();
        linkDaoP = new PaqueteImplements();
       

    }   
    
    public void insertar(){
        /*pasar fecha ingresada a date*/
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
 
		Date date = formatter.parse(fecha);
                factura.setFecha(date);
		System.out.println(date);
		System.out.println(formatter.format(date));
 
	} catch (ParseException e) {
		e.printStackTrace();
	}
        
        HttpSession miSesion=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        final Usuarios usuario= (Usuarios)miSesion.getAttribute("usuario");
        factura.setEmpleados((Empleados)usuario.getEmpleados());
     
        buscarpaquete();
        factura.setClientes(paquete.getClientes());
        factura.setMonto(paquete.getCostoTotal());
        linkDAO.insertarFactura(factura);
         asignarPaquete();
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
    
    
    
 
    public void asignarPaquete(){
   facturas= linkDAO.mostrarFacturas();
    Paquetes paquete= linkDaoP.getPaquete(idPaquete);
    paquete.setFacturas(facturas.get((facturas.size())-1));
   linkDaoP.modificarPaquete(paquete);
        System.out.println("asigne factura a paquete");
    }
   

    public void asignarEmpleado(){
       HttpSession miSesion=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        final Usuarios usuario= (Usuarios)miSesion.getAttribute("usuario");
        this.factura.setEmpleados((Empleados)usuario.getEmpleados());
       
    
    }
    
    public void buscarpaquete(){
        System.out.println(idPaquete);
       paquete= linkDaoP.getPaquete(idPaquete);
    
       List<Paquetes> lista = new ArrayList<Paquetes>();
       lista.add(paquete);
        setPaquetes(lista);
    }
    
   
}
    

    

