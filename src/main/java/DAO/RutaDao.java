/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.Rutas;
import java.util.List;

/**
 *
 * @author Juan
 */
public interface RutaDao {
   public List<Rutas> mostrarRutas();
   public Rutas getRuta(Integer idRuta);
   public void insertarRuta(Rutas ruta);
   public void modificarRuta(Rutas ruta);
   public void eliminarRuta(Rutas ruta);
       
}

