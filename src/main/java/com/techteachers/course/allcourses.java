package com.techteachers.course;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.database.DAO.Course;
import com.database.DAO.courseDAO;

@RestController
public class allcourses {
	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public Exception handleException(Exception e) {
	    return e;
	}
	
	
	@RequestMapping(value="/getcoursefile")
	public ResponseEntity<byte[]> GetCourseFile(@RequestBody String input)
	{
		System.out.println("****************");
		Course course = courseDAO.getCourse(1);
        byte[] file = course.getCoursefile();
        System.out.println("****************"+file);
        
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("text/plain"));
        String filename = "image.txt";
	    headers.setContentDispositionFormData(filename, filename);
	    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
	    ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(file, headers, HttpStatus.CREATED);
        return response;
       
	}
}
