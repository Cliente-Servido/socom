package bean.gerente;

import DAO.CamionDao;
import DAO.CamionImplements;
import Persistencia.HibernateUtil;
import Pojo.Camiones;
import Pojo.Rutas;
import Pojo.Viajes;
import gps.ProveedorCoordenadas_Service;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.xml.ws.WebServiceRef;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;


/**
 *
 * @author Wolverine20
 */
@ManagedBean
@ViewScoped
public class CamionBean implements Serializable {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/EmpresaGps/ProveedorCoordenadas.wsdl")
    private ProveedorCoordenadas_Service service;
   
   float latitudCamion;

    public float getLatitudCamion() {
        return latitudCamion;
    }

    public void setLatitudCamion(float latitudCamion) {
        this.latitudCamion = latitudCamion;
    }

    public float getLongitudCamion() {
        return longitudCamion;
    }

    public void setLongitudCamion(float longitudCamion) {
        this.longitudCamion = longitudCamion;
    }
   float longitudCamion;
    int idCamion; 

    public int getIdCamion() {
        return idCamion;
    }

    public void setIdCamion(int idCamion) {
        this.idCamion = idCamion;
    }
    Integer idRuta;

    public Integer getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Integer idRuta) {
        this.idRuta = idRuta;
    }
    Camiones camion;
    List<Camiones> camiones;
    List<Viajes> viajes= null;
    List<Camiones> camionesAct;
       
    public List<Camiones> getCamionesAct() {
        return camionesAct;
    }

    public void setCamionesAct(List<Camiones> camionesAct) {
        this.camionesAct = camionesAct;
    }

    public List<Viajes> getViajes() {
        return viajes;
    }

    public void setViajes(List<Viajes> viajes) {
        this.viajes = viajes;
    }

   

    public void setLinkDAO(CamionDao linkDAO) {
        this.linkDAO = linkDAO;
    }
    CamionDao linkDAO;
    
    @PostConstruct
    public void init() {
        camion = new Camiones();
        linkDAO= new CamionImplements();
    }
    
    public void insertar(){
        asignarRuta();
        linkDAO.insertarCamion(camion);
        camion= new Camiones();
        FacesContext.getCurrentInstance().addMessage(
            null,
            new FacesMessage(FacesMessage.SEVERITY_INFO,
            "El camion fue añadido con exito" , "No se puedo añadir camion"));
    }
    public void modificar(){
        asignarRuta();
        linkDAO.modificarCamion(camion);
        camion= new Camiones();
    }
    public void eliminar(){
        linkDAO.eliminarCamion(camion);
        camion= new Camiones();
    }
    public Camiones getCamion() {
        return camion;
    }
    

    public void setCamion(Camiones camion) {
        this.camion = camion;
    }

    public List<Camiones> getCamiones() {
        camiones=linkDAO.mostrarCamiones();
        return camiones;
    }
    

    public void setCamiones(List<Camiones> camiones) {
        this.camiones = camiones;
    }
    
    public void buscar(){
        System.out.println("dominio: ");
        System.out.println(linkDAO.getCamion(getCamion().getDominio()));
        List<Viajes> lista = new ArrayList<Viajes>();
        if (linkDAO.getCamion(getCamion().getDominio()) != null ) {
        camion=linkDAO.getCamion(getCamion().getDominio());
        Integer id = camion.getIdCamion();

        Session session = null;
        try{
        session=HibernateUtil.getSessionFactory().openSession();
        Query query=session.createQuery("from Viajes v WHERE v.camiones= :id");
        query.setParameter("id",id );
        lista=(List<Viajes>)query.list();
        }catch(HibernateException e){
    System.out.println(e.getMessage());
    session.getTransaction().rollback();
    }
    finally {
        if(session != null){
        session.close();}
        }}
        this.viajes = lista;
        
    }
        
        
     
     public void busqueda(){
        if (linkDAO.getCamion(getCamion().getDominio()) == null) {

        setCamionesAct(null);
        /*devuelve el mensaje que el usuario no se encontro */
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "No se encontro patente",
                            "Por favor ingrese una nueva patente"));
         }
        if (linkDAO.getCamion(getCamion().getDominio())!= null ) {
        camion=linkDAO.getCamion(getCamion().getDominio());
        List<Camiones> lista = new ArrayList<Camiones>();
        lista.add(camion);
        setCamionesAct(lista);}
    }
    
      public List<Camiones> listaActualizada (){
      if (getCamionesAct()==null){
      return getCamiones();
      }else{
          return getCamionesAct();
      }
      }  
      
    public void asignarRuta(){
        Rutas ruta1=null;
        Session session=null;
        try{
        session=HibernateUtil.getSessionFactory().openSession();
        Query query=session.createQuery("from Rutas r WHERE r.idRuta = :idRuta");
        query.setParameter("idRuta", idRuta);
        
        ruta1 = (Rutas)query.uniqueResult();
       camion.setRutas(ruta1);
    }catch(HibernateException e){
    System.out.println(e.getMessage());
    session.getTransaction().rollback();
    }
    finally {
        if(session != null){
        session.close();}
    }}
   
    public void consultarUbicacion(){
           busqueda();
           
           
           try { // Call Web Service Operation
               gps.ProveedorCoordenadas port = service.getProveedorCoordenadasPort();
               // TODO initialize WS operation arguments here
               java.lang.String dominio = "";
               // TODO process result here
               java.util.List<java.lang.Float> result = port.consultarUbicacion(camion.getDominio());
               latitudCamion=result.get(0);
               longitudCamion=result.get(1);
               System.out.println(result.size());
           } catch (Exception ex) {
               // TODO handle custom exceptions here
           }
           }
    
    public void BusquedaId(){
        
        if (linkDAO.getCamionId(idCamion) == null) {

        setCamionesAct(null);
        /*devuelve el mensaje que el usuario no se encontro */
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "No se encontro Camion",
                            "Por favor ingrese un nuevo Id"));
         }
        if (linkDAO.getCamionId(idCamion) != null ) {
        camion=linkDAO.getCamionId(idCamion);
        List<Camiones> lista = new ArrayList<Camiones>();
        lista.add(camion);
        setCamionesAct(lista);}
    }
}
    
    
    
    
    
    
