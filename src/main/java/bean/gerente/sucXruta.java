
package bean.gerente;

import DAO.SucursalesPorRutaImplements;
import DAO.SucursalesPorRutaDao;
import Persistencia.HibernateUtil;
import Pojo.Rutas;
import Pojo.Sucursales;
import Pojo.Sucursalesxruta;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Juan
 */
@ManagedBean
@ViewScoped
public class sucXruta implements Serializable{

    /**
     * Creates a new instance of SuycursalesxrutaBean
     */public Integer orig;

    public Integer getOrig() {
        return orig;
    }

    public void setOrig(Integer orig) {
        this.orig = orig;
    }
     private Integer idRuta;
     public Integer des;

    public Integer getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Integer idRuta) {
        this.idRuta = idRuta;
    }
    


    public Integer getDes() {
        return des;
    }

    public void setDes(Integer des) {
        this.des = des;
    }
    
    Sucursalesxruta sxr;
    List<Sucursalesxruta> sxrs; 
    
    SucursalesPorRutaDao linkDAO= new SucursalesPorRutaImplements();
    
    @PostConstruct
    public void init() {    
    sxr = new Sucursalesxruta();
    linkDAO= new SucursalesPorRutaImplements();   
    }    
    public void insertar(){
        asignarRuta();
        asignarOrigen();
        asignarDestino();
        
        linkDAO.insertarSucXRuta(sxr);
        sxr= new Sucursalesxruta();
        FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "La sucursal del recorrido fue añadido con exito" , "No se puedo añadir la sucursal del recorrido"));
    }
    
    public void modificar(){
        asignarRuta();
        asignarOrigen();
        asignarDestino();
        linkDAO.modificarSucXRuta(sxr);
        sxr= new Sucursalesxruta();
    }
    public void eliminar(){
        linkDAO.eliminarSucXRuta(sxr);
        sxr= new Sucursalesxruta();
    }
    public Sucursalesxruta getSucXRuta() {
        return sxr;
    }

    public void setSucXRuta(Sucursalesxruta sxr) {
        this.sxr = sxr;
}

    public List<Sucursalesxruta> getSucursalesxruta() {
        System.out.println("Llego hasta acÃ  2");
        sxrs=linkDAO.mostrarSucXRutas();
        
        System.out.println("Empleados: " + sxrs.size());
        return sxrs;
    }
    

    public void setSucursalesxruta(List<Sucursalesxruta> sxrs) {
        this.sxrs = sxrs;
    }
      public void asignarOrigen(){
        Sucursales origen=null;
        Session session=null;
        try{
        session=HibernateUtil.getSessionFactory().openSession();
        Query query=session.createQuery("from Sucursales r WHERE r.idSucursal = :idSucursal");
        query.setParameter("idSucursal", orig);
        origen = (Sucursales)query.uniqueResult();
       sxr.setSucursalesByOrigen(origen);
    }catch(HibernateException e){
    System.out.println(e.getMessage());
    session.getTransaction().rollback();
    }
    finally {
        if(session != null){
        session.close();}
    }
        
        
        
    }
     public void asignarDestino(){
         Sucursales destino=null;
        Session session=null;
        try{
        session=HibernateUtil.getSessionFactory().openSession();
        Query query=session.createQuery("from Sucursales r WHERE r.idSucursal = :idSucursal");
        query.setParameter("idSucursal", des);
       destino = (Sucursales)query.uniqueResult();
       sxr.setSucursalesByDestino(destino);
    }catch(HibernateException e){
    System.out.println(e.getMessage());
    session.getTransaction().rollback();
    }
    finally {
        if(session != null){
        session.close();}
    }}
    public void asignarRuta(){
        System.out.println("Estoy aca");
        System.out.println(idRuta);
        Rutas ruta1=null;
        Session session=null;
        try{
        session=HibernateUtil.getSessionFactory().openSession();
        Query query=session.createQuery("from Rutas r WHERE r.idRuta = :idRuta");
        query.setParameter("idRuta", idRuta);
        ruta1 = (Rutas)query.uniqueResult();
       sxr.setRutas(ruta1);
    }catch(HibernateException e){
    System.out.println(e.getMessage());
    session.getTransaction().rollback();
    }
    finally {
        if(session != null){
        session.close();}
    }}

}



