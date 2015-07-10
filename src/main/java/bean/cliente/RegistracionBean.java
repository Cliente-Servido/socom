/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.cliente;

import DAO.ClienteImplements;
import DAO.UsuarioImplementa;
import Pojo.Clientes;
import Pojo.Usuarios;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Lucas y Priscila
 */
@ManagedBean
@Named(value = "registracionBean")
@RequestScoped
public class RegistracionBean {
    private String usuario;
    private String pass;
    private String nombre;
    private String apellido;
    private String dir;
    private String email;
    private String telefono;

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String Apellido) {
        this.apellido = Apellido;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    /**
     * Creates a new instance of RegistracionBean
     */
    public RegistracionBean() {
    }
    
    
    public void registrar(){
        if (!(new UsuarioImplementa().existeUsuario(this.usuario))){
            Clientes cliente=new Clientes(apellido, nombre, dir, telefono, email, null, null, null);
            Usuarios usuario=new Usuarios(cliente, null, null, this.usuario, pass);

            new ClienteImplements().grabarCliente(cliente);
            new UsuarioImplementa().grabarUsuario(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cuenta creada", "Deberá loguearse para continuar"));
        } else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario existente", "Deberá elegir otro nombre para como usuario"));
        }
        
        
        
    }
}
