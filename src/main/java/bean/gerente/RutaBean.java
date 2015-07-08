import DAO.RutaDao;
import DAO.RutaImplements222;
import Persistencia.HibernateUtil;
import Pojo.Rutas;
import Pojo.Sucursales;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Juan
 */
@ManagedBean
@ViewScoped
public class RutaBean implements Serializable {

    Rutas ruta;
    List<Rutas> rutas;
    List<Rutas> rutasAct=null;
    int ori;
    int des;
    
    public int getOri() {
        return ori;
    }

    public void setOri(int ori) {
        this.ori = ori;
    }

    public int getDes() {
        return des;
    }

    public void setDes(int des) {
        this.des = des;
    }

 
    public List<Rutas> getRutasAct() {
        return rutasAct;
    }

    public void setRutasAct(List<Rutas> rutasAct) {
        this.rutasAct = rutasAct;
    }

    
    
    public void asignarOrigen(){
        Sucursales origen=null;
        Session session=null;
        try{
        session=HibernateUtil.getSessionFactory().openSession();
        Query query=session.createQuery("from Sucursales r WHERE r.idSucursal = :idSucursal");
        query.setParameter("idSucursal", ori);
        origen = (Sucursales)query.uniqueResult();
       ruta.setSucursalesByOrigen(origen);
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
       ruta.setSucursalesByDestino(destino);
    }catch(HibernateException e){
    System.out.println(e.getMessage());
    session.getTransaction().rollback();
    }
    finally {
        if(session != null){
        session.close();}
    }
        
        
        
    }

   
    public Rutas getRuta() {
        return ruta;
    }

    public void setRuta(Rutas ruta) {
        this.ruta = ruta;
    }

    public List<Rutas> getRutas() {
        System.out.println("Llego hasta acaaa  2");
        rutas=linkDAO.mostrarRutas();
        return rutas;
        }

    public void setRutas(List<Rutas> rutas) {
        
        this.rutas = rutas;
    }

      
    RutaDao linkDAO;

    @PostConstruct
    public void init() {
        ruta = new Rutas();
        linkDAO= new RutaImplements222();
                System.out.println("Llego hasta acà 1");
   }
    
    
    public void insertar(){
        asignarOrigen();
        asignarDestino();
        linkDAO.insertarRuta(ruta);
        ruta= new Rutas();
        FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "La ruta fue añadida con exito" , "No se puedo añadir ruta"));
    }
    
    public void modificar(){
        System.out.println("hola estoy aca pablo");
        asignarOrigen();
        asignarDestino();
        linkDAO.modificarRuta(ruta);
        ruta= new Rutas();
    }
    public void eliminar(){
        linkDAO.eliminarRuta(ruta);
        ruta= new Rutas();
    }
    
    public void buscar(){

        if (linkDAO.getRuta(getRuta().getIdRuta()) == null) {
        setRutasAct(null);
        /*devuelve el mensaje que el usuario no se encontro */
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "No se encontro ruta",
                            "Por favor ingrese nueva ruta"));
    }
        
        if (linkDAO.getRuta(getRuta().getIdRuta()) != null ) {
           ruta=linkDAO.getRuta(getRuta().getIdRuta());
        List<Rutas> lista = new ArrayList<Rutas>();
        lista.add(ruta);
        setRutasAct(lista);}
    }
    
      public List<Rutas> listaActualizada (){
      if (getRutasAct()==null){
      return getRutas();
      }else{
          return getRutasAct();
      }
      }
}