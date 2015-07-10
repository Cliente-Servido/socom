/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.gerente;

import DAO.PaqueteDao;
import DAO.PaqueteImplements;
import Pojo.Paquetes;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Wolverine20
 */
@ManagedBean
@ViewScoped
public class informeBean implements Serializable{
    int idServicio;

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }
    PaqueteDao linkDaoP;

    public List<Paquetes> getListaPaquetes() {
        return listaPaquetes;
    }

    public void setListaPaquetes(List<Paquetes> listaPaquetes) {
        this.listaPaquetes = listaPaquetes;
    }
    List<Paquetes> listaPaquetes;
    /**
     * Creates a new instance of informeBean
     */
   @PostConstruct
    public void init() {
        
        linkDaoP=new PaqueteImplements();
       
          
    }
    
    public void buscarPaquetes(){
         List<Paquetes> lpaquetes=linkDaoP.paqueteServicio(idServicio);
         for (Paquetes paquete:lpaquetes){
             if(paquete.getFacturas()!=null){
             listaPaquetes.add(paquete);
             
             }
         
         }
         
         
    
    
    }
    
}
