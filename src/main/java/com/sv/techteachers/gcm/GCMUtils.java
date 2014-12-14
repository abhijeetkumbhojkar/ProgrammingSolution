package com.sv.techteachers.gcm;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.database.DAO.GCM;
import com.database.DAO.gcmDAO;

//registration ID=APA91bHWvawBb7oIDCS0zo3KGe82PH2CWzlT-gDYEQV8G5TlNd_p9F1Kj7Zwb92-tR9SZBk_4PcfJA3gR-NTa0HYJnOXRH_xCAhYhs9hvCfJ96XXR8A0wqDoV5ru6RGqgipr63q6ZVKQre_JDpRJFNt_WyCZJj36PgPJo58VmoNYzcmZUPoC-fQ




@RestController
public class GCMUtils {

	/*@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public String handleException(Exception e) {
	    return "return error object instead";
	}*/
	
	@RequestMapping(value="/registerforgcm",method=RequestMethod.POST)
	public Result acceptGCMRegistration(@RequestBody GCM g)
	{
			//GCM g = new ObjectMapper().readValue(input, GCM.class);
			if(!gcmDAO.IsPresent(g))
			{
				gcmDAO.addGCM(g.getRegistrationid(), g.getAndroidid());
				System.out.println("**************1");
			} 
			gcmDAO.listGCMs();
		
		
		Result r = new Result();
		r.result="OK";
		return r;
		//return response;
	}
}
