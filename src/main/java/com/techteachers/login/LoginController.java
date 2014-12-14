package com.techteachers.login;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



import com.database.DAO.User;
import com.database.DAO.UserDAO;
import com.sv.techteachers.gcm.Result;

@RestController
public class LoginController {

	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public Exception handleException(Exception e) {
	    return e;
	}
	
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public Exception SignUp(@RequestBody User input)
	{
		System.out.println(input);
		if(!UserDAO.IsPresent(input))
		{
			input.setToken("ttttt");
			
			UserDAO.addUser(input);
			System.out.println("**************1");
		}
		
	
		UserDAO.listUsers();
	Result r = new Result();
	r.result="OK";
	return new Exception();
	}
	
	@RequestMapping("/login")
	public String LogIn(@RequestBody String j)
	{
		System.out.println(j);
		return("authToken");
	}
	
}
