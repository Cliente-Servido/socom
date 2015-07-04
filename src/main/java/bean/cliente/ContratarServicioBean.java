/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.cliente;

import DAO.ClienteImplements;
import DAO.ServicioImplements;
import Pojo.Clientes;
import Pojo.Paquetes;
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
    private Servicios servi;
    private String sucuSelect;
    private String sucuDestinoSelec;
    private String nombreDesti;
    private float peso;
    private float costo;
    private Clientes cliente;
    
    /*
    private Clientes getCliente(){
        cliente= new ClienteImplements().getServicio()
    }*/

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }
    

    public String getNombreDesti() {
        return nombreDesti;
    }

    public void setNombreDesti(String nombreDesti) {
        this.nombreDesti = nombreDesti;
    }

    public String getSucuDestinoSelec() {
        return sucuDestinoSelec;
    }

    public void setSucuDestinoSelec(String sucuDestinoSelec) {
        this.sucuDestinoSelec = sucuDestinoSelec;
    }

    public String getSucuSelect() {
        return sucuSelect;
    }

    public void setSucuSelect(String sucuSelect) {
        this.sucuSelect = sucuSelect;
    }
    
    @PostConstruct
    public void init(){
        System.out.println("llego 1");
        servi=new Servicios();
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

    public Servicios getServi() {
        return servi;
    }

    public void setServi(Servicios servi) {
        this.servi = servi;
    }

    
    public void cambioServicio(){
        servi=new ServicioImplements().getServicio(servicioSelect);
    }
    
    public void calcularCosto(){
        float costoServi= new ServicioImplements().getServicio(this.servicioSelect).getCostokg();
        float costoSeguro=new ServicioImplements().getServicio(servicioSelect).getCostoseguro();
        costo=(costoServi*this.peso)+costoSeguro;
    }
    
    public void grabarPaquete(){
        
        Paquetes paque=new Paquetes();
       
        
    }    
    
}
