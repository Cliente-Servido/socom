package bean.gerente;

import DAO.EmpleadoDao;
import Pojo.Sucursales;
import java.io.Serializable;
import DAO.EmpleadoImplements;
import Pojo.Empleados;
import Pojo.Usuarios;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Wolverine20
 */
@ManagedBean
@ViewScoped
public class EmpleadoBean implements Serializable {

    Empleados empleado= new Empleados();
    List<Empleados> empleados;
    List<Empleados> empleadosAct=null;
    Sucursales sucursal=null;
    String fecha;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public List<Empleados> getEmpleadosAct() {
        return empleadosAct;
    }

    public void setEmpleadosAct(List<Empleados> empleadosAct) {
        this.empleadosAct = empleadosAct;
    }
    public Sucursales getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursales sucursal) {
        this.sucursal = sucursal;
    }
    EmpleadoDao linkDAO= new EmpleadoImplements();
    
    @PostConstruct
    public void init() {
        
        empleado = new Empleados();
        linkDAO= new EmpleadoImplements();
        
        HttpSession miSesion=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        final Usuarios usuario= (Usuarios)miSesion.getAttribute("usuario");
        this.empleado.setSucursales(usuario.getGerentes().getSucursales());
    }
    
    
    public void insertar(){
         SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
 
		Date date = formatter.parse(fecha);
                this.empleado.setFechaAlta(date);
		System.out.println(date);
		System.out.println(formatter.format(date));
 
	} catch (ParseException e) {
		e.printStackTrace();
	}

        linkDAO.insertarEmpleado(empleado);
        empleado= new Empleados();
        FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "El empleado fue añadido con exito" , "No se puedo añadir empleado"));
    }
    
    public void modificar(){
        linkDAO.modificarEmpleado(empleado);
        empleado= new Empleados();
    }
    public void eliminar(){
        linkDAO.eliminarEmpleado(empleado);
        empleado= new Empleados();
    }
    public Empleados getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleados empleado) {
        this.empleado = empleado;
}

    public List<Empleados> getEmpleados() {
        System.out.println("Llego hasta acÃ  2");
        empleados=linkDAO.mostrarEmpleados();
        
        System.out.println("Empleados: " + empleados.size());
        return empleados;
    }
    

    public void setEmpleados(List<Empleados> empleados) {
        this.empleados = empleados;
    }
    
    public void buscar(){
        if (linkDAO.getEmpleado(getEmpleado().getLegajo()) == null) {

        setEmpleadosAct(null);
        /*devuelve el mensaje que el usuario no se encontro */
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "No se encontro legajo",
                            "Por favor ingrese nuevo legajo"));
    }
        
        if (linkDAO.getEmpleado(getEmpleado().getLegajo()) != null ) {
           empleado=linkDAO.getEmpleado(getEmpleado().getLegajo());
        List<Empleados> lista = new ArrayList<Empleados>();
        lista.add(empleado);
        setEmpleadosAct(lista);}
    }
    
      public List<Empleados> listaActualizada (){
      if (getEmpleadosAct()==null){
      return getEmpleados();
      }else{
          return getEmpleadosAct();
      }
      }    
}
