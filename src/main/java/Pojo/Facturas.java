package Pojo;
// Generated 19/06/2015 12:59:55 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Facturas generated by hbm2java
 */
public class Facturas  implements java.io.Serializable {


     private Integer idFactura;
     private Clientes clientes;
     private Empleados empleados;
     private Date fecha;
     private Float monto;
     private Set<Paquetes> paqueteses = new HashSet<Paquetes>(0);

    public Facturas() {
    }

    public Facturas(Clientes clientes, Empleados empleados, Date fecha, Float monto, Set<Paquetes> paqueteses) {
       this.clientes = clientes;
       this.empleados = empleados;
       this.fecha = fecha;
       this.monto = monto;
       this.paqueteses = paqueteses;
    }
   
    public Integer getIdFactura() {
        return this.idFactura;
    }
    
    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }
    public Clientes getClientes() {
        return this.clientes;
    }
    
    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }
    public Empleados getEmpleados() {
        return this.empleados;
    }
    
    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Float getMonto() {
        return this.monto;
    }
    
    public void setMonto(Float monto) {
        this.monto = monto;
    }
    public Set<Paquetes> getPaqueteses() {
        return this.paqueteses;
    }
    
    public void setPaqueteses(Set<Paquetes> paqueteses) {
        this.paqueteses = paqueteses;
    }




}

