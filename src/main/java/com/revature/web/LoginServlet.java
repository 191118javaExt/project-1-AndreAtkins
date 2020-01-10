package com.revature.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.EmployeeDTO;
import com.revature.models.LoginTemplate;
import com.revature.models.Reinbursements;
import com.revature.models.Users;
import com.revature.services.UserServices;

public class LoginServlet extends HttpServlet{
 
UserServices us = new UserServices();
HashMap<String, Users> usermap =  UserServices.usermap;
public static ArrayList<Reinbursements> rlist = UserServices.getAllReinbursements();


 
	private static final long serialVersionUID = 1L;

	//private static Logger logger = Logger.getLogger(LoginServlet.class);
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
		System.out.println(body);
		LoginTemplate loginAttempt = om.readValue(body, LoginTemplate.class);
		String username = loginAttempt.getUsername();
		
		
		String unpassword = loginAttempt.getPassword();
		
		int pass = unpassword.hashCode();
		String password = Integer.toString(pass);
		System.out.println(username+password);
		
	
		UserServices us = new UserServices();
		
		boolean y = us.IsUser(username);
		
		System.out.println(y);
		boolean z = false;
		
		
		System.out.println(y   +" hashcheck" + z);
			
		if(y) {
			
		z =	us.validateLog(username, password);
		
		System.out.println(z);
		}		
				
		if(!y || !z) {

			
			res.setContentType("application/json");
			res.setStatus(204);
					
			
		} else {
			
			
			
			Users user1 = usermap.get(username);
		
		
			
			boolean v = UserServices.isManager(username);
			
			if(v) {
				
				
				ArrayList<Reinbursements> rlist3 = UserServices.getAllReinbursements();
				
				  HttpSession session = req.getSession();
					
					session.setAttribute("username", username);
					
					session.setAttribute("userID",  UserServices.getIdByUsername(username));
					
					PrintWriter outputStream = res.getWriter();
					
					res.setContentType("application/json");
					
					res.setStatus(418);
					
					EmployeeDTO dto = UserServices.convertToDTO(user1);	
					
					dto.setUserReim(rlist3);
					
					
					
					outputStream.println(om.writeValueAsString(dto));
			        
				
			}
			
			if(!v) {
			
		ArrayList<Reinbursements> rlist4 = UserServices.getReinbursementsForUser(UserServices.getIdByUsername(username));
			
			HttpSession session = req.getSession();
			
			session.setAttribute("user", username);
		    
			session.setAttribute("userID", UserServices.getIdByUsername(username));
			
			PrintWriter out1 = res.getWriter();
			
			res.setContentType("application/json");	
			
			res.setStatus(200);	
		    
			EmployeeDTO dto = UserServices.convertToDTO(user1);
			
			dto.setUserReim(rlist4);
	      
			out1.println(om.writeValueAsString((dto)));
			}	
		}
	}
	
	
	
//	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse res)
//		throws ServletException, IOException {
//		String username = req.getParameter("user");
//		String password = req.getParameter("pass");
//
//		
//		System.out.println(username);
//		System.out.println(password);
//		
//		UserServices us = new UserServices();
//		
//		boolean y = us.IsUser(username);
//		
//		
//		if(!y) {
//			PrintWriter out = HtmlTemplate.getHtmlWriter(res);                                                                              
//			//logger.info(username + " has failed to login.");
//			out.println("<h3 style='color:red'>Denied.</h3>");
//			out.println("<p>Username does not exist.</p>");
//			
//			
//		}
//		
//		boolean z = us.validateLog(username, password);
//	  
//		
//	
//		if(z) {
//			HttpSession session = req.getSession();
//			// Gets the current session, or creates one if it did not exist
//			session.setAttribute("user", username);
//			RequestDispatcher rd = req.getRequestDispatcher("user/logpage.html");
//			rd.forward(req, res);
//			//logger.info(username + " has successfully logged in");
//		} else {
//			PrintWriter out = HtmlTemplate.getHtmlWriter(res);                                                                              
//			//logger.info(username + " has failed to login.");
//			out.println("<h3 style='color:red'>Denied.</h3>");
//			out.println("<p>Password is incorrect.</p>");
//		}
//	}

}
