package bean.gerente;

import DAO.PaqueteDao;
import DAO.PaqueteImplements;
import Pojo.Estados;
import Pojo.Paquetes;

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
public class PaqueteBean implements Serializable {

   Paquetes paquete;
    List<Paquetes> paquetes;
    List<Paquetes> paquetesAct;
    Estados estado;

    public List<Paquetes> getPaquetesAct() {
        return paquetesAct;
    }

    public void setPaquetesAct(List<Paquetes> paquetesAct) {
        this.paquetesAct = paquetesAct;
    }

    public PaqueteDao getLinkDAO() {
        return linkDAO;
    }

    public void setLinkDAO(PaqueteDao linkDAO) {
        this.linkDAO = linkDAO;
    }

    PaqueteDao linkDAO;
    
    @PostConstruct
    public void init() {
        paquete = new Paquetes();
        linkDAO= new PaqueteImplements();
        System.out.println("Llego hasta aca 1");
    }
    
    public void insertar(){
        
        linkDAO.insertarPaquete(paquete);
        paquete= new Paquetes();
    }
    public void modificar(){
        linkDAO.modificarPaquete(paquete);
        paquete= new Paquetes();
    }
    public void eliminar(){
        linkDAO.eliminarPaquete(paquete);
        paquete= new Paquetes();
    }
    public Paquetes getPaquete() {
        return paquete;
    }
    

    public void setPaquete(Paquetes paquete) {
        this.paquete = paquete;
    }

    public List<Paquetes> getPaquetes() {
        System.out.println("Llego hasta aca 2");
        paquetes=linkDAO.mostrarPaquete();
        System.out.println("Paquetes: " + paquetes.size());
        return paquetes;
    }
    

    public void setPaquetes(List<Paquetes> paquetes) {
        this.paquetes = paquetes;
    }
    
    public void buscar(){
        if (linkDAO.getPaquete(getPaquete().getIdPaquete()) != null ) {
        paquete=linkDAO.getPaquete(getPaquete().getIdPaquete());
        List<Paquetes> lista = new ArrayList<Paquetes>();
        lista.add(paquete);
        setPaquetesAct(lista);}
    }
    
      public List<Paquetes> listaActualizada (){
      if (getPaquetesAct()==null){
      return getPaquetes();
      }else{
          return getPaquetesAct();
      }
      }
    
}
