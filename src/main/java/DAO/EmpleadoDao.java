/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.Empleados;
import java.util.List;

/**
 *
 * @author Wolverine20
 */
public interface EmpleadoDao {
   public List<Empleados> mostrarEmpleados();
   public Empleados getEmpleado(Integer legajo);
   public void insertarEmpleado(Empleados empleado);
   public void modificarEmpleado(Empleados empleado);
   public void eliminarEmpleado(Empleados empleado);
   
}
