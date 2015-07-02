
package bean.gerente;

import DAO.ServicioDao;
import DAO.ServicioImplements;
import Pojo.Servicios;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;





/**
 *
 * @author Wolverine20
 */


@ManagedBean
@RequestScoped
public class ServicioBean implements Serializable {

  
    
    Servicios servicio;
    List<Servicios> servicios;
    List<Servicios> serviciosAct=null;

    public List<Servicios> getServiciosAct() {
        return serviciosAct;
    }

    public void setServiciosAct(List<Servicios> serviciosAct) {
        this.serviciosAct = serviciosAct;
    }
    ServicioDao linkDAO;
    
     @PostConstruct
    public void init() {
        servicio = new Servicios();
        linkDAO= new ServicioImplements();
        System.out.println("Llego hasta aca 1");
    }
    
    public void insertar(){
    
        linkDAO.insertarServicio(servicio);
        servicio= new Servicios();
    }
    public void modificar(){
    
        linkDAO.modificarServicio(servicio);
        servicio= new Servicios();
    }
    public void eliminar(){
    
        linkDAO.eliminarServicio(servicio);
        servicio= new Servicios();
    }
    public Servicios getServicio() {
        return servicio;
    }

    public void setServicio(Servicios servicio) {
        this.servicio = servicio;
    }

    public List<Servicios> getServicios() {
        
        servicios=linkDAO.mostrarServicio();
        System.out.println("Servicios: " + servicios.size());
        return servicios;
    }
     

    public void setServicios(List<Servicios> servicios) {
        this.servicios = servicios;
    }
    
    public void buscar(){
        if (linkDAO.getServicio(getServicio().getIdServicio()) == null) {
        System.out.println("nulo");
    }
        
        if (linkDAO.getServicio(getServicio().getIdServicio()) != null ) {
           servicio=linkDAO.getServicio(getServicio().getIdServicio());
        List<Servicios> lista = new ArrayList<Servicios>();
        lista.add(servicio);
        setServiciosAct(lista);}
    }
    
      public List<Servicios> listaActualizada (){
      if (getServiciosAct()==null){
      return getServicios();
      }else{
          return getServiciosAct();
      }
      }
      
      }


  
    

