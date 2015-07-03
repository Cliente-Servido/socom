/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.session;

import Persistencia.HibernateUtil;
import Pojo.Sucursales;
import Pojo.Usuarios;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author seba
 */
@Named(value = "sesionClienteBean")
@SessionScoped
public class SesionClienteBean implements Serializable {
    private String usuario;
    private String contrasenia;
    private Usuarios claseUsuario=null;
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
    
    public String validarUsuarioContrasenia() {
        boolean valid = this.validar();
        if (valid) { HttpSession httpSession=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            this.estalogeado=true;
            return "index";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Usuario y ContraseÃ±a Incorrecto",
                            "Por favor ingrese Usuario y contraseÃ±a de nuevo"));
            return "login";
        }
    }
     
    public boolean validar(){
        Usuarios claseUsuario=null;
        Session session= null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "select u from Usuarios u, Clientes c where (u.clientes.idCliente=c.idCliente) and (u.usuario= '" + this.getUsuario()
					+ "' and u.pass = '" + this.getContrasenia()+ "'";
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				claseUsuario = (Usuarios) query.list().get(0);
                                
			}

		} catch (Exception e) {
			throw e;
		}finally{
                if(session==null){
                session.close();
                
                }}
                if(claseUsuario!=null){
                    HttpSession miSession=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                    miSession.setAttribute("usuario", claseUsuario);
                    return true;}else return false;
                    
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
