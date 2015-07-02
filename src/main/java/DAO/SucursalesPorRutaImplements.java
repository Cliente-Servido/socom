/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Persistencia.HibernateUtil;
import Pojo.Sucursalesxruta;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Juan
 */
public class SucursalesPorRutaImplements implements SucursalesPorRutaDao{

    @Override
    public List<Sucursalesxruta> mostrarSucXRutas() {
    Session session= null;
    List<Sucursalesxruta> lista=null;
    try{
        session=HibernateUtil.getSessionFactory().openSession();
        Query query=session.createQuery("from Sucursalesxruta");
        lista=(List<Sucursalesxruta>)query.list();
        
    }catch(HibernateException e){
    System.out.println("Error catch");    
    }
    finally {
        if(session != null){
        session.close();}
    }return lista;
    
     }


    @Override
    public void insertarSucXRuta(Sucursalesxruta sxr) {
    Session session=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(sxr);
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
    public void modificarSucXRuta(Sucursalesxruta sxr) {
        Session session=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(sxr);
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
    public void eliminarSucXRuta(Sucursalesxruta sxr) {
        Session session=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(sxr);
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
