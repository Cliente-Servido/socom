/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.cliente;

import DAO.ClienteImplements;
import DAO.PaqueteImplements;
import DAO.ServicioImplements;
import DAO.SucursalesImplementa;
import Pojo.Clientes;
import Pojo.Paquetes;
import Pojo.Servicios;
import Pojo.Usuarios;
import bean.session.SesionClienteBean;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author seba
 */
@ManagedBean
@Named(value = "contratarServicioBean")
@ViewScoped

public class ContratarServicioBean implements Serializable{
    private String servicioSelect;
    private Map<String,String> listaServicios;
    private Servicios servi;
    private String sucuSelect;
    private String sucuDestinoSelec;
    private String nombreDesti;
    private float peso;
    private float costo;
    private String direccion;
    private int dni;
    private String telefono;
    private String email;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

    private SesionClienteBean sesion=null;

    public SesionClienteBean getSesion() {

        return sesion;
 
    }

    public void setSesion(SesionClienteBean sesion) {
        this.sesion = sesion;
    }
   

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
        
        HttpSession miSession=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        sesion=(SesionClienteBean) miSession.getAttribute("sesionClienteBean");
        

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
        paque.setCostoTotal(costo);
        paque.setDestinatarioNombre(this.nombreDesti);
        paque.setDestinatarioDireccion(direccion);
        paque.setDestinatarioDni(dni);
        paque.setDestinatarioEmail(email);
        paque.setDestinatarioTelefono(telefono);
        paque.setServicios(servi);
        paque.setPeso(peso);
        paque.setSucursalesByDestino(new SucursalesImplementa().buscarSucursal(this.sucuDestinoSelec));
        paque.setSucursalesByOrigen(new SucursalesImplementa().buscarSucursal(this.sucuSelect));
        paque.setClientes(sesion.getClaseCliente());
        new PaqueteImplements().insertarPaquete(paque);    
        
    }    
    
}
