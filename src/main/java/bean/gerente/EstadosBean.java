/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.gerente;

import DAO.EstadosDao;
import DAO.EstadosImplements;
import DAO.PaqueteDao;
import DAO.PaqueteImplements;
import Pojo.Estados;
import Pojo.Paquetes;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Juan
 */
@ManagedBean
@ViewScoped
public class EstadosBean implements Serializable{
    Estados estado;


    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }
    /**
     * Creates a new instance of EstadosBean22
     */
    public EstadosBean() {
    }
     int idPaquete;

    public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }
    List <Estados> estados;

    public List<Estados> getEstados() {
        return estados;
    }

    public void setEstados(List<Estados> estados) {
        this.estados = estados;
    }
    EstadosDao linkDao;
    PaqueteDao linkDaoP;
    /**
     * Creates a new instance of EstadosBean
     */

    @PostConstruct
    public void init() {
        
        estado = new Estados();
        linkDao= new EstadosImplements();
        linkDaoP= new PaqueteImplements();
      
    }
    
    public void insertar(){
        
        estado.setPaquetes( buscarpaquete());
        linkDao.insertar(estado);
        buscarEstado();
        estado = new Estados();
       
    }
    public void modificar(){
        
    }
    public void eliminar(){
        
    }

    public void buscarEstado(){
          System.out.println("Llego hasta aca 1dxhtdrhdt");
        setEstados(linkDao.buscarEstados(idPaquete));
        
    }
    public Paquetes buscarpaquete(){
        System.out.println(idPaquete);
       final Paquetes paq= linkDaoP.getPaquete(idPaquete);
        System.out.println("aca:");
        System.out.println(paq.getDestinatarioNombre());
        return paq;
    }
   
}
    