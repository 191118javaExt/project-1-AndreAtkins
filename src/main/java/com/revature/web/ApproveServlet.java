package com.revature.web;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.ReimbursementDTO;
import com.revature.models.StatusDTO;
import com.revature.services.UserServices;

public class ApproveServlet extends HttpServlet{

	private static ObjectMapper om = new ObjectMapper();
	
	private static final long serialVersionUID = 5320653372792466163L;
	
	
	
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
			
			HttpSession session = req.getSession();
			int userID = (int) session.getAttribute("userID");
			System.out.println(userID);
			
			
			BufferedReader reader = req.getReader();
			StringBuilder jsonInput = new StringBuilder();
			String line = reader.readLine();
			while(line != null) {
				jsonInput.append(line);
				line = reader.readLine();
			}
			String jsonString = jsonInput.toString();
			StatusDTO statusDTO = om.readValue(jsonString, StatusDTO.class);
			int rID = statusDTO.getId();
			int rStatus = statusDTO.getStatus();
			
			System.out.println(rID +"TESTING APPROVAL");
			
			
			if(UserServices.updateStatus(rID, rStatus, userID)) {
				
				res.setStatus(200);
			}
			
		}
	

}
