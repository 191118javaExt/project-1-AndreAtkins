package com.revature.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.revature.models.Reinbursements;

public interface ReinbursementDAO {
	
	
 
	public boolean addReinbursement(Reinbursements rein);
	

    public boolean updateReinbursement(Reinbursements rein);
   
   
    public  ArrayList<Reinbursements> getAllReinbursements();
    
    public HashMap<Integer,Reinbursements> getReimByIdMap();
    
    
   
   
  
	
	
	
	
}

//method that queries the reinbursement table for all reinbursements that match a username