package bean.gerente;

import DAO.FacturaDao;
import DAO.FacturaImplements;
import Persistencia.HibernateUtil;
import Pojo.Clientes;
import Pojo.Empleados;
import Pojo.Facturas;
import Pojo.Paquetes;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
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

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    Integer idPaquete;

    public Integer getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquetes(Integer idPaquete) {
        this.idPaquete = idPaquete;
    }
    
    Integer idEmpleado;

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    
    FacturaDao linkDAO;
    
    @PostConstruct
    public void init() {
        factura = new Facturas();
        linkDAO= new FacturaImplements();
        
    }
    
    public void insertar(){
        asignarCliente();
        asignarEmpleado();
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
  /**
 *
 * 
 
    public void asignarPaquete(){
    Paquetes paquete1;
    Session session = null;
    try{
        session=HibernateUtil.getSessionFactory().openSession();
        Query query=session.createQuery("from Paquetes p WHERE p.idPaquete = :idPaquete");
        query.setParameter("idPaquete", idPaquete);
        paquete1 = (Paquetes)query.uniqueResult();
       factura.setPaqueteses(paquete1);
    }catch(HibernateException e){
    System.out.println(e.getMessage());
    session.getTransaction().rollback();
    }
    finally {
        if(session != null){
        session.close();}
    }}
*/    
    public void asignarEmpleado(){
    Empleados empleado1;
    Session session = null;
    try{
        session=HibernateUtil.getSessionFactory().openSession();
        Query query=session.createQuery("from Empleados e WHERE c.idEmpleado = :idEmpleado");
        query.setParameter("idEmpleado", idEmpleado);
        empleado1 = (Empleados)query.uniqueResult();
       factura.setEmpleados(empleado1);
    }catch(HibernateException e){
    System.out.println(e.getMessage());
    session.getTransaction().rollback();
    }
    finally {
        if(session != null){
        session.close();}
    }}
}
    

