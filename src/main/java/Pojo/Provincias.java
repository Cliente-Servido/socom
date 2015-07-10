package Pojo;
// Generated 09-jul-2015 22:43:00 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Provincias generated by hbm2java
 */
public class Provincias  implements java.io.Serializable {


     private Integer idProvincia;
     private Paises paises;
     private String nombre;
     private Set localidadeses = new HashSet(0);

    public Provincias() {
    }

	
    public Provincias(Paises paises, String nombre) {
        this.paises = paises;
        this.nombre = nombre;
    }
    public Provincias(Paises paises, String nombre, Set localidadeses) {
       this.paises = paises;
       this.nombre = nombre;
       this.localidadeses = localidadeses;
    }
   
    public Integer getIdProvincia() {
        return this.idProvincia;
    }
    
    public void setIdProvincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
    }
    public Paises getPaises() {
        return this.paises;
    }
    
    public void setPaises(Paises paises) {
        this.paises = paises;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set getLocalidadeses() {
        return this.localidadeses;
    }
    
    public void setLocalidadeses(Set localidadeses) {
        this.localidadeses = localidadeses;
    }




}


