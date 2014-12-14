package com.database.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;





import java.text.SimpleDateFormat;



import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.hibernate.Session;

public class CourseTest {
	 public static void main( String[] args )
	    {
	        System.out.println("Hibernate save image into database");
	        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	 
	        session.beginTransaction();
	 
	        //save image into database
	    	File file = new File("D:\\DSC_0395.jpg.");
	    	File file1 = new File("D:\\testin.txt");
	        byte[] bFile = new byte[(int) file.length()];
	        byte[] cFile = new byte[(int) file1.length()];
	 
	        try {
		     FileInputStream fileInputStream = new FileInputStream(file);
		     FileInputStream fileInputStream1 = new FileInputStream(file1);
		     //convert file into array of bytes
		     fileInputStream.read(bFile);
		     fileInputStream1.read(cFile);
		     
		     fileInputStream.close();
		     fileInputStream1.close();
	        } catch (Exception e) {
		     e.printStackTrace();
	        }
	 
	        
	        Course avatar = new Course(cFile,"coursename", "coursestatus",new Date(),new User("thesavitru@gmail.com"));
	        avatar.setCourseicon(bFile);
	 
	        session.save(avatar);
	 
	        //Get image from database
	        Course avatar2 = (Course)session.get(Course.class, avatar.getCourseid());
	        byte[] bAvatar = avatar2.getCourseicon();
	 
	        try{
	            FileOutputStream fos = new FileOutputStream("D:\\testout.jpg"); 
	            fos.write(bAvatar);
	            fos.close();
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	 
	        session.getTransaction().commit();
	    }
}
