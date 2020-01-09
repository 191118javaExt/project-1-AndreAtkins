package com.revature.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

import com.revature.models.EmployeeDTO;
import com.revature.models.ReimbursementDTO;
import com.revature.models.Reinbursements;
import com.revature.models.Users;
import com.revature.repositories.ReinbursementDAOImp;
import com.revature.repositories.UserDAOImp;

public class UserServices {

	
	static UserDAOImp ud = new UserDAOImp();
	static ReinbursementDAOImp rd = new ReinbursementDAOImp();
	public static HashMap<String, String> membermap = getUsersFromDataBaseMap();
	public static HashMap<String, Users> usermap = getUsersFromDataBaseUserList();
	public static HashMap<String, Integer> idmap = getIdMap(); 
	public static HashMap<Integer, String> idtonamemap = getNameByIdMap(); 
	public static ArrayList<Reinbursements> rlist= rd.getAllReinbursements();
	public HashMap<Integer, Reinbursements> reIdmap = getReimByIdMap();
	//public HashMap<Reinbursements, Integer> Idtoremap = getIdByReimMap();
	
	
 public static ArrayList<Reinbursements> getAllReinbursements(){
		
		
		return rd.getAllReinbursements();
	}		
		
	
 public static Users addReim2 (Reinbursements re, int id){
	
	 ArrayList<Reinbursements> rlist2 =	 getReinbursementsForUser(id);
	 
	 rlist2.add(re);
	 
	 String uname = getUsernameById(id);
	 
	 Users user =  getUserByName(uname);
	 
	 user.setUserReim(rlist2);
	
	 return user;
	 
	
	 
	 
 }
 
 public static Users addReim3 (Reinbursements re, int id){
		
	 ArrayList<Reinbursements> rlist =getAllReinbursements();
	 
	 rlist.add(re);
	 
	 String uname = getUsernameById(id);
	 
	 Users user =  getUserByName(uname);
	 
	 user.setUserReim(rlist);
	
	 return user;
	 
	 
	 
	 
 }
 
 
 public static ArrayList<Reinbursements> addReim4 (Reinbursements re){
		
	 ArrayList<Reinbursements> rlist =getAllReinbursements();
	 
	 rlist.add(re);
//	 
//	 String uname = getUsernameById(id);
//	 
//	 Users user =  getUserByName(uname);
	 
	
	
	 return rlist;
	 
	 
	 
	 
 }
 
 
  public static boolean isManager (String username) {
	
	  
	Users user1 =  getUserByName(username);
	int role = user1.getRoleId();
	 
	if(role ==2) {
		
		return true;
	}
  
	System.out.println(role + "manag func");  
	  return false;
	  
	  
	  
  }
 
 
 
 
 public static ArrayList<Reinbursements> AddtoReinbursementsList(Reinbursements re){
	
		
		rlist.add(re);
	
	   return rlist;
		
	}		
		
 
 

 
 public static HashMap<Integer, Reinbursements> getReimByIdMap(){
	 
	 
	 
	 return rd.getReimByIdMap();
	 
 }
 
 public static Reinbursements getReById(int id) {

	 HashMap<Integer, Reinbursements> remap =  getReimByIdMap();
	
	 Reinbursements rein = remap.get(id);
	 
	 return rein;
	 
 }

 public static ArrayList<Reinbursements> getReinbursementsForUser(int id){
  
	 
     //ArrayList<Reinbursements> reinlist = rlist;
	 ArrayList<Reinbursements> reinlist2 = new ArrayList<Reinbursements>();
       
       ArrayList<Reinbursements> reinlist = getAllReinbursements();
	 
	 for (Reinbursements rein : reinlist) {
		 
		 if(rein.getAuthor() == id) {
			 
			 reinlist2.add(rein);
			 
		 }
		 
	 }
	return reinlist2;
	}
 

 
 public Reinbursements createReinbursement(ReimbursementDTO dto, int author) {
	
	   
	   Reinbursements rein = new Reinbursements(0,dto.getAmount(), createSumbmissionTime(), "N/A", dto.getDescr(), author, 1,0, dto.getTypeId(), dto.getReceipt());
	   
	   
	   return rein;
	   
	   
	   
   }
   
	
	public static String createSumbmissionTime() {
		
		Date dateObj = new Date();
		
		String dateFormat = "yyyy-MM-d    h:mm:ss";
		
		SimpleDateFormat simpleDF = new SimpleDateFormat(dateFormat);
		
		return simpleDF.format(dateObj);
	}
 
	 
	 public static boolean updateStatus(int id, int status , int resolver) {
		
		 
		Reinbursements re = getReById(id);
		re.setStatusId(status);
		re.setResolver(resolver);
		re.setTimeRes(createSumbmissionTime());
		
		if(rd.updateReinbursement(re)) {
			return true;
		} else {
			
		
	 
		 return false;
		 
		}
	 }
	   
	 
	 
	
	
	
	public static HashMap<String, Integer> getIdMap() {
		
		return ud.getIdMap();

	}
	
	public static HashMap<Integer, String> getNameByIdMap(){
		
		
		return ud.getNameByIdMap();
	}
	

	
	public static HashMap<String, String> getUsersFromDataBaseMap(){
		
		return ud.getUsersFromDataBaseMap();
					
	}
	
	
	
	public static HashMap<String, Users> getUsersFromDataBaseUserList() {
		
		return ud.getUsersFromDataBaseUserList();
			
	
	}


    public boolean IsUser(String user) {
		
    	
     boolean c = membermap.containsKey(user); 	  //is username in data base ?
    
    	
    	
    	return c;
  	
    }

    public boolean validateLog(String username, String password){
    	
	
	//boolean a = membermap.containsKey(username);  
	
	String  s = membermap.get(username);
	
	//System.out.println(a);
	System.out.println(s);
	System.out.println(password);
	
	boolean b = s.equals(password); // does username match corresponding password?
	System.out.println(b);
	
	return b;	
}

   
    public static Users getUserByName(String username) {
	
 
    	return usermap.get(username);
    	
    	
    }


  public static void addPassToMap(String username, String password) {
	  
	  membermap.put(username, password);
	  
  } 
    
  public static EmployeeDTO convertToDTO(Users e) {
		return new EmployeeDTO(e.getUserId(),
				e.getFirstname(),
				e.getLastname(),
				e.getUsername(),
				e.getPassword(),
				e.getUserReimbursements());
		       
	}

 
  public static int getIdByUsername(String username) {
	  
	  int id;
	  
	  id = idmap.get(username);
	  
	  return id;
	  
  }
  
  public static String getUsernameById(int id) {
	
	  String username;
	  
	  username = idtonamemap.get(id);
	  
	  return username;
  
  }
  
  
  public static boolean addUser(Users user) {
	  
	  return ud.addUser(user);
	  
  }
  
  
  public boolean addReinbursement(Reinbursements rein) {
	  
	  return rd.addReinbursement(rein);
	  
  }
  
}
