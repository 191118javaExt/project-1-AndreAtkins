package com.revature.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.EmployeeDTO;
import com.revature.models.LoginTemplate;
import com.revature.models.RegTemplate;
import com.revature.models.Reinbursements;
import com.revature.models.Users;
import com.revature.services.UserServices;

public class RegisterServlet extends HttpServlet{
	public ArrayList<String> elist = UserServices.getAllEmails();
	
	private static final long serialVersionUID = -5222523771127605128L;
	private static ObjectMapper om = new ObjectMapper();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		BufferedReader reader = req.getReader();
		
		StringBuilder s = new StringBuilder();
		String line = reader.readLine();
		while(line != null) {
			s.append(line);
			line = reader.readLine();
		}
		
		String body = s.toString();
		RegTemplate createAttempt = om.readValue(body, RegTemplate.class);
		String firstname = createAttempt.getFirstname();
		String lastname = createAttempt.getLastname();
		String username = createAttempt.getUsername();	
		String password = createAttempt.getPassword();
		String email = createAttempt.getEmail();
	
		
		//ArrayList<Reinbursements> rlist3 = UserServices.getAllReinbursements();
		
		boolean b = UserServices.IsUser(username);
		boolean e = elist.contains(email);
	
		
		 if (b) {
			
			 res.setContentType("application/json");
			 res.setStatus(204);	 
			 
					 
		 }else {
		
		 if(e) {	 
		
			 res.setContentType("application/json");
			 res.setStatus(208);	 
			  
		 
		 }else {
			 
			 
			 
		 int pass = password.hashCode();
		 
		 String rpassword = Integer.toString(pass);
		
		 Users user1 = new Users (firstname, lastname, username, rpassword, email, 1,0, null);
		 
		 UserServices.addUser(user1);
		 
		 
		 
		 

		
		    HttpSession session = req.getSession();
			
			session.setAttribute("username", username);
			
			session.setAttribute("userID",  UserServices.getIdByUsername(username));
			
			PrintWriter outputStream = res.getWriter();
			
			res.setContentType("application/json");
			
			res.setStatus(200);
			
			EmployeeDTO dto = UserServices.convertToDTO(user1);	
			
			//dto.setUserReim(rlist3);
			
			
			
			outputStream.println(om.writeValueAsString(dto));
		     }
		   
		   }
	
		 }
	
	
	}
	
	

