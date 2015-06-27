/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Persistencia.HibernateUtil;
import Pojo.Localidades;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author seba
 */
public class LocalidadesImplementa implements LocalidadesDAO {

    @Override
    public List<Localidades> mostrarLocalidad() {
        Session session=null;
        List<Localidades> loc=null;
       
       try{
           session=HibernateUtil.getSessionFactory().openSession();
           Query query=session.createQuery("from Localidades");
           loc=(List<Localidades>) query.list();
       }
       catch(HibernateException e){
           System.out.println(e.getMessage());
       }
       finally{
           if(session!=null){
               session.close();
           }
       }
       return loc;
    }
    
    public List<Localidades> localidadesenProvincia(String prov){
        Session session=null;
        List<Localidades> loc=null;
       
       try{
           session=HibernateUtil.getSessionFactory().openSession();
           Query query=session.createQuery("from Localidades where provincias="+ prov);
           loc=(List<Localidades>) query.list();
       }
       catch(HibernateException e){
           System.out.println(e.getMessage());
       }
       finally{
           if(session!=null){
               session.close();
           }
       }
       return loc;
    }
    
}
