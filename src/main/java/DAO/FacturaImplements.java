/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Persistencia.HibernateUtil;
import Pojo.Facturas;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Wolverine20
 */
public class FacturaImplements implements FacturaDao{
    
    @Override
    public List<Facturas> mostrarFacturas(){
    Session session= null;
    List<Facturas> lista=null;
    try{
        
        session=HibernateUtil.getSessionFactory().openSession();
        Query query=session.createQuery("from Facturas");
        lista=(List<Facturas>)query.list();
        
    }catch(HibernateException e){
    System.out.println("Error catch");    
    }
    finally {
        if(session != null){
        session.close();}
    }return lista;
    
     }
    
    @Override
    public void insertarFactura(Facturas factura){
    Session session=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.merge(factura);
            session.getTransaction().commit();
             FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "La factura fue creada con exito" , "No se puedo crear la factura"));
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
    public void modificarFactura(Facturas factura){
    Session session=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(factura);
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
    public void eliminarFactura(Facturas factura){
    Session session=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(factura);
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
    
    

