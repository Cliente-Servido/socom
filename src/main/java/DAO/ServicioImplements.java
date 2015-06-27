/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Persistencia.HibernateUtil;
import Pojo.Servicios;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Wolverine20
 */
public class ServicioImplements implements ServicioDao{
    
    @Override
    public List<Servicios> mostrarServicio(){
    Session session= null;
    List<Servicios> lista=null;
    try{
        session=HibernateUtil.getSessionFactory().openSession();
        Query query=session.createQuery("from Servicios");
        lista=(List<Servicios>)query.list();
    }catch(HibernateException e){
    System.out.println(e.getMessage());
    session.getTransaction().rollback();
    }
    finally {
        if(session != null){
        session.close();}
    }return lista;
    
     }
    
  
    @Override
    public Servicios getServicio(Integer idServicio){
    
        Servicios servicio = null;
    Session session= null;
    
    try{
        session=HibernateUtil.getSessionFactory().openSession();
        Query query=session.createQuery("from Servicios s WHERE s.idServicio = :id");
        query.setParameter("id", idServicio);
        servicio = (Servicios)query.uniqueResult();
    }catch(HibernateException e){
    System.out.println(e.getMessage());
    session.getTransaction().rollback();
    }
    finally {
        if(session != null){
        session.close();}
    }return servicio;
    
     }
    
    
    
    @Override
    public void insertarServicio(Servicios servicio){
    Session session=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(servicio);

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
    public void modificarServicio(Servicios servicio){
    Session session=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(servicio);
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
    public void eliminarServicio(Servicios servicio){
    Session session=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(servicio);
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
}
