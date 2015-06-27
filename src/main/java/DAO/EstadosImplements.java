/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Persistencia.HibernateUtil;
import Pojo.Estados;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Lucas y Priscila
 */
public class EstadosImplements implements EstadosDao{

    @Override
    public List<Estados> mostrarEstadosPaquete(int id) {
       Session session= null;
    List<Estados> lista=null;
    try{
        
        session=HibernateUtil.getSessionFactory().openSession();
        Query query=session.createQuery("from Estados where paquetes.idPaquete=" + id);
        lista=(List<Estados>)query.list();
        
    }catch(HibernateException e){
    System.out.println("Error catch");    
    }
    finally {
        if(session != null){
        session.close();}
    }
    return lista;     
    }
    
}
