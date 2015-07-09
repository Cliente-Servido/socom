/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Persistencia.HibernateUtil;
import Pojo.Rutas;
import Pojo.Sucursales;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Wolverine20
 */
public class RutaImplements222 implements RutaDao{
    
   
    @Override
    public List<Rutas> mostrarRutas(){
    Session session= null;
    List<Rutas> lista=null;
    try{
        session=HibernateUtil.getSessionFactory().openSession();
        Query query=session.createQuery("from Rutas");
        lista=(List<Rutas>)query.list();
        
    }catch(HibernateException e){
    System.out.println("Error catch");    
    }
    finally {
        if(session != null){
        session.close();}
    }return lista;
    
     }
   
    @Override
    public Rutas getRuta(Integer idRuta){
    
    Rutas ruta = null;
    Session session= null;
    
    try{
        session=HibernateUtil.getSessionFactory().openSession();
        Query query=session.createQuery("from Rutas r WHERE r.idRuta = :idRuta");
        query.setParameter("idRuta", idRuta);
        ruta = (Rutas)query.uniqueResult();
    }catch(HibernateException e){
    System.out.println(e.getMessage());
    session.getTransaction().rollback();
    }
    finally {
        if(session != null){
        session.close();}
    }return ruta;
    
     }
   
    @Override
    public void insertarRuta(Rutas ruta){
    Session session=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(ruta);
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
    public void modificarRuta(Rutas ruta){
    Session session=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(ruta);
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
    public void eliminarRuta(Rutas ruta){
    Session session=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(ruta);
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
    public Rutas getRutaPorSucursales(int ori,int des){
        Rutas ruta = null;
    Session session= null;
    
    try{
        session=HibernateUtil.getSessionFactory().openSession();
        Query query=session.createQuery("from Rutas r WHERE r.origen = "+ori+" AND r.destino= "+des);
       ruta=(Rutas)query.list().get(0);
        System.out.println(ruta.getDescripcion());
    }catch(HibernateException e){
    System.out.println(e.getMessage());
    session.getTransaction().rollback();
    }
    finally {
        if(session != null){
        session.close();}
    }return ruta;
        
        
    }
}
    