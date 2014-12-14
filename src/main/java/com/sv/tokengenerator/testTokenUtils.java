package com.sv.tokengenerator;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONException;
import org.json.JSONObject;


public class testTokenUtils {


	    public static void main(String[] args)  {

	    	String url="http://localhost:8080/TechTeachers/generateNewToken";

	    	URL object = null;
			try {
				object = new URL(url);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    	HttpURLConnection con=null;
			try {
				con = (HttpURLConnection) object.openConnection();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    	
	    	try {
	    		con.setDoOutput(true);

		    	con.setDoInput(true);

		    	con.setRequestProperty("Content-Type", "application/json");

		    	con.setRequestProperty("Accept", "application/json");

				con.setRequestMethod("POST");
				
			} catch (ProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    	JSONObject obj = new JSONObject();

	    	

	    	try {
				obj.put("username","adm");
				obj.put("password", "pwd");

		    	
		    	OutputStreamWriter wr= new OutputStreamWriter(con.getOutputStream());

		    	try {
					wr.write(obj.toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		    	try {
					wr.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		    	//display what returns the POST request

		    	StringBuilder sb = new StringBuilder();  

		    	int HttpResult = 0;
				try {
					HttpResult = con.getResponseCode();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 

		    	if(HttpResult ==HttpURLConnection.HTTP_OK){

		    	    BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"utf-8"));  

		    	    String line = null;  

		    	    try {
						while ((line = br.readLine()) != null) {  
						sb.append(line + "\n");  
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  

		    	    try {
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  

		    	    System.out.println(""+sb.toString());  

		    	}else{
		    	    try {
						System.out.println(con.getResponseMessage());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
		    	}  
		    	

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	    		    }

	    
	}
	

