/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.gerente;

import DAO.CamionDao;
import DAO.CamionImplements;
import DAO.PaqueteDao;
import DAO.PaqueteImplements;
import DAO.SucursalesPorRutaDao;
import DAO.SucursalesPorRutaImplements;
import DAO.ViajesDao;
import DAO.ViajesImplements;
import Persistencia.HibernateUtil;
import Pojo.Camiones;
import Pojo.Paquetes;
import Pojo.Rutas;
import Pojo.Sucursalesxruta;
import Pojo.Viajes;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
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
public class ViajesBean implements Serializable {
    int idRuta;
    SucursalesPorRutaDao linkDaoSXR;
    CamionDao linkDaoC;
    ViajesDao linkDaoV;
    int idCamion;
    List<Viajes> listaViajes;
    Viajes viaje;
    String fechaLlegada;
    int idViaje;
    int idPaquete;
    PaqueteDao linkDaoP;

    public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    public int getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }

    public String getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    String fechaSalida;
    public Viajes getViaje() {
        return viaje;
    }

    public void setViaje(Viajes viaje) {
        this.viaje = viaje;
    }
    public List<Viajes> getListaViajes() {
        return listaViajes;
    }

    public void setListaViajes(List<Viajes> listaViajes) {
        this.listaViajes = listaViajes;
    }

    public int getIdCamion() {
        return idCamion;
    }

    public void setIdCamion(int idCamion) {
        this.idCamion = idCamion;
    }
  
    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }
    
    CamionDao linkDAO;
    List<Camiones> camionesAct;

    public List<Camiones> getCamionesAct() {
        return camionesAct;
    }

    public void setCamionesAct(List<Camiones> camionesAct) {
        this.camionesAct = camionesAct;
    }
    String dominio;

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }
    @PostConstruct
    public void init() {
        linkDaoV=new ViajesImplements();
        linkDAO= new CamionImplements();
        linkDaoP=new PaqueteImplements();
          linkDaoSXR= new SucursalesPorRutaImplements();
         viaje=new Viajes();
          
    }
    
    public void crearViajes(){
   List <Sucursalesxruta> listaSXR=linkDaoSXR.mostrarSucXRutas();
   for (Sucursalesxruta elem :listaSXR){
       
       if(elem.getRutas().getIdRuta()==idRuta){
         Viajes objetoViaje = new Viajes();

           Camiones camion=linkDAO.getCamion(dominio);
           
            System.out.println(camion.getDescripcion());
            objetoViaje.setCamiones(camion);
            objetoViaje.setSucursalesByOrigen(elem.getSucursalesByOrigen());
            objetoViaje.setSucursalesByDestino(elem.getSucursalesByDestino());
            
            
            
            linkDaoV.insertarViaje(objetoViaje);
            
            
          
       }
   }
    
    
    }
    
     public void busquedaCamion(){
           Camiones camion;
           System.out.println(dominio);
        if (linkDAO.getCamion(dominio) == null) {
          
        setCamionesAct(null);
        /*devuelve el mensaje que el usuario no se encontro */
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "No se encontro patente",
                            "Por favor ingrese una nueva patente"));
         }
        if (linkDAO.getCamion(dominio)!= null ) {
        camion=linkDAO.getCamion(dominio);
        List<Camiones> lista = new ArrayList<Camiones>();
            System.out.println("agrego camion a la lista");
        lista.add(camion);
        setCamionesAct(lista);}
    }
     
     public void busquedaViajes(){
          listaViajes= linkDaoV.buscarViajes(idCamion);
       
    }
     
     public void busquedaViajeId(){
     viaje=linkDaoV.getViaje(idViaje);
     
     }
     public void modificar(){
        viaje.setFechaLlegada(transformarFecha(fechaLlegada));
        viaje.setFechaSalida(transformarFecha(fechaSalida));
        linkDaoV.modificarViaje(viaje);
        viaje= new Viajes();
    }
     
    public Date transformarFecha(String fecha){
        
    Date date=null;
         SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
 
		 date = formatter.parse(fecha);
               
 
	} catch (ParseException e) {
		e.printStackTrace();
	}
        return date;
    } 
       
    
   public List<Paquetes> obtenerPaquetesViaje(){
       List<Paquetes> paquetes = null;
       /*
   if(viaje.getPaqueteses()!=null){
    paquetes= (List<Paquetes>) viaje.getPaqueteses();
               
               */

   return paquetes;
   }
  
   public void insertarPaquete(){
       Paquetes paq= linkDaoP.getPaquete(idPaquete);
       viaje.getPaqueteses().add(paq);
       linkDaoV.modificarViaje(viaje);
       
   }
   
     }

     
      