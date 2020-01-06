package com.revature.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.ReimbursementDTO;
import com.revature.models.Reinbursements;
import com.revature.models.Users;
import com.revature.services.UserServices;

public class ReinbursementServlet extends HttpServlet{

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3713031912491763286L;

	
	
	private static ObjectMapper om = new ObjectMapper();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		HttpSession session = req.getSession();
		int userID = (int) session.getAttribute("userID");
		BufferedReader reader = req.getReader();
		
		StringBuilder s = new StringBuilder();
		String line = reader.readLine();
		while(line != null) {
			s.append(line);
			line = reader.readLine();
		}
		
		String body = s.toString();
	
		ReimbursementDTO rein = om.readValue(body, ReimbursementDTO.class);
	    
		;
		UserServices us = new UserServices();
		Reinbursements reim = us.createReinbursement(rein, userID);
		
	
		boolean c = us.addReinbursement(reim);
		ArrayList<Reinbursements> rlist= UserServices.getAllReinbursements();	
		
		Reinbursements reim2 = rlist.get(rlist.size() - 1);
		
	

		String uname = UserServices.getUsernameById(userID);
		
		boolean w = UserServices.isManager(uname);
		
		 if(w) {
			
	     UserServices.addReim3(reim2, userID);	 
			 
		 }
		if(!w) {
		
		
		UserServices.addReim2(reim2, userID);
		}
	    
		
		if(c) {
		res.setStatus(201);	
		}
	      
		
		
		//rein.setAuthor(userid);
		
	}
	
	
	
	
	
}
