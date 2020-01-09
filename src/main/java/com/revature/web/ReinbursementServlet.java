package com.revature.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.ReimbursementDTO;
import com.revature.models.Reinbursements;
import com.revature.models.Users;
import com.revature.services.UserServices;
@MultipartConfig

public class ReinbursementServlet extends HttpServlet{

	private static final long serialVersionUID = 3713031912491763286L;
	private static final Logger logger = LogManager.getLogger(ReinbursementServlet.class);
	
	
	private static ObjectMapper om = new ObjectMapper();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		
		
		
		InputStream receiptToSend = null; // input stream of the upload file
		   
		  // obtains the upload file part in this multipart request
		  Part filePart = req.getPart("file");
		  //System.out.println("this is file that is send =" + filePart);
		  if (filePart != null) {
			 // System.out.println("this says file part is not null");
		    receiptToSend = filePart.getInputStream();
		  }
		  HttpSession session = req.getSession(false);
		  
		  byte[] receipt = IOUtils.toByteArray(receiptToSend);

		double amount = Double.parseDouble(req.getParameter("amount"));
		String description = req.getParameter("description");
		int typeID = Integer.parseInt(req.getParameter("typeID"));
		
		
		ReimbursementDTO rein = new ReimbursementDTO(amount, description, typeID, 0, receipt);
		
		
		
		
		//HttpSession session = req.getSession();
		int userID = (int) session.getAttribute("userID");
//		BufferedReader reader = req.getReader();
//		
//		StringBuilder s = new StringBuilder();
//		String line = reader.readLine();
//		while(line != null) {
//			s.append(line);
//			line = reader.readLine();
//		}
//		
//		String body = s.toString();
//	
//		ReimbursementDTO rein = om.readValue(body, ReimbursementDTO.class);
//	    
//		;
		
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
		
		logger.info("User # " + userID + " submitted new reimbursement");
		
		}
	      
		
		
		//rein.setAuthor(userid);
		
	}
	
	
	
	
	
}
