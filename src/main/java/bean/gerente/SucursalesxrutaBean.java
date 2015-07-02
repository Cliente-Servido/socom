/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.gerente;

import DAO.SucursalesPorRutaImplements;
import DAO.SucursalesPorRutaDao;
import Pojo.Sucursalesxruta;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Juan
 */
@ManagedBean
@Dependent
public class SucursalesxrutaBean implements Serializable{

    /**
     * Creates a new instance of SuycursalesxrutaBean
     */

    
    Sucursalesxruta sxr;
    List<Sucursalesxruta> sxrs; 
    
    SucursalesPorRutaDao linkDAO= new SucursalesPorRutaImplements();
    
    @PostConstruct
    public void init() {    
    sxr = new Sucursalesxruta();
    linkDAO= new SucursalesPorRutaImplements();   
    }    
    public void insertar(){
        
        linkDAO.insertarSucXRuta(sxr);
        sxr= new Sucursalesxruta();
        FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "El empleado fue añadido con exito" , "No se puedo añadir empleado"));
    }
    
    public void modificar(){
        linkDAO.modificarSucXRuta(sxr);
        sxr= new Sucursalesxruta();
    }
    public void eliminar(){
        linkDAO.eliminarSucXRuta(sxr);
        sxr= new Sucursalesxruta();
    }
    public Sucursalesxruta getSucXRuta() {
        return sxr;
    }

    public void setSucXRuta(Sucursalesxruta sxr) {
        this.sxr = sxr;
}

    public List<Sucursalesxruta> getSucursalesxruta() {
        System.out.println("Llego hasta acÃ  2");
        sxrs=linkDAO.mostrarSucXRutas();
        
        System.out.println("Empleados: " + sxrs.size());
        return sxrs;
    }
    

    public void setEmpleados(List<Sucursalesxruta> sxrs) {
        this.sxrs = sxrs;
    }
}


