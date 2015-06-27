/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.Paquetes;
import java.util.List;

/**
 *
 * @author Wolverine20
 */
public interface PaqueteDao {
   public List<Paquetes> mostrarPaquete();
   public Paquetes getPaquete(Integer idPaquete);
   public void insertarPaquete(Paquetes paquete);
   public void modificarPaquete(Paquetes paquete);
   public void eliminarPaquete(Paquetes paquete);
   
    
}
