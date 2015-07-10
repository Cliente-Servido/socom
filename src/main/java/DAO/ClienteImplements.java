/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Persistencia.HibernateUtil;
import Pojo.Clientes;
import Pojo.Servicios;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Lucas y Priscila
 */
public class ClienteImplements {
    
    
    public Clientes getCliente(Integer id){
    
        Clientes cli=new Clientes();
    Session session= null;
    
    try{
        session=HibernateUtil.getSessionFactory().openSession();
        Query query=session.createQuery("from Clientes s WHERE s.idCliente = :id");
        query.setParameter("id", id);
        cli = (Clientes)query.uniqueResult();
    }catch(HibernateException e){
    System.out.println(e.getMessage());

    }
    finally {
        if(session != null){
        session.close();}
    }return cli;
    
}
}
