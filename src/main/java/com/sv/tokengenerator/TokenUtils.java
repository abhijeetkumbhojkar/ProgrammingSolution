package com.sv.tokengenerator;

import java.io.IOException;
import java.nio.file.attribute.UserDefinedFileAttributeView;

import org.apache.catalina.User;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TokenUtils {

	@RequestMapping(value="/generateNewToken")
	public userDetails generateNewToken(@RequestBody userDetails det)
	{
			System.out.println(det.toString());
		//to do write some appropriate method to generate unique method
		return det;
	}

	static class userDetails
	{
		private String username;
		private String password;
		@Override
		public String toString() {
			return "userDetails [name=" + username + ", password=" + password + "]";
		}
		public userDetails(String username, String password) {
			super();
			this.username = username;
			this.password = password;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public userDetails() {
			super();
		}
	}
	
}
