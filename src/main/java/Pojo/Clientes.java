package Pojo;
// Generated 09-jul-2015 22:30:32 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Clientes generated by hbm2java
 */
public class Clientes  implements java.io.Serializable {


     private Integer idCliente;
     private String apellido;
     private String nombre;
     private String direccion;
     private String telefono;
     private String email;
     private Set usuarioses = new HashSet(0);
     private Set facturases = new HashSet(0);
     private Set paqueteses = new HashSet(0);

    public Clientes() {
    }

	
    public Clientes(String apellido, String nombre, String direccion) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.direccion = direccion;
    }
    public Clientes(String apellido, String nombre, String direccion, String telefono, String email, Set usuarioses, Set facturases, Set paqueteses) {
       this.apellido = apellido;
       this.nombre = nombre;
       this.direccion = direccion;
       this.telefono = telefono;
       this.email = email;
       this.usuarioses = usuarioses;
       this.facturases = facturases;
       this.paqueteses = paqueteses;
    }
   
    public Integer getIdCliente() {
        return this.idCliente;
    }
    
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
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
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public Set getUsuarioses() {
        return this.usuarioses;
    }
    
    public void setUsuarioses(Set usuarioses) {
        this.usuarioses = usuarioses;
    }
    public Set getFacturases() {
        return this.facturases;
    }
    
    public void setFacturases(Set facturases) {
        this.facturases = facturases;
    }
    public Set getPaqueteses() {
        return this.paqueteses;
    }
    
    public void setPaqueteses(Set paqueteses) {
        this.paqueteses = paqueteses;
    }




}


