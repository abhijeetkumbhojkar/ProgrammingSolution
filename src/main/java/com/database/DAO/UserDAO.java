package com.database.DAO;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAO {
	public static void addUser(User u){
		  Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	      Transaction tx = null;
	   
	      try{
	         tx = session.beginTransaction();
	       
	       session.save(u); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }
	   }
	
	
	
	 public static void listUsers( ){
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         List Users = session.createQuery("FROM User").list(); 
	         for (Iterator iterator = Users.iterator(); iterator.hasNext();){
	            User employee = (User) iterator.next(); 
	            System.out.println("**************");
	            System.out.print("Email: " + employee.getEmail()); 
	            System.out.print("Name: " + employee.getName());  
	         }
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }
	   }
	
	
	
	
	public static void DeleteUser(String email){
		  Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	      Transaction tx = null;
	     
	      try{
	         tx = session.beginTransaction();
	         User g = (User)session.get(User.class, email); 
	         session.delete(g); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }
	   }

	public static boolean IsPresent(User u) {
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		 Transaction tx = session.beginTransaction();
	     String hql = "FROM User g WHERE g.email= :id";
	     Query query = session.createQuery(hql);
	     query.setParameter("id", u.getEmail());
	     List results = query.list();
	    boolean b=results.size()!=0;
	    tx.commit();
		return (b);
	}

	public static void update(User u) {
		Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	   
	      try{
	         tx = session.beginTransaction();
	       
	       session.update(u); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }
		
	}
}
