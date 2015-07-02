/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.cliente;

import DAO.ServicioDao;
import DAO.ServicioImplements;
import Pojo.Servicios;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author seba
 */
@ManagedBean
@Named(value = "consultarServiciosBean")
@RequestScoped
public class ConsultarServiciosBean implements Serializable{
    
    Servicios servicio;
    List<Servicios> serv ;
    ServicioDao link;
    
    @PostConstruct
    public void init() {
        serv=null;
        servicio = new Servicios();
        link= new ServicioImplements();
      
    }
    
    public List<Servicios> getServ() {
        serv=link.mostrarServicio();
        return serv;
    }

    public void setServ(List<Servicios> serv) {
        this.serv = serv;
    }
    
    
    
    
    
}
