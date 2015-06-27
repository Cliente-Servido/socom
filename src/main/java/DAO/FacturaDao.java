/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.Facturas;
import java.util.List;

/**
 *
 * @author Wolverine20
 */
public interface FacturaDao {
   public List<Facturas> mostrarFacturas();
   public void insertarFactura(Facturas factura);
   public void modificarFactura(Facturas factura);
   public void eliminarFactura(Facturas factura);
   
}
