/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Persistencia.HibernateUtil;
import Pojo.Paquetes;
import Pojo.Usuarios;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author seba
 */
public class UsuarioImplementa {
    
   public boolean existeUsuario(String nombre){
   Session session= null;
        boolean result=false;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "from Usuarios u where u.usuario= '" + nombre +"'";
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				result=true;
                                
			}

		} catch (Exception e) {
			throw e;
		}finally{
                if(session==null){
                session.close();
                
                }
                }
                return result;                
   }
    
    public boolean validar(String usuario,String contrasenia){
        
        Session session= null;
        boolean result=false;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "from Usuarios u where u.usuario= '" + usuario
                                + "' and u.pass = '" + contrasenia + "'";
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				result=true;
                                
			}

		} catch (Exception e) {
			throw e;
		}finally{
                if(session==null){
                session.close();
                
                }
                }
                return result;                
    }
   
   public Usuarios obtenerUsuario(String usuario,String contrasenia ){
       Session session=null;
       Usuarios pity = new Usuarios();
       try{
           session = HibernateUtil.getSessionFactory().openSession();
			String hql = "from Usuarios u where u.usuario= '" + usuario
                                + "' and u.pass = '" + contrasenia + "'";
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				pity=(Usuarios) query.uniqueResult();
                        }
                                
		}finally{
                if(session==null){
                session.close();
                
                }
                }
                return pity;
   }
   
    public boolean validarCliente(String usuario,String contrasenia){
        Session session= null;
        boolean result=false;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "from Usuarios u where (u.usuario= '" + usuario
                                + "' and u.pass = '" + contrasenia + "') and u.clientes is not null" ;
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				result=true;
                                
			}

		} catch (Exception e) {
			throw e;
		}finally{
                if(session==null){
                session.close();
                
                }
                }
                return result;
    }
    
    public void grabarUsuario(Usuarios usuario){
    Session session=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(usuario);
            
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
   
   
