/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.Servicios;
import java.util.List;

/**
 *
 * @author Wolverine20
 */
public interface ServicioDao {
   public List<Servicios> mostrarServicio();
   public Servicios getServicio(Integer idServicio);
   public void insertarServicio(Servicios servicio);
   public void modificarServicio(Servicios servicio);
   public void eliminarServicio(Servicios servicio);
   
    
}
