/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.Viajes;
import java.util.List;

/**
 *
 * @author Juan
 */
public interface ViajesDao {
    public List<Viajes> mostrarViajes();
    public List<Viajes> buscarViajes(int idCamion);
   public Viajes getViaje(Integer id);
   public void insertarViaje(Viajes viaje);
   public void modificarViaje(Viajes viaje);
   public void eliminarViaje(Viajes viaje);
}
