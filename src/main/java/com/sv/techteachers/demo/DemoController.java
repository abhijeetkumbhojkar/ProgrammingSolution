package com.sv.techteachers.demo;


import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Session;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.hibernate.*;

import com.database.DAO.GCM;
import com.database.DAO.HibernateUtil;
import com.database.DAO.User;



@RestController
@RequestMapping("/help")
public class DemoController {
	
	@RequestMapping(value = "/demo")
	public String Demo(@RequestBody String j)
	{
		System.out.println(" This is coming value" +j.toString());
		String s = new String("Congratz !! Successfully run the demo");

        try {
			GCM g = new ObjectMapper().readValue(j, GCM.class);
		
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        //User u1 = new User("Java");
        
        
      
 
		person p = new person();
		return "Authtoken";
	}
	
	@RequestMapping("/demo2")
	public person Demo2()
	{
		person p = new person();
		return p;
	}
	
	class person
	{
		public String name="savitru";
		public String passwd = "passwprd";
		
		
	}
	
}
