package Pojo;
// Generated 09-jul-2015 22:43:00 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Rutas generated by hbm2java
 */
public class Rutas  implements java.io.Serializable {


     private Integer idRuta;
     private Sucursales sucursalesByOrigen;
     private Sucursales sucursalesByDestino;
     private String descripcion;
     private Integer cantidadSucursales;
     private Set camioneses = new HashSet(0);
     private Set sucursalesxrutas = new HashSet(0);

    public Rutas() {
    }

	
    public Rutas(Sucursales sucursalesByOrigen, Sucursales sucursalesByDestino) {
        this.sucursalesByOrigen = sucursalesByOrigen;
        this.sucursalesByDestino = sucursalesByDestino;
    }
    public Rutas(Sucursales sucursalesByOrigen, Sucursales sucursalesByDestino, String descripcion, Integer cantidadSucursales, Set camioneses, Set sucursalesxrutas) {
       this.sucursalesByOrigen = sucursalesByOrigen;
       this.sucursalesByDestino = sucursalesByDestino;
       this.descripcion = descripcion;
       this.cantidadSucursales = cantidadSucursales;
       this.camioneses = camioneses;
       this.sucursalesxrutas = sucursalesxrutas;
    }
   
    public Integer getIdRuta() {
        return this.idRuta;
    }
    
    public void setIdRuta(Integer idRuta) {
        this.idRuta = idRuta;
    }
    public Sucursales getSucursalesByOrigen() {
        return this.sucursalesByOrigen;
    }
    
    public void setSucursalesByOrigen(Sucursales sucursalesByOrigen) {
        this.sucursalesByOrigen = sucursalesByOrigen;
    }
    public Sucursales getSucursalesByDestino() {
        return this.sucursalesByDestino;
    }
    
    public void setSucursalesByDestino(Sucursales sucursalesByDestino) {
        this.sucursalesByDestino = sucursalesByDestino;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Integer getCantidadSucursales() {
        return this.cantidadSucursales;
    }
    
    public void setCantidadSucursales(Integer cantidadSucursales) {
        this.cantidadSucursales = cantidadSucursales;
    }
    public Set getCamioneses() {
        return this.camioneses;
    }
    
    public void setCamioneses(Set camioneses) {
        this.camioneses = camioneses;
    }
    public Set getSucursalesxrutas() {
        return this.sucursalesxrutas;
    }
    
    public void setSucursalesxrutas(Set sucursalesxrutas) {
        this.sucursalesxrutas = sucursalesxrutas;
    }




}


