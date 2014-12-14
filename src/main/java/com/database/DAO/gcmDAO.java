package com.database.DAO;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class gcmDAO {
	public static void addGCM(String regid, String andid){
		  Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	      Transaction tx = null;
	     
	      try{
	         tx = session.beginTransaction();
	         GCM g = new GCM(regid,andid);
	       
	       session.save(g); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }
	   
	   }
	
	
	public static void listGCMs( ){
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         List GCMs = session.createQuery("FROM GCM").list(); 
	         for (Iterator iterator = GCMs.iterator(); iterator.hasNext();){
	            GCM employee = (GCM) iterator.next(); 
	            System.out.println("**************");
	            System.out.print("AndroidName: " + employee.getAndroidid()); 
	            System.out.print("RegistrationId: " + employee.getRegistrationid());  
	         }
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }
	   }
	
	
	public static void DeleteGCM(String regid){
		  Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	      Transaction tx = null;
	     
	      try{
	         tx = session.beginTransaction();
	         GCM g = (GCM)session.get(GCM.class, regid); 
	         session.delete(g); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }
	   }

	public static boolean IsPresent(GCM g) {
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	 
	    Transaction tx = session.beginTransaction();
	     String hql = "FROM GCM g WHERE g.androidid= :id";
	     Query query = session.createQuery(hql);
	     query.setParameter("id", g.getAndroidid());
	     List results = query.list();
	     tx.commit();
	   
		return (results.size()!=0);
	}
	
	
	public static GCM GetGCM(String androidid) {
		 Session session = HibernateUtil.getSessionFactory().openSession();
	   
	     Transaction tx = session.beginTransaction();
	     String hql = "FROM GCM g WHERE g.androidid= :id";
	     Query query = session.createQuery(hql);
	     query.setParameter("id", androidid);
	     List results = query.list();
	     tx.commit();
		return (GCM)results.get(0);
	}
	
	
}
