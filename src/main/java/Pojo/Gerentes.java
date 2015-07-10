package Pojo;
// Generated 09-jul-2015 22:43:00 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Gerentes generated by hbm2java
 */
public class Gerentes  implements java.io.Serializable {


     private Integer idGerente;
     private Sucursales sucursales;
     private String apellido;
     private String nombre;
     private Integer legajo;
     private Set usuarioses = new HashSet(0);

    public Gerentes() {
    }

	
    public Gerentes(Sucursales sucursales, String apellido, String nombre) {
        this.sucursales = sucursales;
        this.apellido = apellido;
        this.nombre = nombre;
    }
    public Gerentes(Sucursales sucursales, String apellido, String nombre, Integer legajo, Set usuarioses) {
       this.sucursales = sucursales;
       this.apellido = apellido;
       this.nombre = nombre;
       this.legajo = legajo;
       this.usuarioses = usuarioses;
    }
   
    public Integer getIdGerente() {
        return this.idGerente;
    }
    
    public void setIdGerente(Integer idGerente) {
        this.idGerente = idGerente;
    }
    public Sucursales getSucursales() {
        return this.sucursales;
    }
    
    public void setSucursales(Sucursales sucursales) {
        this.sucursales = sucursales;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getLegajo() {
        return this.legajo;
    }
    
    public void setLegajo(Integer legajo) {
        this.legajo = legajo;
    }
    public Set getUsuarioses() {
        return this.usuarioses;
    }
    
    public void setUsuarioses(Set usuarioses) {
        this.usuarioses = usuarioses;
    }




}


