package Pojo;
// Generated 09-jul-2015 22:43:00 by Hibernate Tools 4.3.1



/**
 * Usuarios generated by hbm2java
 */
public class Usuarios  implements java.io.Serializable {


     private Integer idUsuario;
     private Clientes clientes;
     private Empleados empleados;
     private Gerentes gerentes;
     private String usuario;
     private String pass;

    public Usuarios() {
    }

	
    public Usuarios(String pass) {
        this.pass = pass;
    }
    public Usuarios(Clientes clientes, Empleados empleados, Gerentes gerentes, String usuario, String pass) {
       this.clientes = clientes;
       this.empleados = empleados;
       this.gerentes = gerentes;
       this.usuario = usuario;
       this.pass = pass;
    }
   
    public Integer getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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
    public Gerentes getGerentes() {
        return this.gerentes;
    }
    
    public void setGerentes(Gerentes gerentes) {
        this.gerentes = gerentes;
    }
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getPass() {
        return this.pass;
    }
    
    public void setPass(String pass) {
        this.pass = pass;
    }




}


