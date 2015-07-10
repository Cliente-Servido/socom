/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.session;

import DAO.ClienteImplements;
import DAO.UsuarioImplementa;
import Persistencia.HibernateUtil;
import Pojo.Clientes;
import Pojo.Sucursales;
import Pojo.Usuarios;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author seba
 */
@ManagedBean
@Named(value = "sesionClienteBean")
@SessionScoped
public class SesionClienteBean implements Serializable {
    private String usuario;
    private String contrasenia;
    private Usuarios claseUsuario=null;
    private Clientes claseCliente=null;
    private boolean estalogeado=false;
    
    
    
    public boolean isEstalogeado() {
        return estalogeado;
    }
    
    public void setEstalogeado(boolean estalogeado) {
        this.estalogeado = estalogeado;
    }
    
    public SesionClienteBean() {
        
       HttpSession miSession=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        miSession.setMaxInactiveInterval(5000);
    }
    
    public void setUsuario(String usuario){
        this.usuario=usuario;
    }
    public String getUsuario(){
    return this.usuario;
    }
    public void setContrasenia(String contrasenia){
    this.contrasenia=contrasenia;
    }
    public String getContrasenia(){
    return this.contrasenia; 
    }

    public Usuarios getClaseUsuario() {
        return claseUsuario;
    }

    public Clientes getClaseCliente() {
        return claseCliente;
    }
    
    
    public String validarUsuario(){
        boolean pepe=new UsuarioImplementa().validarCliente(usuario, contrasenia);
        if(pepe){
            this.claseUsuario = new UsuarioImplementa().obtenerUsuario(usuario, contrasenia);
            this.claseCliente= new ClienteImplements().getCliente(claseUsuario.getClientes().getIdCliente());
            this.estalogeado=true;
            HttpSession miSession=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            miSession.setAttribute("sesionClienteBean", this);
            
            
        }
        return "index";
    }
     
    
    
    public String logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        session.invalidate();
        return "index";
    }
    
    public boolean verificarSesion(){
        if  (this.claseUsuario==null){
            return false;
        }
        else return true;
    }

        
}
