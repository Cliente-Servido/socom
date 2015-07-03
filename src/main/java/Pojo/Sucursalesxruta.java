package Pojo;
// Generated 19/06/2015 12:59:55 by Hibernate Tools 4.3.1



/**
 * Sucursalesxruta generated by hbm2java
 */
public class Sucursalesxruta  implements java.io.Serializable {

    
     private Integer idSucursalesxRuta;
     private Rutas rutas;
     private Sucursales sucursalesByDestino;
     private Sucursales sucursalesByOrigen;
     private Integer secuencia;

    public Sucursalesxruta() {
    }

	
    public Sucursalesxruta(Rutas rutas, Sucursales sucursalesByDestino, Sucursales sucursalesByOrigen) {
        this.rutas = rutas;
        this.sucursalesByDestino = sucursalesByDestino;
        this.sucursalesByOrigen = sucursalesByOrigen;
    }
    public Sucursalesxruta(Rutas rutas, Sucursales sucursalesByDestino, Sucursales sucursalesByOrigen, Integer secuencia) {
       this.rutas = rutas;
       this.sucursalesByDestino = sucursalesByDestino;
       this.sucursalesByOrigen = sucursalesByOrigen;
       this.secuencia = secuencia;
    }
   
    public Integer getIdSucursalesxRuta() {
        return this.idSucursalesxRuta;
    }
    
    public void setIdSucursalesxRuta(Integer idSucursalesxRuta) {
        this.idSucursalesxRuta = idSucursalesxRuta;
    }
    public Rutas getRutas() {
        return this.rutas;
    }
    
    public void setRutas(Rutas rutas) {
        this.rutas = rutas;
    }
    public Sucursales getSucursalesByDestino() {
        return this.sucursalesByDestino;
    }
    
    public void setSucursalesByDestino(Sucursales sucursalesByDestino) {
        this.sucursalesByDestino = sucursalesByDestino;
    }
    public Sucursales getSucursalesByOrigen() {
        return this.sucursalesByOrigen;
    }
    
    public void setSucursalesByOrigen(Sucursales sucursalesByOrigen) {
        this.sucursalesByOrigen = sucursalesByOrigen;
    }
    public Integer getSecuencia() {
        return this.secuencia;
    }
    
    public void setSecuencia(Integer secuencia) {
        this.secuencia = secuencia;
    }




}


