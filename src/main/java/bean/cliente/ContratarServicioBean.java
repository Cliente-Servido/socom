/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.cliente;

import DAO.ServicioImplements;
import Pojo.Servicios;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author seba
 */
@ManagedBean
@Named(value = "contratarServicioBean")
@ViewScoped

public class ContratarServicioBean {
    private String servicioSelect;
    private Map<String,String> listaServicios;
    
    @PostConstruct
    public void init(){
        System.out.println("llego 1");
        listaServicios=new HashMap<String,String>();
        List<Servicios> juan=new ServicioImplements().mostrarServicio();
        for (Servicios juan1 : juan) {
           listaServicios.put(juan1.getNombre(), juan1.getIdServicio().toString());
            }
    }
    
    public ContratarServicioBean() {
    }

    public String getServicioSelect() {
        return servicioSelect;
    }

    public void setServicioSelect(String servicioSelect) {
        this.servicioSelect = servicioSelect;
    }
    

    public Map<String,String> getListaServicios() {
        
        return listaServicios;
    }

    
    
    
}
