
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
import otros.ResultadoConsultaSeguimiento;

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
        Query query=session.createQuery("select e.fecha from Estados e,Sucursales s,Localidades l where paquetes.idPaquete=" + id);
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
    



public List<ResultadoConsultaSeguimiento> mostrarEstadosPaqueteLocalidad(int id) {
       Session session= null;
    List<ResultadoConsultaSeguimiento> lista=null;
    try{
        
        session=HibernateUtil.getSessionFactory().openSession();
        Query query=session.createQuery("select new otros.ResultadoConsultaSeguimiento(e.fecha,e.descripcion,loc.nombre) from Estados e, Sucursales suc, Localidades loc where e.sucursales.idSucursal=suc.idSucursal and suc.localidades.idLocalidad=loc.idLocalidad and e.paquetes.idPaquete=" + id);
        lista=(List<ResultadoConsultaSeguimiento>)query.list();
        
    }catch(HibernateException e){
    System.out.println("Error catch");    
    }
    finally {
        if(session != null){
        session.close();}
    }
    return lista;     
    }
    @Override
    public List<Estados> buscarEstados(int idPaquete) {
    Session session = null;
    List<Estados> listaEstados = null;
     try{
        
        session=HibernateUtil.getSessionFactory().openSession();
        Query query=session.createQuery("from Estados where idPaquete=" + idPaquete);
        
        listaEstados=(List<Estados>)query.list();
        
    }catch(HibernateException e){
    System.out.println("Error catch");    
    }
    finally {
        if(session != null){
        session.close();}
    }
     return listaEstados;
}
    @Override
        public void insertar(Estados estado){
          Session session=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(estado);

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

