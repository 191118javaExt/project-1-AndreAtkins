package com.revature.driver;

import java.util.HashMap;

import com.revature.models.Reinbursements;
import com.revature.models.Users;
import com.revature.repositories.UserDAOImp;
import com.revature.services.UserServices;

public class Driver {

	
	HashMap<String, Users> usermap =  UserServices.usermap;
	
	
	public static void main(String[] args) {
		
		
		//Users user1 = new Users("andre", "atkins", "aatkins00", "basketball13", "aatkins@gmail.com", 1, 0);
		
		
		System.out.println("check");
		
		String userpassword = "basketball13";
		
		int hash = userpassword.hashCode();
		
		String hashpass = Integer.toString(hash);
		
		Users user2 = new Users("Matt", "Scott", "mscott2001", hashpass, "mscott1001@gmail.com", 1, 100, UserServices.getReinbursementsForUser(1));
		
		
		//System.out.println("check");
	   
        //Reinbursements rein = new Reinbursements(0, 0, null, null, null, 1, 1, 0, 0, null);
        		
		UserServices us = new UserServices();
		
		
		//boolean b = us.isManager("janedoe2001");
		
		//System.out.println(b);
		
		//us.addReinbursement(rein);
		
	    UserServices.addUser(user2);
	   
	    //System.out.println(UserServices.getIdByUsername("johndoe2001"));
	    
	     
	     
	     
       
	}
}
