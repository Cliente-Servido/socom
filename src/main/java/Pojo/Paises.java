package Pojo;
// Generated 09-jul-2015 22:43:00 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Paises generated by hbm2java
 */
public class Paises  implements java.io.Serializable {


     private Integer idPais;
     private String nombre;
     private Set provinciases = new HashSet(0);

    public Paises() {
    }

	
    public Paises(String nombre) {
        this.nombre = nombre;
    }
    public Paises(String nombre, Set provinciases) {
       this.nombre = nombre;
       this.provinciases = provinciases;
    }
   
    public Integer getIdPais() {
        return this.idPais;
    }
    
    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set getProvinciases() {
        return this.provinciases;
    }
    
    public void setProvinciases(Set provinciases) {
        this.provinciases = provinciases;
    }




}


