/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Persistencia.HibernateUtil;
import Pojo.Paises;
import Pojo.Provincias;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author seba
 */
public class PaisesImplementa implements PaisesDAO {

    @Override
    public List<Paises> mostrarPaises() {
        Session session=null;
        List<Paises> pa=null;
       
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            Query query=session.createQuery("from Paises");
            pa=(List<Paises>) query.list();
        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
        }
        finally{
            if(session!=null){
               session.close();
            }
        }
       return pa;
    }


    
}
