/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.cliente;

import DAO.EstadosImplements;

import Pojo.Estados;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import otros.ResultadoConsultaSeguimiento;


/**
 *
 * @author Lucas y Priscila
 */
@ManagedBean
@Named(value = "seguimientoBean")
@RequestScoped
public class SeguimientoBean {
    private int nroEnvio;
    private EstadosImplements link;
    private List<ResultadoConsultaSeguimiento> estados;
    
    /**
     * Creates a new instance of SeguimientoBean
     */
    public SeguimientoBean() {
    }
    
    @PostConstruct
    public void init(){
    link=new EstadosImplements();
    }

    public int getNroEnvio() {
        return nroEnvio;
    }

    public void setNroEnvio(int nroEnvio) {
        this.nroEnvio = nroEnvio;
    }
    
    public List<ResultadoConsultaSeguimiento> getEstados(){
        estados=link.mostrarEstadosPaqueteLocalidad(nroEnvio);
        return estados;
            
    }
    
    public void setEstados(){
        
    }
    
}
