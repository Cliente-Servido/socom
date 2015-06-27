package bean.gerente;

import DAO.EmpleadoDao;
import Pojo.Sucursales;
import java.io.Serializable;
import DAO.EmpleadoImplements;
import Pojo.Empleados;
import Pojo.Usuarios;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Wolverine20
 */
@ManagedBean
@RequestScoped

public class EmpleadoBean implements Serializable {

    Empleados empleado= new Empleados();
    List<Empleados> empleados;
    List<Empleados> empleadosAct=null;
    Sucursales sucursal=null;
    
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
    
    public void init() {
    }
    
    public void insertar(){
        HttpSession sessionUsuario=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Usuarios usuario =(Usuarios)sessionUsuario.getAttribute("usuario");
        System.out.println(usuario.getIdUsuario());
        this.empleado.setSucursales(usuario.getGerentes().getSucursales());
        linkDAO.insertarEmpleado(empleado);
        empleado= new Empleados(); }
    
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
        System.out.println("Llego hasta acà 2");
        empleados=linkDAO.mostrarEmpleados();
        
        System.out.println("Empleados: " + empleados.size());
        return empleados;
    }
    

    public void setEmpleados(List<Empleados> empleados) {
        this.empleados = empleados;
    }
    
    public void buscar(){
        if (linkDAO.getEmpleado(getEmpleado().getLegajo()) == null) {
        System.out.println("nulo");
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
