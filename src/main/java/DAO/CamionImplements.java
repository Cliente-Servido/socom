/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Persistencia.HibernateUtil;
import Pojo.Camiones;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Wolverine20
 */
public class CamionImplements implements CamionDao{
    
    @Override
    public List<Camiones> mostrarCamiones(){
    Session session= null;
    List<Camiones> lista=null;
    try{
        session=HibernateUtil.getSessionFactory().openSession();
        Query query=session.createQuery("from Camiones");
        lista=(List<Camiones>)query.list();
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
    public Camiones getCamion(String patente){
    Camiones camion = null;
    Session session= null;
    try{
        session=HibernateUtil.getSessionFactory().openSession();
        Query query=session.createQuery("from Camiones c WHERE c.dominio= :patente");
        query.setParameter("patente", patente);
        camion = (Camiones)query.uniqueResult();
    }catch(HibernateException e){
    System.out.println(e.getMessage());
    session.getTransaction().rollback();
    }
    finally {
        if(session != null){
        session.close();}
    }return camion;
    
     }
    
   
    
    
    
    @Override
    public void insertarCamion(Camiones camion){
    Session session=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(camion);

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
    public void modificarCamion(Camiones camion){
    Session session=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(camion);
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
    public void eliminarCamion(Camiones camion){
    Session session=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(camion);
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
