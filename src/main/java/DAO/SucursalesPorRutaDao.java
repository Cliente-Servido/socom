/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.Sucursalesxruta;
import java.util.List;

/**
 *
 * @author Juan
 */
public interface SucursalesPorRutaDao {
   public List<Sucursalesxruta> mostrarSucXRutas();

   public void insertarSucXRuta(Sucursalesxruta sxr);
   public void modificarSucXRuta(Sucursalesxruta sxr);
   public void eliminarSucXRuta(Sucursalesxruta sxr);
       
}