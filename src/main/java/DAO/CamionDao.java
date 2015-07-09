/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.Camiones;
import java.util.List;

/**
 *
 * @author Wolverine20
 */
public interface CamionDao {
   public List<Camiones> mostrarCamiones();
   public Camiones getCamion(String patente);
   public void insertarCamion(Camiones camion);
   public void modificarCamion(Camiones camion);
   public void eliminarCamion(Camiones camion);
    public Camiones getCamionId(int idCamion);
}
