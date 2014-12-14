package com.database.DAO;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class courseDAO {
	public static void addCourse(Course u){
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
	
	
	
	 public static void listCourses( ){
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         List Users = session.createQuery("FROM Course").list(); 
	         for (Iterator iterator = Users.iterator(); iterator.hasNext();){
	            Course employee = (Course) iterator.next(); 
	            System.out.println("**************");
	            System.out.print("Email: " + employee.getCoursestatus()); 
	            System.out.print("Name: " + employee.getCourseid());  
	         }
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }
	   }
	
	
	
	
	public static void DeleteCourse(int courseid){
		  Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	      Transaction tx = null;
	     
	      try{
	         tx = session.beginTransaction();
	         Course g = (Course)session.get(Course.class, courseid); 
	         session.delete(g); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }
	   }
	
	
	public static Course getCourse(int courseid){
		  Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	      Transaction tx = null;
	      Course g =null;
	      try{
	         tx = session.beginTransaction();
	         g= (Course)session.get(Course.class, courseid);  
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }
	      return g;
	   }

	public static boolean IsPresent(Course u) {
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		 Transaction tx = session.beginTransaction();
	     String hql = "FROM User g WHERE g.email= :id";
	     Query query = session.createQuery(hql);
	     query.setParameter("id", u.getCoursename());
	     List results = query.list();
	    boolean b=results.size()!=0;
	    tx.commit();
		return (b);
	}

	public static void update(Course u) {
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
