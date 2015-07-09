/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Persistencia.HibernateUtil;
import Pojo.Sucursales;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author seba
 */
public class SucursalesImplementa implements SucursalesDAO{

    @Override
    public List<Sucursales> mostraSucursales() {
       Session session=null;
       List<Sucursales> suc=null;
       
       try{
           session=HibernateUtil.getSessionFactory().openSession();
           Query query=session.createQuery("from Surcursales");
           suc=(List<Sucursales>) query.list();
           System.out.println(suc.get(1).getDescripcion());
       }
       catch(HibernateException e){
           System.out.println(e.getMessage());
       }
       finally{
           if(session!=null){
               session.close();
           }
       }
       return suc;
    }
    
    public List<Sucursales> sucursalesporLocalidad(String loco){
        Session session=null;
       List<Sucursales> suc=null;
       
       try{
           session=HibernateUtil.getSessionFactory().openSession();
           Query query=session.createQuery("from Sucursales where localidades.idLocalidad="+loco);
           suc=(List<Sucursales>) query.list();
       }
       catch(HibernateException e){
           System.out.println(e.getMessage());
       }
       finally{
           if(session!=null){
               session.close();
           }
       }
       return suc;
    }
    @Override
     public List<Sucursales> mostraSucursales2() {
       Session session=null;
       List<Sucursales> suc=null;
       
       try{
           session=HibernateUtil.getSessionFactory().getCurrentSession();
           Query query=session.createQuery("from Surcursales");
           suc=(List<Sucursales>) query.list();
       }
       catch(HibernateException e){
           System.out.println(e.getMessage());
       }
       finally{
           if(session!=null){
               session.close();
           }
       }
       return suc;
    }
}
