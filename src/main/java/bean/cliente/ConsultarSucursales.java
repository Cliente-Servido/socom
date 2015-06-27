/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.cliente;

import DAO.LocalidadesImplementa;
import DAO.ProvinciasImplementa;
import DAO.SucursalesImplementa;
import Pojo.Localidades;

import Pojo.Provincias;
import Pojo.Sucursales;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;



/**
 *
 * @author seba
 */
@ManagedBean
@Named(value = "consultarSucursales")
@ViewScoped
public class ConsultarSucursales implements Serializable{
    private Map<String,String> mapaProvincia;
    private Map<String,String> mapaLocalidades; //nombreLocalida, idLocalidad
    private String provinciaSeleccionada;
    private String localidadSeleccionada;
    private List<Sucursales> listaSucu;
    private boolean estado;

    
    
   
    
    @PostConstruct
    public void init(){
        estado=false;
        mapaLocalidades=new HashMap<String,String>();
        mapaProvincia=new HashMap<String,String>();
        List<Provincias> juan=new ProvinciasImplementa().mostrarProvincias();
        
        for (Provincias juan1 : juan) {
            mapaProvincia.put(juan1.getNombre(), (juan1.getIdProvincia()).toString());
        }
    }

    public Map<String, String> getMapaProvincia() {
        return mapaProvincia;
    }

    public void setMapaProvincia(Map<String, String> mapaProvincia) {
        this.mapaProvincia = mapaProvincia;
    }

    public String getProvinciaSeleccionada() {
        return provinciaSeleccionada;
    }

    public void setProvinciaSeleccionada(String provinciaSeleccionada) {
        this.provinciaSeleccionada = provinciaSeleccionada;
    }

    public Map<String, String> getMapaLocalidades() {
        return mapaLocalidades;
    }

    public void setMapaLocalidades(Map<String, String> mapaLocalidades) {
        this.mapaLocalidades = mapaLocalidades;
    }

    public String getLocalidadSeleccionada() {
        return localidadSeleccionada;
    }

    public void setLocalidadSeleccionada(String localidadSeleccionada) {
        this.localidadSeleccionada = localidadSeleccionada;
    }

    public void listarSucursales(){
        listaSucu=new SucursalesImplementa().sucursalesporLocalidad(localidadSeleccionada);
        estado=true;
        System.out.println(estado);
    }
    
    
    

   
    
    public void cambioProvincia(){
        System.out.println("llego provincia");
        List<Localidades> igor=new LocalidadesImplementa().localidadesenProvincia(provinciaSeleccionada);
        for (Localidades igor1 : igor) {
            mapaLocalidades.put(igor1.getNombre(), (igor1.getIdLocalidad()).toString());
        }
        System.out.println("salio cambio provincia");
    
    }

    public List<Sucursales> getListaSucu() {
        return listaSucu;
    }

    public void setListaSucu(List<Sucursales> listaSucu) {
        this.listaSucu = listaSucu;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
 
   
    
}
