/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Persistencia.HibernateUtil;
import Pojo.Viajes;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Juan
 */
public class ViajesImplements implements ViajesDao {
     
    @Override
    public List<Viajes> mostrarViajes(){
    Session session= null;
    List<Viajes> lista=null;
    try{
        session=HibernateUtil.getSessionFactory().openSession();
        Query query=session.createQuery("from Viajes");
        lista=(List<Viajes>)query.list();
        
    }catch(HibernateException e){
    System.out.println("Error catch");    
    }
    finally {
        if(session != null){
        session.close();}
    }return lista;
    
     }
    @Override
    public Viajes getViaje(Integer id){
    
    Viajes viaje = null;
    Session session= null;
    
    try{
        session=HibernateUtil.getSessionFactory().openSession();
        Query query=session.createQuery("from Viajes e WHERE e.idViaje = :id");
        query.setParameter("id", id);
        viaje = (Viajes)query.uniqueResult();
    }catch(HibernateException e){
    System.out.println(e.getMessage());
    session.getTransaction().rollback();
    }
    finally {
        if(session != null){
        session.close();}
    }return viaje;
    
     }
    @Override
    public void insertarViaje(Viajes viaje){
    Session session=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.merge(viaje);
            session.getTransaction().commit();
    }catch(HibernateException e){
        System.out.println(e.getMessage());
        session.getTransaction().rollback();
    }finally{
        if(session!=null){
            session.close();
        }
        }
    }
    @Override
    public void modificarViaje(Viajes viaje){
    Session session=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(viaje);
            session.getTransaction().commit();
    }catch(HibernateException e){
        System.out.println(e.getMessage());
        session.getTransaction().rollback();
    }finally{
        if(session!=null){
            session.close();
        }
        }
    }
    @Override
    public void eliminarViaje(Viajes viaje){
    Session session=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(viaje);
            session.getTransaction().commit();
    }catch(HibernateException e){
        System.out.println(e.getMessage());
        session.getTransaction().rollback();
    }finally{
        if(session!=null){
            session.close();
        }
        }}
    

  
    @Override
    public List<Viajes> buscarViajes(int idCamion){
    Session session= null;
    List<Viajes> lista=null;
    try{
        session=HibernateUtil.getSessionFactory().openSession();
        Query query=session.createQuery("from Viajes where idCamion= :idCamion order by idViaje desc");
        query.setParameter("idCamion", idCamion);
        lista=(List<Viajes>)query.list();
        
    }catch(HibernateException e){
    System.out.println("Error catch");    
    }
    finally {
        if(session != null){
        session.close();}
    }return lista;

}
    
}
