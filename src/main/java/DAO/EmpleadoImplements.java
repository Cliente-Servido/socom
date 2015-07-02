/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Persistencia.HibernateUtil;
import Pojo.Empleados;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Wolverine20
 */
public class EmpleadoImplements implements EmpleadoDao{
    
    @Override
    public List<Empleados> mostrarEmpleados(){
    Session session= null;
    List<Empleados> lista=null;
    try{
        System.out.println("Llego hasta acà");
        session=HibernateUtil.getSessionFactory().openSession();
        Query query=session.createQuery("from Empleados");
        lista=(List<Empleados>)query.list();
        
    }catch(HibernateException e){
    System.out.println("Error catch");    
    }
    finally {
        if(session != null){
        session.close();}
    }return lista;
    
     }
    @Override
    public Empleados getEmpleado(Integer legajo){
    
    Empleados empleado = null;
    Session session= null;
    
    try{
        session=HibernateUtil.getSessionFactory().openSession();
        Query query=session.createQuery("from Empleados e WHERE e.legajo = :legajo");
        query.setParameter("legajo", legajo);
        empleado = (Empleados)query.uniqueResult();
    }catch(HibernateException e){
    System.out.println(e.getMessage());
    session.getTransaction().rollback();
    }
    finally {
        if(session != null){
        session.close();}
    }return empleado;
    
     }
    @Override
    public void insertarEmpleado(Empleados empleado){
    Session session=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.merge(empleado);
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
    public void modificarEmpleado(Empleados empleado){
    Session session=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(empleado);
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
    public void eliminarEmpleado(Empleados empleado){
    Session session=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(empleado);
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
    
    

