package com.sv.techteachers.gcm;


import java.io.IOException;

import org.springframework.util.StringUtils;

import com.google.android.gcm.server.InvalidRequestException;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

//send_error
//deleted_messages
//gcm
public class TestNotification {

	public static void main(String[] args) {
		final String GCM_API_KEY = "AIzaSyCMtNjMzFC9klAymNPeEVxk8abh5xIhZlY";
	    final int retries = 3;
	    String id = "APA91bHSKFyQxJsqm5mt8IIR35BTZd9D8Mi9p0aMmLnNemh8LYPmWF1Q-PZwhjhVXVYaXXk9N-T5Ec-Ur11ey8SMMW1d25up8LjfPvduIdRp7eSdrmWx9HcfzwmdujSzfYs06MgwSqf5irKNq8t_Yfh8semM8alUSZKV63Y1GFfTGyfVyWVL2jo&deviceid=693ff0f549e14ecd";
	    final String regId = "APA91bE2LX5iRRIwIcAilOeeyfWojH2vGcUfjYEr6OqtPLP9snYPinLZH6gkuvmnLVOAz9NVFJOL4sRgkBSV6GEFS5ekuNJGch2bq102gwCrQe9FgZw7Fh5sdnF03xT1x5WdgxAAuo6NXuaFAGGCJhRx9S9J9Qv7tO9zH5no7G-1RmVAaeSN8lE&deviceid=eb436f392723171c";
	    Sender sender = new Sender(GCM_API_KEY);
	    System.out.println(id.length());
	    Message msg = new Message.Builder()
	    		
	    		.addData("messageType", "send_error")
	    		.addData("error", "Tujhi aai yedi aahe ")
	    		.addData("message", "Tujhya Aaila")
	    	    .addData("other-parameter", "some value")
	    	    .build();
	    

	    try {
	                Result result = sender.send(msg, regId, retries);

	                if (StringUtils.isEmpty(result.getErrorCodeName())) {
	                	System.out.println("GCM Notification is sent successfully");
	                    //return true;
	                }

	                System.out.println("Error occurred while sending push notification :" + result.getErrorCodeName()+ " "+result.toString());
	    } catch (InvalidRequestException e) {
	    	System.out.println("Invalid Request"+ e);
	    } catch (IOException e) {
	    	System.out.println("IO Exception"+ e);
	    }
		
	}
	
}
