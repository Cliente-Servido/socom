
package DAO;


import Pojo.Estados;
import java.util.List;

/**
 *
 * @author Lucas y Priscila
 */
public interface EstadosDao {
    public List<Estados> mostrarEstadosPaquete(int sdfsdf);
    public List<Estados> buscarEstados(int idPaquete);
    public void insertar(Estados estado);
}