package bean.gerente;

import DAO.FacturaDao;
import DAO.FacturaImplements;
import DAO.PaqueteDao;
import DAO.PaqueteImplements;
import DAO.RutaDao;
import DAO.RutaImplements222;
import DAO.SucursalesDAO;
import DAO.SucursalesImplementa;
import Persistencia.HibernateUtil;
import Pojo.Clientes;
import Pojo.Empleados;
import Pojo.Facturas;
import Pojo.Paquetes;
import Pojo.Rutas;
import Pojo.Sucursales;
import Pojo.Usuarios;
import Pojo.Viajes;
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
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Wolverine20
 */
@ManagedBean
@ViewScoped
public class FacturaBean implements Serializable {

    Facturas factura;
    List<Facturas> facturas;
    Integer idCliente;
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

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

  

    public void setIdPaquetes(Integer idPaquete) {
        this.idPaquete = idPaquete;
    }
    
    
    
    FacturaDao linkDAO;
    
    @PostConstruct
    public void init() {
              
        factura = new Facturas();
        linkDAO= new FacturaImplements();
        linkDaoP = new PaqueteImplements();
       

    }   
    
    public void insertar(){
        /*pasar fecha ingresada a date*/
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
 
		Date date = formatter.parse(fecha);
                this.factura.setFecha(date);
		System.out.println(date);
		System.out.println(formatter.format(date));
 
	} catch (ParseException e) {
		e.printStackTrace();
	}
        
        System.out.println("estoy insertando factura");
        /* Busca el empleado actual y lo guarda en factura*/
        HttpSession miSesion=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        final Usuarios usuario= (Usuarios)miSesion.getAttribute("usuario");
        this.factura.setEmpleados((Empleados)usuario.getEmpleados());
        asignarCliente();
      
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
    
    public void asignarCliente(){
    Clientes cliente1;
    Session session = null;
    try{
        session=HibernateUtil.getSessionFactory().openSession();
        Query query=session.createQuery("from Clientes c WHERE c.idCliente = :idCliente");
        query.setParameter("idCliente", idCliente);
        cliente1 = (Clientes)query.uniqueResult();
       factura.setClientes(cliente1);
    }catch(HibernateException e){
    System.out.println(e.getMessage());
    session.getTransaction().rollback();
    }
    finally {
        if(session != null){
        session.close();}
    }}

 
    public void asignarPaquete(){
   facturas= linkDAO.mostrarFacturas();
    Paquetes paq= linkDaoP.getPaquete(idPaquete);
    paq.setFacturas(facturas.get((facturas.size())-1));
    linkDaoP.modificarPaquete(paq);
        System.out.println("asigne factura a paquete");
    }
   

    public void asignarEmpleado(){
       HttpSession miSesion=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        final Usuarios usuario= (Usuarios)miSesion.getAttribute("usuario");
        this.factura.setEmpleados((Empleados)usuario.getEmpleados());
       
    
    }
    
    public void buscarpaquete(){
        System.out.println(idPaquete);
       final Paquetes paq= linkDaoP.getPaquete(idPaquete);
        System.out.println("aca:");
        System.out.println(paq.getDestinatarioNombre());
         List<Paquetes> lista = new ArrayList<Paquetes>();
       lista.add(paq);
        setPaquetes(lista);
    }
}
    

    

