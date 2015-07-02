/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Persistencia.HibernateUtil;
import Pojo.Provincias;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author seba
 */
public class ProvinciasImplementa implements ProvinciasDAO{

    @Override
    public List<Provincias> mostrarProvincias() {
        Session session=null;
        List<Provincias> prov=null;
       
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            Query query=session.createQuery("from Provincias");
            prov=(List<Provincias>) query.list();
        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
        }
        finally{
            if(session!=null){
               session.close();
            }
        }
       return prov;
    }
    
    
}
