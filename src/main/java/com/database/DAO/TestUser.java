package com.database.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TestUser {
	public static void main(String[] args) {
		  
		Session session = HibernateUtil.getSessionFactory().openSession();
		 Transaction tx = session.beginTransaction();
        GCM and1 = new GCM("and1", "nexus");
        GCM and2 = new GCM("and2"," iphone");
         
        User employee1 = new User( "name", "email","loginType", "loginid",
    			"profileurl", "token","password");
        User employee2 = new User();
 
        employee1.getAndroidids().add(and1);
        employee1.getAndroidids().add(and2);
        employee2.getAndroidids().add(and2);
        session.update(employee1);
        tx.commit();
        //employee1.addUser(employee1);
        session.close();
        
       
    }
}
